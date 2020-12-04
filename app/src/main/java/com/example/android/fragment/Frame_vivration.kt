package com.example.android.fragment

import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.example.android.R
import kotlinx.android.synthetic.main.fragment_frame_vivration.view.*

class Frame_vivration : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_frame_vivration, container, false)
        // Inflate the layout for this fragment


        view.setTime.setOnClickListener {
            val setAmPm = if(view.picker.hour/12 == 1){
                "오후 "
            } else {
                "오전 "
            }
            val hour = if(view.picker.hour%12 < 10){
                "0${view.picker.hour%12}"
            } else{
                "${view.picker.hour%12}"
            }
            val minute = if(view.picker.minute < 10){
                "0${view.picker.minute}"
            } else {
                "${view.picker.minute}"
            }
            val time = "$setAmPm $hour:${minute}"

            activity?.finish()

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