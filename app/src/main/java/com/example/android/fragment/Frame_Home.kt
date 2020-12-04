package com.example.android.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.R
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import kotlinx.android.synthetic.main.fragment_frame__home.*
import kotlinx.android.synthetic.main.fragment_frame__home.view.*


class Frame_Home : Fragment() {

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_frame__home, container, false)
        // Inflate the layout for this fragment
        val userID : String? = arguments!!.getString("userID")
        view.mainName.setText("${userID!!.substring(0,1)}")
        view.textName.setText("좋은 꿈 꾸세요 ${userID}님")
        var arrayList = ArrayList<Entry>()
        //숙면 데이터 받는 코드

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

        view.graph.data = lineData

        return view
    }
}