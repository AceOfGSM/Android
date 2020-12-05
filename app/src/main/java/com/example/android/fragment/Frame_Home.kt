package com.example.android.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import com.example.android.API.RetrofitHelper
import com.example.android.DTO.ResponseVibration
import com.example.android.R
import com.example.android.TimeActivity
import com.example.android.TimeAdapter
import com.example.androidv.MainpageAdapter
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import kotlinx.android.synthetic.main.fragment_frame__home.*
import kotlinx.android.synthetic.main.fragment_frame__home.view.*
import kotlinx.android.synthetic.main.fragment_frame_vivration.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Frame_Home : Fragment() {
    var arrayList = ArrayList<ResponseVibration>()

    private var root : View? = null
    @SuppressLint("UseRequireInsteadOfGet", "SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_frame__home, container, false)
        // Inflate the layout for this fragment
        val userID : String? = arguments!!.getString("userName")
        root.mainName.text = userID?.substring(0,1)
        root.textName.text = "좋은 꿈 꾸세요 ${userID}님"
        //숙면 데이터 받는 코드

        //region dummy


        //Entry 클래스는 Entry(Float, Float) 형 클래스로 x,y값으로 구성
        //float 형은 데이터 값으로 추정됨
        //우리는 데이터를 받으면 3.0f 또는 3.toFloat 하면 될듯
/*
        val lineDataSet = LineDataSet(arrayList, "test")
        val dataSet = ArrayList<ILineDataSet>()
        dataSet.add(lineDataSet)
        val lineData = LineData(dataSet)
        lineDataSet.color = Color.BLACK
        lineDataSet.setCircleColor(Color.BLACK)

        lineDataSet.setDrawFilled(true)
        lineDataSet.fillColor = Color.BLUE

        root.graph.data = lineData*/

        //알람 여러개 받아 리스트로 띄우기
        setList()

        /*root?.list_alarm!!.setOnItemClickListener{ adapterView: AdapterView<*>, view1: View, position: Int, l: Long ->
            val intent = Intent(context, TimeActivity::class.java)
            intent.putExtra("name", arrayList[position].name)
            intent.putExtra("isAlarm", arrayList[position].isAlarm)
            intent.putExtra("larmTimeTo", arrayList[position].alarmTimeTo)
            intent.putExtra("userEmail", arrayList[position].userEmail)
            intent.putExtra("token", arguments?.getString("token"))
            intent.putExtra("vibrationPatternName", arrayList[position].vibrationPatternName)
            startActivity(intent)
        }*/
        //수면시간 계산해 띄우기

        return root
    }
    override fun onResume() {
        super.onResume()
        setList()
    }
    fun setList(){
        /*RetrofitHelper().getVibration().getVibrationList( arguments?.getString("token")!!).enqueue(object :
            Callback<List<ResponseVibration>> {
            override fun onResponse(
                call: Call<List<ResponseVibration>>,
                response: Response<List<ResponseVibration>>
            ) {
                if(response.isSuccessful){
                    arrayList = (response.body() as ArrayList<ResponseVibration>?)!!
                    if (arrayList.size < 2){
                        root!!.list_alarm.adapter = MainpageAdapter(context!!, arrayList)
                    } else {
                        val datalist = ArrayList<ResponseVibration>()
                        datalist.add(arrayList[0])
                        datalist.add(arrayList[1])
                        root!!.list_alarm.adapter = MainpageAdapter(context!!, datalist)
                    }
                }
            }

            override fun onFailure(call: Call<List<ResponseVibration>>, t: Throwable) {

            }

        })*/
    }
}