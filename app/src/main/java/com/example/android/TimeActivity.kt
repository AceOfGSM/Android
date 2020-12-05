package com.example.android

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.android.API.RetrofitHelper
import com.example.android.DTO.ResponseVibration
import kotlinx.android.synthetic.main.activity_time.*
import kotlinx.android.synthetic.main.fragment_frame_vivration.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TimeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time)

            var img = intent.getBooleanExtra("isAlarm", false)

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


                RetrofitHelper().getVibration().addVibration(ResponseVibration(id = null,
                    userID = intent.getStringExtra("userID")!!,
                    name = title_alarm.text.toString(), isAlarm = img, alarmTimeTo = time, vibrationPatternName = title_asmr.text.toString(), token = intent.getStringExtra("token")!!)
                ).enqueue(object :
                    Callback<ResponseVibration> {
                    override fun onResponse(call: Call<ResponseVibration>, response: Response<ResponseVibration>) {
                        Log.d("token",response.body()!!.userID)
                        if(response.isSuccessful){
                            Toast.makeText(this@TimeActivity, "추가에 성공하였습니다", Toast.LENGTH_LONG).show()
                            finish()
                        }
                    }

                    override fun onFailure(call: Call<ResponseVibration>, t: Throwable) {
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