package com.practicejw.withme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main_login.*

class MainLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_login)

        btnLogin.setOnClickListener {

//            입력한 id/pw 변수에 저장
            val inputId = edtId.text.toString()
            val InputPw = edtPw.text.toString()

//          서버에 로그인 요청

        }

        btnJoin.setOnClickListener {
            val intent = Intent(this, joinFirstActivity::class.java)
            startActivity(intent)

        }
    }
}