package com.example.android.fragment

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import com.example.android.R
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import kotlinx.android.synthetic.main.fragment_frame__home.view.*
import kotlinx.android.synthetic.main.fragment_frame__sleep.*
import kotlinx.android.synthetic.main.fragment_frame__sleep.view.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList


class Frame_Sleep : Fragment() {

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_frame__sleep, container, false)
        val progress1 = view.findViewById<ProgressBar>(R.id.breakTimeProgress)
        val userID : String? = arguments!!.getString("userName")
        //숙면 데이터 받는 코드
        view.sleepName.setText("${userID!!.substring(0, 1)}님의 수면 분석")


        progress1.setProgress(70)
        //Entry 클래스는 Entry(Float, Float) 형 클래스로 x,y값으로 구성
        //float 형은 데이터 값으로 추정됨
        //우리는 데이터를 받으면 3.0f 또는 3.toFloat 하면 될듯
        val cal = Calendar.getInstance()
        cal.time = Date()
        val df: DateFormat = SimpleDateFormat("yyyy년 MM월 dd일")

        view.todayTime.text = df.format(cal.time)

        view.before.setOnClickListener {
            cal.add(Calendar.DATE, -1)

            view.todayTime.text = df.format(cal.time)
        }
        view.next.setOnClickListener {

            cal.add(Calendar.DATE, +1)

            view.todayTime.text = df.format(cal.time)
        }

        /*val lineDataSet = LineDataSet(arrayList, "test")
        val dataSet = ArrayList<ILineDataSet>()
        dataSet.add(lineDataSet)
        val lineData = LineData(dataSet)
        lineDataSet.color = Color.BLACK
        lineDataSet.setCircleColor(Color.BLACK)

        lineDataSet.setDrawFilled(true)
        lineDataSet.fillColor = Color.BLUE

        view.sleepGraph.data = lineData*/

        return view
    }
}