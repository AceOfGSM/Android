package com.example.android

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.android.DTO.ResponseVibration
import kotlinx.android.synthetic.main.item_sleep_alarm.view.*

class MainAdapter(context : Context, dataList: ArrayList<ResponseVibration>) : BaseAdapter() {
    val mContext = context
    val mDataList = dataList
    override fun getCount(): Int {
        return mDataList.size
    }

    override fun getItem(i: Int): Any {
        return mDataList[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    @SuppressLint("ViewHolder", "UseCompatLoadingForDrawables")
    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        val inflater = LayoutInflater.from(mContext)
        val converterView = inflater.inflate(R.layout.item_sleep_alarm, viewGroup, false)
        converterView.alarm_title.text = "기본 알람"
        var cnt = 0
        Log.d("TAG", "TEST")



        converterView.nameOfRing.text = mDataList[position].name
        converterView.wake_time.text = mDataList[position].alarmTimeTo

        converterView.onoff.setOnClickListener {
            if(cnt % 2 == 0) {
                converterView.onoff.setImageResource(R.drawable.switch_on)
                cnt++
            }
            else {
                converterView.onoff.setImageResource(R.drawable.switch_off)
                cnt++
            }
        }

        return converterView
    }
}