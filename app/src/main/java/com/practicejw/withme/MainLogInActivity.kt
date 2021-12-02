package com.practicejw.withme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.MainLogInActivity.*

class MainLogInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.MainLogInActivity)
//
//
//        회원가입 버튼 > 회원가입 첫화면 이동
        btnJoin.setOnClickListener {
            val intent = Intent(this, JoinFirstActivity::class.java)
            startActivity(Intent)
        }

    }
}