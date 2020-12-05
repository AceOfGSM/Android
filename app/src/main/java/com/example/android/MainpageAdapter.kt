package com.example.androidv

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.android.DTO.ResponseVibration
import com.example.android.R
import kotlinx.android.synthetic.main.activity_time.view.*
import kotlinx.android.synthetic.main.item_sleep_alarm.view.*

class MainpageAdapter(context: Context, dataList: ArrayList<ResponseVibration>) : BaseAdapter() {
    val mContext = context
    val mDataList = dataList
    override fun getCount(): Int {

        return mDataList.size
    }

    override fun getItem(p0: Int): Any {
        return mDataList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val inflater = LayoutInflater.from(mContext)
        val convertView = inflater.inflate(R.layout.item_sleep_alarm,p2,false)

        convertView.alarm_title.text = mDataList[p0].name
        convertView.nameOfRing.text = mDataList[p0].vibrationPatternName
        convertView.wake_time.text = mDataList[p0].alarmTimeTo

        var isAlarm = mDataList[p0].isAlarm

        convertView.onoff.setOnClickListener {
            if (isAlarm) {
                convertView.onoff.setImageResource(R.drawable.switch_on)
            } else {
                convertView.onoff.setImageResource(R.drawable.switch_off)
            }
        }
        return convertView
    }
}