package com.example.android.API

import com.example.android.DTO.ResponseSleepFinish
import com.example.android.DTO.ResponseSleepresult
import com.example.android.DTO.ResponseSleepstart
import retrofit2.Call
import retrofit2.http.*

interface SleepAPI {
    @FormUrlEncoded
    @POST("/sleep-analysis/")
    fun sleepStart(
        @Field("userID") userID : String,
        @Field("sleepData") sleepData : String
    ) : Call<ResponseSleepstart>

    @GET("/sleep-analysis/{sleepAnalysisResultID}/")
    fun getSleep(
        @Header("Authorization") Authorization : String
    ) : Call<ResponseSleepresult>

    @PATCH("/sleep-analysis/sleep-end/{sleepAnalysisResultID}")
    fun patchFinish(

    ) : Call<ResponseSleepFinish>

    @FormUrlEncoded
    @POST("/sleep-analysis/eeg-to-statement/")
    fun eegData30(
        @Field("sleepAnalysisResultID") sleepAnalysisResultID : String,
        @Field("eeg_data") eeg_data : ArrayList<String>
    ) : Call<ResponseSleepFinish>
}