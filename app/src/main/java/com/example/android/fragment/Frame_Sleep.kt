package com.example.android.fragment

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.example.android.API.RetrofitHelper
import com.example.android.DTO.ResponseSleepFinish
import com.example.android.R
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import kotlinx.android.synthetic.main.fragment_frame__home.view.*
import kotlinx.android.synthetic.main.fragment_frame__home.view.graph
import kotlinx.android.synthetic.main.fragment_frame__sleep.*
import kotlinx.android.synthetic.main.fragment_frame__sleep.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Frame_Sleep : Fragment() {

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_frame__sleep, container, false)
        val progress1 = view.findViewById<ProgressBar>(R.id.breakTimeProgress)
        val userID : String? = arguments!!.getString("userID")
        var arrayList = ArrayList<Entry>()
        //숙면 데이터 받는 코드
        view.sleepName.setText("${userID!!.substring(0,1)}님의 수면 분석")

        //region dummy
        arrayList.add(Entry(1.0f,1.0f))
        arrayList.add(Entry(2.0f, 3.0f))
        arrayList.add(Entry(3.0f,2.3f))
        arrayList.add(Entry(4.0f,1.0f))
        arrayList.add(Entry(5.0f, 3.0f))
        arrayList.add(Entry(6.0f,2.3f))
        arrayList.add(Entry(7.0f,1.0f))
        arrayList.add(Entry(8.0f, 3.0f))
        arrayList.add(Entry(9.0f,2.3f))
        arrayList.add(Entry(10.0f,1.0f))
        arrayList.add(Entry(11.0f, 3.0f))
        arrayList.add(Entry(12.0f,2.3f))
        arrayList.add(Entry(13.0f,1.0f))
        arrayList.add(Entry(14.0f, 3.0f))
        arrayList.add(Entry(15.0f,2.3f))
        arrayList.add(Entry(16.0f,1.0f))
        arrayList.add(Entry(17.0f, 3.0f))
        arrayList.add(Entry(18.0f,2.3f))
        arrayList.add(Entry(19.0f,1.0f))
        arrayList.add(Entry(20.0f, 3.0f))
        arrayList.add(Entry(21.0f,2.3f))

        progress1.setProgress(70)
        //Entry 클래스는 Entry(Float, Float) 형 클래스로 x,y값으로 구성
        //float 형은 데이터 값으로 추정됨
        //우리는 데이터를 받으면 3.0f 또는 3.toFloat 하면 될듯

        val lineDataSet = LineDataSet(arrayList, "test")
        val dataSet = ArrayList<ILineDataSet>()
        dataSet.add(lineDataSet)
        val lineData = LineData(dataSet)
        lineDataSet.color = Color.BLACK
        lineDataSet.setCircleColor(Color.BLACK)

        lineDataSet.setDrawFilled(true)
        lineDataSet.fillColor = Color.BLUE

        view.sleepGraph.data = lineData

        return view
    }
}