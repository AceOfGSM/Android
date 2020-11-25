package com.example.android

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_set_time.*

class SetTime : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_time)

        sunday.setOnClickListener {
            if(sunday.currentTextColor == Color.RED){
                sunday.setTextColor(Color.WHITE)
                sunday.setBackgroundColor(Color.RED)
            } else {
                sunday.setTextColor(Color.RED)
                sunday.setBackgroundColor(Color.WHITE)
            }
        }




    }
}