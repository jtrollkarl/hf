package com.moducode.hf.dagger

import com.moducode.hf.service.RetrofitFactory
import com.moducode.hf.service.RetrofitService
import dagger.Module
import dagger.Provides

@Module
class RetrofitModule {

    @Provides
    @PresenterScope
    fun retrofitService(): RetrofitService = RetrofitFactory.buildRetrofit(RetrofitService::class.java)

}