package com.moducode.hf.ui.fragment

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.moducode.hf.data.Program
import com.moducode.hf.schedulers.SchedulersBase
import com.moducode.hf.service.StationsService
import timber.log.Timber
import javax.inject.Inject

class ProgramsPresenter
    : MvpBasePresenter<StationFragmentContract.View>(), StationFragmentContract.Actions {

    @Inject lateinit var service: StationsService
    @Inject lateinit var schedulers: SchedulersBase

    override fun fetchPrograms(pullToRefresh: Boolean) {
        ifViewAttached { it.showLoading(pullToRefresh) }

        service.getStations()
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui())
                .subscribe(
                        { next -> ifViewAttached { it.setData(next.programs) } },
                        { error -> ifViewAttached { it.showError(error, pullToRefresh) } },
                        { ifViewAttached { it.showContent() }
                            Timber.d("Complete") }
                )

    }

    override fun handleProgramClick(program: Program) = ifViewAttached { it.programClicked(program) }
}