package com.moducode.hf.dagger

import com.moducode.hf.service.StationsService

import dagger.Module
import dagger.Provides

@Module
class RetrofitTestModule(private val service: StationsService) {

    @Provides
    fun retrofitService(): StationsService = service

}
