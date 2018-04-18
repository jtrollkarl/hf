package com.moducode.hf.dagger

import com.moducode.hf.schedulers.SchedulersBase
import com.moducode.hf.service.StationsService
import com.moducode.hf.ui.fragment.ProgramsPresenter
import dagger.Component


@Component(modules = [SchedulerModule::class, RetrofitTestModule::class])
interface TestComponent {

    val stationsService: StationsService

    val schedulersBase: SchedulersBase

    fun inject(presenter: ProgramsPresenter)

}