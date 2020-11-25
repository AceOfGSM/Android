package com.example.android

import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userName.text = intent.getStringExtra("name")

        imageView2.setOnClickListener {
            startActivity(Intent(this, SleepActivity::class.java))
        }

        setAlarm.setOnClickListener {
            startActivity(Intent(this@MainActivity, TimeActivity::class.java))
        }

    }
}