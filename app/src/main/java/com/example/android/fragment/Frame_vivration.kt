package com.example.android.fragment

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.android.API.RetrofitHelper
import com.example.android.DTO.SleepData
import com.example.android.R
import kotlinx.android.synthetic.main.fragment_frame_vivration.*
import kotlinx.android.synthetic.main.fragment_frame_vivration.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Frame_vivration : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_frame_vivration, container, false)
        // Inflate the layout for this fragment

        var img = false

        view.setTime.setOnClickListener {

            val hour = if(view.picker.hour < 10){
                "0${view.picker.hour}"
            } else{
                "${view.picker.hour}"
            }
            val minute = if(view.picker.minute < 10){
                "0${view.picker.minute}"
            } else {
                "${view.picker.minute}"
            }
            val time = "$hour:${minute}"

            RetrofitHelper().getVibration().addVibration(SleepData(arguments?.getString("userID")!!, view.title_asmr.text.toString(), img, time)).enqueue(object : Callback<SleepData>{
                override fun onResponse(call: Call<SleepData>, response: Response<SleepData>) {

                }

                override fun onFailure(call: Call<SleepData>, t: Throwable) {
                    
                }

            })

            activity?.finish()

        }

        view.btn_alarm.setOnClickListener {
            img = if(!img){
                view.btn_alarm.setImageResource(R.drawable.on_switch)
                !img
            } else {
                view.btn_alarm.setImageResource(R.drawable.off_switch)
                !img
            }
        }

        view.btn_asmr.setOnClickListener {
            val asmrs = arrayListOf<String>("(Stage1)", "(Stage2)", "(Stage3)", "(Stage4)","(Stage5)")
            val builder = context?.let { it1 -> AlertDialog.Builder(it1)}
            builder?.setTitle("ASMR 선택")

            asmrs.add("취소")

            val items = asmrs.toTypedArray<CharSequence>()

            builder?.setItems(items){ dialogInterface: DialogInterface, count: Int ->
                if(count != asmrs.size-1){
                    view.title_asmr.text = asmrs[count]
                }
            }
            builder?.setCancelable(false)
            val alert = builder?.create()
            alert?.show()
        }

        view.cancel.setOnClickListener {
            activity?.finish()
        }


        return view!!
    }


}