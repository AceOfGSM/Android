package com.example.android.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import com.example.android.R
import com.example.android.TimeActivity
import com.example.android.TimeAdapter
import kotlinx.android.synthetic.main.fragment_frame__home.view.*
import kotlinx.android.synthetic.main.fragment_frame_vivration.view.*

class Frame_vivration : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_frame_vivration, container, false)
        // Inflate the layout for this fragment
        //리스트 받아 띄우는 코드

        //메뉴 버튼 누르면 삭제할거 고르기 고른거는 삭제 ㄱㄱ

        view.alarm_list.setOnItemClickListener{ adapterView: AdapterView<*>, view: View, position: Int, l: Long ->
            
        }


        view.btn_add.setOnClickListener {
            val intent = Intent(context, TimeActivity::class.java)
            intent.putExtra("userID", arguments?.getString("userID"))
            startActivity(intent)
        }

        return view!!
    }


}