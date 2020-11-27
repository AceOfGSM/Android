package com.example.android

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.gson.GsonBuilder
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

        setList()

    }

    override fun onResume() {
        super.onResume()
        setList()
    }

    @SuppressLint("CommitPrefEdits")
    fun getData() : DataList {
        val gson = GsonBuilder().create()
        val sp = getSharedPreferences("data", MODE_PRIVATE)
        val strData = sp.getString("data", "")
        val dummy = ArrayList<SleepData>()
        return if (strData == "") {
            Log.d("TAG", "TEST")
            DataList(dummy)
        } else {
            gson.fromJson(strData, DataList::class.java)
        }
    }

    fun setList(){
        val arrayList = getData().arrayList!!
        list_alarm.adapter = MainAdapter(this@MainActivity, arrayList)
    }
}