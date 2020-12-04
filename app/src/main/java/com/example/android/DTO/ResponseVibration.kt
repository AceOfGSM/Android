package com.example.android.DTO

data class ResponseVibration (
    val id : Int,
    val name : String,
    val isAlarm : Boolean,
    val alarmTimeTo : String,
    val userID : String
    )