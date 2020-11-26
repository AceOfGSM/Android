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

        monday.setOnClickListener {
            if(monday.currentTextColor == Color.BLACK){
                monday.setTextColor(Color.WHITE)
                monday.setBackgroundColor(Color.BLACK)
            } else {
                monday.setTextColor(Color.BLACK)
                monday.setBackgroundColor(Color.WHITE)
            }
        }

        tuesday.setOnClickListener {
            if(tuesday.currentTextColor == Color.BLACK){
                tuesday.setTextColor(Color.WHITE)
                tuesday.setBackgroundColor(Color.BLACK)
            } else {
                tuesday.setTextColor(Color.BLACK)
                tuesday.setBackgroundColor(Color.WHITE)
            }
        }

        wednesday.setOnClickListener {
            if(wednesday.currentTextColor == Color.BLACK){
                wednesday.setTextColor(Color.WHITE)
                wednesday.setBackgroundColor(Color.BLACK)
            } else {
                wednesday.setTextColor(Color.BLACK)
                wednesday.setBackgroundColor(Color.WHITE)
            }
        }

        thursday.setOnClickListener {
            if(thursday.currentTextColor == Color.BLACK){
                thursday.setTextColor(Color.WHITE)
                thursday.setBackgroundColor(Color.BLACK)
            } else {
                thursday.setTextColor(Color.BLACK)
                thursday.setBackgroundColor(Color.WHITE)
            }
        }

        friday.setOnClickListener {
            if(friday.currentTextColor == Color.BLACK){
                friday.setTextColor(Color.WHITE)
                friday.setBackgroundColor(Color.BLACK)
            } else {
                friday.setTextColor(Color.BLACK)
                friday.setBackgroundColor(Color.WHITE)
            }
        }

        saturday.setOnClickListener {
            if(saturday.currentTextColor == Color.BLUE){
                saturday.setTextColor(Color.WHITE)
                saturday.setBackgroundColor(Color.BLUE)
            } else {
                saturday.setTextColor(Color.BLUE)
                saturday.setBackgroundColor(Color.WHITE)
            }
        }

    }
}