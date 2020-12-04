package com.example.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android.fragment.Frame_Home
import com.example.android.fragment.Frame_Profile
import com.example.android.fragment.Frame_vivration
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main_user.*

class MainUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_user)
        supportFragmentManager.beginTransaction()
            .replace(R.id.layout_main_Frame, Frame_Home())
            .commitAllowingStateLoss() // 홈 프래그먼트로 넘어감
        
        bottom_navigation_view.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.layout_main_Frame, Frame_Home())
                        .commitAllowingStateLoss() // 홈 프래그먼트로 넘어감
                }
                R.id.sleep_analysis -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.layout_main_Frame, Frame_Profile())
                        .commitAllowingStateLoss() // 작성 프래그먼트로 넘어감
                }
                R.id.vibration_control -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.layout_main_Frame, Frame_vivration())
                        .commitAllowingStateLoss() // 개인정보 화면으로 넘어감
                }
                R.id.my_profile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.layout_main_Frame, Frame_Profile())
                        .commitAllowingStateLoss() // 개인정보 화면으로 넘어감
                }
            }
            true
        }
    }
}