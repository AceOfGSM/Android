package com.example.android.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import com.example.android.API.RetrofitHelper
import com.example.android.DTO.ResponseVibration
import com.example.android.R
import com.example.android.TimeActivity
import com.example.android.TimeAdapter
import kotlinx.android.synthetic.main.fragment_frame_vivration.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


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


        root?.alarm_list!!.setOnItemClickListener{ adapterView: AdapterView<*>, view1: View, position: Int, l: Long ->
            val intent = Intent(context, TimeActivity::class.java)
            intent.putExtra("name", arrayList[position].name)
            intent.putExtra("isAlarm", arrayList[position].isAlarm)
            intent.putExtra("alarmTimeTo", arrayList[position].alarmTimeTo)
            intent.putExtra("userID", arrayList[position].userID)
            intent.putExtra("vibrationPatternName", arrayList[position].vibrationPatternName)
            startActivity(intent)
        }

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

    fun setList(){
        RetrofitHelper().getVibration().getVibration(arguments?.getString("token")!!).enqueue(object : Callback<List<ResponseVibration>>{
            override fun onResponse(
                call: Call<List<ResponseVibration>>,
                response: Response<List<ResponseVibration>>
            ) {
                if(response.isSuccessful){
                    arrayList = (response.body() as ArrayList<ResponseVibration>?)!!
                    root!!.alarm_list.adapter = TimeAdapter(context!!, arrayList)
                }
            }

            override fun onFailure(call: Call<List<ResponseVibration>>, t: Throwable) {

            }

        })
    }


}