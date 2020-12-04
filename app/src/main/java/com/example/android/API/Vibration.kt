package com.example.android.API

import com.example.android.DTO.ResponseVibration
import com.example.android.DTO.SleepData
import retrofit2.Call
import retrofit2.http.*

interface Vibration {

    @POST("/vibration/")
    fun addVibration(
        @Body sleepData: SleepData
    ) : Call<SleepData>

    @GET("/vibration/{name}/")
    fun getVibration(
        @Header("Authorization") header : String,
        @Field("name") name : String
    ) : Call<ResponseVibration>

}