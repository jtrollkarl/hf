package com.moducode.hf.dagger

import com.moducode.hf.service.RetrofitFactory
import com.moducode.hf.service.StationsService
import dagger.Module
import dagger.Provides

@Module
class RetrofitModule {

    @Provides
    @PresenterScope
    fun retrofitService(): StationsService = RetrofitFactory.buildRetrofit(StationsService::class.java)

}