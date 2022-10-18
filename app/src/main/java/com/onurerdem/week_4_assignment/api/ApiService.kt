package com.onurerdem.week_4_assignment.api

import com.onurerdem.week_4_assignment.model.model
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("data/2.5/onecall?")
    fun getWeatherInfo(
        @Query("lat")
        lat: String,
        @Query("lon")
        lon: String,
        @Query("exclude")
        exclude: String,
        @Query("units")
        units: String="metrics",
    ): Call<model>
}