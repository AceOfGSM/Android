package com.example.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.android.API.RetrofitHelper
import com.example.android.DTO.Signup
import kotlinx.android.synthetic.main.activity_sign_up.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        signupButton.setOnClickListener {
            if(signupName.text != null){
                if (signupPwd.text.toString() == signupPwdconfirm.text.toString()){
                    RetrofitHelper().getUserAPI().signUp(signupID.text.toString(),signupPwd.text.toString(), signupName.text.toString()).enqueue(object : Callback<Signup>{
                        override fun onResponse(call: Call<Signup>, response: Response<Signup>) {
                            if(response.isSuccessful){
                                val intent = Intent(this@SignUpActivity,LoginActivity::class.java)

                                startActivity(intent)
                            }

                        }

                        override fun onFailure(call: Call<Signup>, t: Throwable) {
                            Toast.makeText(this@SignUpActivity,"에러",Toast.LENGTH_SHORT).show()
                            Log.e("ERROR", t.toString())
                        }

                    })
                }else{
                    Toast.makeText(this,"비밀번호가 맞지 않습니다.",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}