package com.example.android.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelper {

    private var retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.0.112:8000")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getUserAPI() : UserAPI{
        return retrofit.create(UserAPI::class.java)
    }

    fun getSleepAPI() : SleepAPI{
        return retrofit.create(SleepAPI::class.java)
    }
}