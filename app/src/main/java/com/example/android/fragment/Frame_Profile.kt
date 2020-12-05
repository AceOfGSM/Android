package com.example.android.fragment

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Context.AUDIO_SERVICE
import android.content.Intent
import android.content.Intent.ACTION_CALL
import android.media.AudioManager
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getSystemService
import com.example.android.R
import kotlinx.android.synthetic.main.fragment_frame__home.view.*
import kotlinx.android.synthetic.main.fragment_frame__profile.*
import kotlinx.android.synthetic.main.fragment_frame__profile.view.*


class Frame_Profile : Fragment(){

    @SuppressLint("UseRequireInsteadOfGet", "SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_frame__profile, container, false)
//        val userID : String? = arguments!!.getString("userName")
//        val userEmail : String? = arguments!!.getString("userID")
        var index : Int = 0
        var index1 : Int = 0
//        view.profiName.text = "이름 : ${userID}님"
//        view.proEmail.text = "이메일 : $userEmail"


        view.soundLinear.setOnClickListener {
            index += 1
            if (index == 1){
                sound.setImageResource(R.drawable.ic_baseline_music_off_24)
                soundText.text = "무음"
            } else {
                sound.setImageResource(R.drawable.ic_baseline_music_note_24)
                soundText.text = "소리"
                index = 0
            }
        }
        view.phoneCall.setOnClickListener {
            var intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:072-1234-5789")
            startActivity(intent)
        }
        view.smailToday.setOnClickListener {
            index1 += 1
            if (index1 == 1){
                smailDay.setImageResource(R.drawable.ic_baseline_sentiment_very_dissatisfied_24)
                smailDayText.text = "매우 안좋음"
            }else if(index1 == 2){
                smailDay.setImageResource(R.drawable.ic_baseline_sentiment_dissatisfied_24)
                smailDayText.text = "안좋음"
            }else if(index1 == 3){
                smailDay.setImageResource(R.drawable.ic_baseline_sentiment_satisfied_24)
                smailDayText.text = "그저 그럼"
            }else if(index1 == 4){
                smailDay.setImageResource(R.drawable.ic_baseline_sentiment_satisfied_alt_24)
                smailDayText.text = "좋음"
            }
            else {
                smailDay.setImageResource(R.drawable.ic_baseline_sentiment_very_satisfied_24)
                smailDayText.text = "매우 좋음"
                index1 = 0
            }
        }
        return view
    }

}