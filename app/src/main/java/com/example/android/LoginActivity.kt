package com.example.android

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import cn.pedant.SweetAlert.SweetAlertDialog
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

            val sweetAlertDialog =
                SweetAlertDialog(this@LoginActivity, SweetAlertDialog.PROGRESS_TYPE)
            sweetAlertDialog.progressHelper.barColor = Color.parseColor("#0DE930")
            sweetAlertDialog
                .setTitleText("로그인 중")
                .setCancelable(false)
            sweetAlertDialog.show()
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

                    //    val serviceIntent = Intent(this@LoginActivity, 서비스 이름)

                    } else {
                        showFailDialog()
                    }
                }

                override fun onFailure(call: Call<Responselogin>, t: Throwable) {
                    Log.d("ERROR", t.toString())
                    showFailDialog()
                }

            })
        }
        btnGoSignUp.setOnClickListener {
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }
    }
    fun showFailDialog(){

        val dialog = SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)

        dialog.setCancelable(false)

        dialog.setTitleText("로그인에 실패하였습니다")
            .setConfirmClickListener {
                dialog.dismiss()
            }
            .show()
    }

}