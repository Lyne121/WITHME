package com.practicejw.withme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_join_finish.*

class JoinFinishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join_finish)

        btnToLogin.setOnClickListener {
            val myIntent = Intent(this@JoinFinishActivity, MainLoginActivity::class.java)
            startActivity(myIntent)

        }
    }
}