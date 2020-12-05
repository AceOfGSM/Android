package com.example.android

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.android.DTO.ResponseVibration
import kotlinx.android.synthetic.main.item_check_alarm.view.*

class TimeAdapter(context: Context, dataList: ArrayList<ResponseVibration>) : BaseAdapter() {
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
        val converterView = inflater.inflate(R.layout.item_check_alarm, viewGroup, false)

        converterView.item_title.text = mDataList[position].vibrationPatternName

        converterView.item_time.text = mDataList[position].alarmTimeTo
        converterView.item_ring.text = mDataList[position].name

        var isAlarm = mDataList[position].isAlarm

        converterView.item_onoff.setOnClickListener {
            if(isAlarm) {
                converterView.item_onoff.setImageResource(R.drawable.on_switch)
                isAlarm = !isAlarm
            }
            else {
                converterView.item_onoff.setImageResource(R.drawable.off_switch)
                isAlarm = !isAlarm
            }
        }

        return converterView
    }
}