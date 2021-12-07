package com.practicejw.withme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_find_id_pw.*

class FindIdPwActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_id_pw)

        btnFindPw.setOnClickListener {

            val inputNick = edtNick_findPw.text.toString()
            val inputEmail = edtEmail_findPw.text.toString()

            apiService.


    }


}