package com.moducode.hf.schedulers

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class SchedulersTest: SchedulersBase {

    override fun io(): Scheduler = Schedulers.trampoline()

    override fun ui(): Scheduler = Schedulers.trampoline()

    override fun computation(): Scheduler = Schedulers.trampoline()

}