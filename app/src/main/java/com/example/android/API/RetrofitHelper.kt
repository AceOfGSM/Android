package com.example.android.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitHelper {

    private var retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.0.8:8000")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getUserAPI() : UserAPI{
        return retrofit.create(UserAPI::class.java)
    }

    fun getSleepAPI() : SleepAPI{
        return retrofit.create(SleepAPI::class.java)
    }

    fun getVibration() : Vibration{
        return retrofit.create(Vibration::class.java)
    }
}