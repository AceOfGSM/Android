package com.example.android.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android.API.RetrofitHelper
import com.example.android.DTO.ResponseVibration
import com.example.android.R
import com.example.android.TimeActivity
import com.example.android.TimeAdapter
import kotlinx.android.synthetic.main.fragment_frame_vivration.*
import kotlinx.android.synthetic.main.fragment_frame_vivration.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.*
import kotlin.collections.ArrayList


class Frame_vivration : Fragment() {
    var arrayList = ArrayList<ResponseVibration>()
    private var root : View? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_frame_vivration, container, false)
        // Inflate the layout for this fragment
        //리스트 받아 띄우는 코드

        setList()



        root?.btn_add!!.setOnClickListener {
            val intent = Intent(context, TimeActivity::class.java)
            intent.putExtra("token", arguments?.getString("token"))
            intent.putExtra("userID", arguments?.getString("userID"))
            startActivity(intent)
        }

        return root
    }

    override fun onResume() {
        super.onResume()
        setList()
    }

    @SuppressLint("UseRequireInsteadOfGet")
    fun setList(){
        RetrofitHelper().getVibration().getVibrationList("jwt " + arguments!!.getString("token")!!).enqueue(
            object : Callback<List<ResponseVibration>> {
                @SuppressLint("SetTextI18n")
                override fun onResponse(
                    call: Call<List<ResponseVibration>>,
                    response: Response<List<ResponseVibration>>
                ) {
                    if (response.isSuccessful) {
                        arrayList = (response.body() as ArrayList<ResponseVibration>?)!!

                        val date = LocalDateTime.now()

                        var currentTime = LocalDateTime.of(2020,12,5, arrayList[0].alarmTimeTo.substring(0,2).toInt(), arrayList[0].alarmTimeTo.substring(3,5).toInt(),0)

                        currentTime =
                            currentTime.minusHours(date.hour.toLong()).minusMinutes(date.minute.toLong())


                        val hour = currentTime.hour
                        val minute = currentTime.minute



                        time_sleep.text = hour.toString() + "시간 " + minute +"분 뒤에 알람이 울려요"

                        root!!.alarm_list.adapter = TimeAdapter(context!!, arrayList)
                    }
                }

                override fun onFailure(call: Call<List<ResponseVibration>>, t: Throwable) {

                }

            })
    }


}