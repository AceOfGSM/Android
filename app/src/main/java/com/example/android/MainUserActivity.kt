package com.example.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.android.fragment.Frame_Home
import com.example.android.fragment.Frame_Profile
import com.example.android.fragment.Frame_Sleep
import com.example.android.fragment.Frame_vivration
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main_user.*

class MainUserActivity : AppCompatActivity() {
    private val fragmentManager : FragmentManager = supportFragmentManager
    private val fragmentHome : Frame_Home = Frame_Home()
    private val fragmentProfile : Frame_Profile = Frame_Profile()
    private val fragmentVivration : Frame_vivration = Frame_vivration()
    private val fragmentSleep : Frame_Sleep = Frame_Sleep()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_user)

        val intent = intent

        val bundle = Bundle()
        bundle.putString("userID", intent.getStringExtra("userID"))
        bundle.putString("userEmail", intent.getStringExtra("userEmail"))
        fragmentVivration.arguments = bundle
        fragmentHome.arguments = bundle
        fragmentProfile.arguments = bundle
        fragmentSleep.arguments = bundle
        val transaction : FragmentTransaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.layout_main_Frame, fragmentHome).commitAllowingStateLoss()
        bottom_navigation_view.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {

                    supportFragmentManager.beginTransaction()
                        .replace(R.id.layout_main_Frame, fragmentHome)
                        .commitAllowingStateLoss() // 홈 프래그먼트로 넘어감
                }
                R.id.sleep_analysis -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.layout_main_Frame, fragmentSleep)
                        .commitAllowingStateLoss() // 작성 프래그먼트로 넘어감
                }
                R.id.vibration_control -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.layout_main_Frame, fragmentVivration)
                        .commitAllowingStateLoss() // 개인정보 화면으로 넘어감
                }
                R.id.my_profile -> {

                    supportFragmentManager.beginTransaction()
                        .replace(R.id.layout_main_Frame, fragmentProfile)
                        .commitAllowingStateLoss() // 개인정보 화면으로 넘어감
                }
            }
            true
        }
    }
}