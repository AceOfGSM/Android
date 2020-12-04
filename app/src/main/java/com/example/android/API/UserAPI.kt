package com.example.android.API

import com.example.android.DTO.Responselogin
import com.example.android.DTO.Signup
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserAPI {
    @FormUrlEncoded
    @POST("/auth/sign-up")
    fun signUp(
        @Field("email") email : String,
        @Field("password") password : String,
        @Field("name") name : String
    ) : Call<Signup>

    @FormUrlEncoded
    @POST("/auth/login")
    fun login(
        @Field("email") email : String,
        @Field("password") password: String
    ) : Call<Responselogin>
}