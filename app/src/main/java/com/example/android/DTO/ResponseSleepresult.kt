package com.example.android.DTO

data class ResponseSleepresult(
    val id : String,
    val sleepScore : Int,
    val sleepTimeFrom : String,
    val sleepTimeTo : String,
    val deepSleepScore : Int,
    val shallowSleepScore : Int,
    val evalulation : String,
    val sleepDate : String,
    val userID : String,
    val EEGData : ArrayList<Int>
)