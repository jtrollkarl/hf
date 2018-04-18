package com.moducode.hf.dagger

import com.moducode.hf.schedulers.SchedulersBase
import dagger.Module
import dagger.Provides

@Module
class SchedulerModule(private val schedulers: SchedulersBase ) {

    @Provides
    @PresenterScope
    fun schedulerBase(): SchedulersBase = schedulers

}