package com.example.android

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.NumberPicker
import androidx.appcompat.app.AlertDialog
import com.google.gson.GsonBuilder
import com.google.gson.internal.GsonBuildConfig
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_set_time.*

class SetTime : AppCompatActivity() {
    @SuppressLint("CommitPrefEdits")
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

        setTime.setOnClickListener {
            val arrayList = ArrayList<String>()
            val dataList = getData().arrayList
            if(sunday.currentTextColor == Color.WHITE){
                arrayList.add("일")
            }
            if(monday.currentTextColor == Color.WHITE){
                if(arrayList.size > 0)
                    arrayList.add(",월")
                else
                    arrayList.add("월")
            }

            if(tuesday.currentTextColor == Color.WHITE){
                if(arrayList.size > 0)
                    arrayList.add(",화")
                else
                    arrayList.add("화")
            }

            if(wednesday.currentTextColor == Color.WHITE){
                if(arrayList.size > 0)
                    arrayList.add(",수")
                else
                    arrayList.add("수")
            }

            if(thursday.currentTextColor == Color.WHITE){
                if(arrayList.size > 0)
                    arrayList.add(",목")
                else
                    arrayList.add("목")
            }

            if(friday.currentTextColor == Color.WHITE){
                if(arrayList.size > 0)
                    arrayList.add(",금")
                else
                    arrayList.add("금")
            }

            if(saturday.currentTextColor == Color.WHITE){
                if(arrayList.size > 0)
                    arrayList.add(",토")
                else
                    arrayList.add("토")
            }
            val setAmPm = if(picker.hour/12 == 1){
                "오후 "
            } else {
                "오전 "
            }
            val hour = if(picker.hour%12 < 10){
                "0${picker.hour%12}"
            } else{
                "${picker.hour%12}"
            }
            val minute = if(picker.minute < 10){
                "0${picker.minute}"
            } else {
                "${picker.minute}"
            }
            val time = "$setAmPm $hour:${minute}"
            val data = SleepData(title_alarm.text.toString(), time, arrayList, title_asmr.text.toString())

            val gson = GsonBuilder().create()

            dataList!!.add(data)

            val strData = gson.toJson(DataList(dataList), DataList::class.java)

            val sp = getSharedPreferences("data", MODE_PRIVATE)
            val editor = sp.edit()
            editor.putString("data",strData)
            editor.apply()
            finish()
        }

        btn_asmr.setOnClickListener {
            val asmrs = arrayListOf<String>("(Stage1)", "(Stage2)", "(Stage3)", "(Stage4)","(Stage5)")
            val builder = AlertDialog.Builder(this@SetTime)
            builder.setTitle("ASMR 선택")

            asmrs.add("취소")

            val items = asmrs.toTypedArray<CharSequence>()

            builder.setItems(items){ dialogInterface: DialogInterface, count: Int ->
                if(count != asmrs.size-1){
                    title_asmr.text = asmrs[count]
                }
            }
            builder.setCancelable(false)
            val alert = builder.create()
            alert.show()
        }

        btn_alarm.setOnClickListener {
            val alarms = arrayListOf<String>("기본", "운동", "회사")
            val builder = AlertDialog.Builder(this@SetTime)
            builder.setTitle("알람 선택")

            alarms.add("취소")

            val items = alarms.toTypedArray<CharSequence>()

            builder.setItems(items){ dialogInterface: DialogInterface, count: Int ->
                if(count != alarms.size-1){
                    title_alarm.text = alarms[count]
                }
            }
            builder.setCancelable(false)
            val alert = builder.create()
            alert.show()
        }

        cancel.setOnClickListener {
            finish()
        }
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

}