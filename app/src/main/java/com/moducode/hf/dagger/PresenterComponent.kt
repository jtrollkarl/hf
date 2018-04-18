package com.moducode.hf.dagger

import com.moducode.hf.schedulers.SchedulersBase
import com.moducode.hf.service.RetrofitService
import com.moducode.hf.ui.fragment.ProgramsPresenter
import dagger.Component

@PresenterScope
@Component(modules = [SchedulerModule::class, RetrofitModule::class])
interface PresenterComponent {

    val retrofitService: RetrofitService

    val schedulersBase: SchedulersBase

    fun inject(presenter: ProgramsPresenter)

}