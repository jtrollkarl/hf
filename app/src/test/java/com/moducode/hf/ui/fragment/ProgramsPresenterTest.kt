package com.moducode.hf.ui.fragment

import com.moducode.hf.dagger.*
import com.moducode.hf.data.Program
import com.moducode.hf.data.Station
import com.moducode.hf.schedulers.SchedulersBase
import com.moducode.hf.schedulers.SchedulersTest
import com.moducode.hf.service.StationsService
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test

class ProgramsPresenterTest {

    @RelaxedMockK
    lateinit var service: StationsService

    @RelaxedMockK
    lateinit var view: StationFragmentContract.View

    @RelaxedMockK
    lateinit var dumbData: Station

    private val schedulers: SchedulersBase = SchedulersTest()

    private lateinit var subject: ProgramsPresenter

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        val component = DaggerTestComponent
                .builder()
                .retrofitTestModule(RetrofitTestModule(service))
                .schedulerModule(SchedulerModule(schedulers))
                .build()

        subject = ProgramsPresenter()
        subject.attachView(view)
        component.inject(subject)
    }

    @Test
    fun fetchPrograms_ERROR(){
        val t = Throwable("ERROR")

        every { service.getStations() } returns Observable.error(t)

        subject.fetchPrograms(false)

        verify { view.showError(t, false) }
    }

    @Test
    fun fetchPrograms_SUCCESS(){
        every { service.getStations() } returns Observable.just(dumbData)

        subject.fetchPrograms(false)

        verify { view.setData(dumbData.programs) }
        verify { view.showContent() }
    }


    @Test
    fun handleProgramClick(){
        val p = mockk<Program>(relaxed = true)

        subject.handleProgramClick(p)

        verify { view.programClicked(p) }
    }
}