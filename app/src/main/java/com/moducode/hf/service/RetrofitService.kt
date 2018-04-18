package com.moducode.hf.service

import com.moducode.hf.data.Station
import io.reactivex.Observable
import retrofit2.http.GET

interface RetrofitService {

    @GET("?format=json&size=40")
    fun getStations(): Observable<Station>

}