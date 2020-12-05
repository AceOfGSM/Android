package com.example.android

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.android.API.RetrofitHelper
import com.example.android.DTO.SleepData
import kotlinx.android.synthetic.main.activity_time.*
import kotlinx.android.synthetic.main.fragment_frame_vivration.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TimeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time)


            var img = false

            setTime.setOnClickListener {

                val hour = if(picker.hour < 10){
                    "0${picker.hour}"
                } else{
                    "${picker.hour}"
                }
                val minute = if(picker.minute < 10){
                    "0${picker.minute}"
                } else {
                    "${picker.minute}"
                }
                val time = "$hour:${minute}"

                RetrofitHelper().getVibration().addVibration(SleepData(intent.getStringExtra("userID")!!, title_asmr.text.toString(), img, time)).enqueue(object :
                    Callback<SleepData> {
                    override fun onResponse(call: Call<SleepData>, response: Response<SleepData>) {

                    }

                    override fun onFailure(call: Call<SleepData>, t: Throwable) {

                    }

                })

                finish()

            }

            btn_alarm.setOnClickListener {
                img = if(!img){
                    btn_alarm.setImageResource(R.drawable.on_switch)
                    !img
                } else {
                    btn_alarm.setImageResource(R.drawable.off_switch)
                    !img
                }
            }

            btn_asmr.setOnClickListener {
                val asmrs = arrayListOf<String>("(Stage1)", "(Stage2)", "(Stage3)", "(Stage4)","(Stage5)")
                val builder = AlertDialog.Builder(this)
                builder.setTitle("ASMR 선택")

                asmrs.add("취소")

                val items = asmrs.toTypedArray<CharSequence>()

                builder.setItems(items){ dialogInterface: DialogInterface, count: Int ->
                    if(count != asmrs.size-1){
                        title_asmr.text = asmrs[count]
                    }
                }
                builder.setCancelable(false)
                val alert = builder.create()
                alert.show()
            }

            cancel.setOnClickListener {
                finish()
            }
        }


}