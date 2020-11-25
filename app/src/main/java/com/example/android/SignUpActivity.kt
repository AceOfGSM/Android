package com.example.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        signUp.setOnClickListener {
            if(name.text != null){
                val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
                intent.putExtra("name", name.text.toString())
                setResult(1,intent)
                finish()
            }
        }
    }
}