package com.practicejw.withme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.join_first_activity.*

class JoinFirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.join_first_activity)


//        회원가입(유저) 버튼 > 회원가입(유저) 페이지 이동
        btnJoinUser.setOnClickListener {
            val myIntent = Intent(this@JoinFirstActivity, JoinUserActivity::class.java)
            startActivity(myIntent)
        }

//        회원가입(트레이너) 버튼 > 회원가입(트레이너)페이지(생성예정) 이동

    }
}