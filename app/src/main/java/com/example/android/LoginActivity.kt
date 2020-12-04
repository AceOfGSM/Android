package com.example.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.android.API.RetrofitHelper
import com.example.android.DTO.Responselogin
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginButton.setOnClickListener {
            RetrofitHelper().getUserAPI().login(loginID.text.toString(),loginPwd.text.toString()).enqueue(object : Callback<Responselogin>{
                override fun onResponse(
                    call: Call<Responselogin>,
                    response: Response<Responselogin>
                ) {
                    if (response.isSuccessful) {
                        val intent = Intent(this@LoginActivity, MainUserActivity::class.java)
                        intent.putExtra("userID",response.body()!!.user.name)
                        intent.putExtra("userEmail", response.body()!!.user.email)
                        intent.putExtra("token",response.body()!!.token)
                        startActivity(intent)
                    }
                }

                override fun onFailure(call: Call<Responselogin>, t: Throwable) {
                    Log.d("ERROR", t.toString())
                }

            })
        }
        btnGoSignUp.setOnClickListener {
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }
    }

}