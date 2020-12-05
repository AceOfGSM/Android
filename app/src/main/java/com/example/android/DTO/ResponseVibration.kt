package com.example.android.DTO

data class ResponseVibration (
    val id : Int? = null,
    val name : String,
    val isAlarm : Boolean,
    val alarmTimeTo : String,
    val userID : String,
    val vibrationPatternName : String,
    val token : String
    )