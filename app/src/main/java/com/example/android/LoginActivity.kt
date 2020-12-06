package com.example.android

import android.annotation.SuppressLint
import android.app.Activity
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
                        sweetAlertDialog.dismiss()
                        val dialog = SweetAlertDialog(this@LoginActivity, SweetAlertDialog.SUCCESS_TYPE)

                        dialog.setCancelable(false)

                        dialog.setTitleText("로그인에 성공하였습니다")
                            .setConfirmClickListener {
                                dialog.dismiss()
                                saveData(loginID.text.toString(), loginPwd.text.toString(), response.body()!!.token)
                                val intent = Intent(this@LoginActivity, MainUserActivity::class.java)
                                intent.putExtra("userID",response.body()!!.user.email)
                                intent.putExtra("userName", response.body()!!.user.name)
                                intent.putExtra("token",response.body()!!.token)
                                startActivity(intent)
                            }
                            .show()


                    //    val serviceIntent = Intent(this@LoginActivity, 서비스 이름)

                    } else {
                        showFailDialog(sweetAlertDialog)
                    }
                }

                override fun onFailure(call: Call<Responselogin>, t: Throwable) {
                    Log.d("ERROR", t.toString())
                    showFailDialog(sweetAlertDialog)
                }

            })
        }
        btnGoSignUp.setOnClickListener {
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }
    }
    fun showFailDialog(sweetAlertDialog : SweetAlertDialog){

        sweetAlertDialog.dismiss()
        val dialog = SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)

        dialog.setCancelable(false)

        dialog.setTitleText("로그인에 실패하였습니다")
            .setConfirmClickListener {
                dialog.dismiss()
            }
            .show()
    }
    @SuppressLint("CommitPrefEdits")
    fun saveData(id : String, pwd : String, token : String){
        val pref = getSharedPreferences("user", Activity.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putString("id", id)
        editor.putString("pwd", pwd)
        editor.putString("token", token)
        editor.apply()
    }
}