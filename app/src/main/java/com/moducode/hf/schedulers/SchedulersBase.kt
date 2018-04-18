package com.moducode.hf.schedulers

import io.reactivex.Scheduler

interface SchedulersBase {

    fun io(): Scheduler

    fun ui(): Scheduler

    fun computation(): Scheduler
}