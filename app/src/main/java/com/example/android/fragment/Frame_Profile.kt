package com.example.android.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.R
import kotlinx.android.synthetic.main.fragment_frame__home.view.*
import kotlinx.android.synthetic.main.fragment_frame__profile.view.*


class Frame_Profile : Fragment() {

    @SuppressLint("UseRequireInsteadOfGet", "SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_frame__profile, container, false)
        val userID : String? = arguments!!.getString("userID")
        val userEmail : String? = arguments!!.getString("userEmail")
        view.profileName.text = userID!!.substring(0,1)
        view.profiName.text = "${userID}님"
        view.proEmail.text = "$userEmail"
        return view
    }

}