package com.example.android

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_time.*

class TimeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time)

        sleep_add.setOnClickListener {
            startActivity(Intent(this@TimeActivity, SetTime::class.java))
        }

        setList()

    }
    @SuppressLint("CommitPrefEdits")
    fun getData() : DataList {
        val gson = GsonBuilder().create()
        val sp = getSharedPreferences("data", MODE_PRIVATE)
        val strData = sp.getString("data", "")
        val dummy = ArrayList<SleepData>()
        return if (strData == "") {
            DataList(dummy)
        } else {
            gson.fromJson(strData, DataList::class.java)
        }
    }

    fun setList(){
        val arrayList = getData().arrayList!!
        alarm_list.adapter = TimeAdapter(this@TimeActivity, arrayList)
    }

    override fun onResume() {
        super.onResume()
        setList()
    }
}