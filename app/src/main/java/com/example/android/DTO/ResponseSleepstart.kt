package com.example.android.DTO

data class ResponseSleepstart(
    val id : String,
    val sleepScore : String ?= null,
    val sleepTimeFrom : String ?= null,
    val sleepTimeTo : String ?= null,
    val deepSleepScore : String ?= null,
    val evalulation : String ?= null,
    val sleepDate : String,
    val userID : String
)
