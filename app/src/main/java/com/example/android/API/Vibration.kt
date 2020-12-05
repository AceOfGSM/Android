package com.example.android.API

import com.example.android.DTO.ResponseVibration
import retrofit2.Call
import retrofit2.http.*

interface Vibration {

    @POST("/vibration/")
    fun addVibration(
        @Body sleepData: ResponseVibration
    ) : Call<ResponseVibration>

    @GET("/vibration/{name}/")
    fun getVibration(
        @Header("Authorization") header : String
    ) : Call<List<ResponseVibration>>

}