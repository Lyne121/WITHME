package com.practicejw.withme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.join_type_activity.*

class JoinTypeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.join_type_activity)


//        회원가입(유저) 버튼 > 회원가입(유저) 페이지 이동
        btnJoinUser.setOnClickListener {
            val myIntent = Intent(this@JoinTypeActivity, JoinUserActivity::class.java)
            startActivity(myIntent)
        }

//        회원가입(트레이너) 버튼 > 회원가입(트레이너)페이지(생성예정) 이동

    }
}