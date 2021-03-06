package com.practicejw.withme

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.TextWatcher
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.practicejw.withme.datas.BasicResponse
import kotlinx.android.synthetic.main.activity_join_trainer.*
import retrofit2.Call
import retrofit2.Response

class JoinTrainerActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join_trainer)

        btnJoin.setOnClickListener {

            val inputID = edtIdJoin.text.toString()
            val inputPw = edtPwJoin.text.toString()
            val inputNick = edtNick.text.toString()
            val inputPhone = edtPhone.text.toString()

            apiService.putRequestJoin(
                inputID,
                inputPw,
                inputNick,
                inputPhone
            ).enqueue(object : retrofit2.Callback<BasicResponse> {
                override fun onResponse(
                    call: Call<BasicResponse>,
                    response: Response<BasicResponse>
                ) {
                    if (response.isSuccessful) {
                        val myIntent =
                            Intent(this@JoinTrainerActivity, JoinFinishActivity::class.java)
                        startActivity(myIntent)

                        finish()
                    } else {
                        Toast.makeText(
                            this@JoinTrainerActivity,
                            "필수 항목을 모두 입력해주세요",
                            Toast.LENGTH_SHORT).show()
                    }

                }

                override fun onFailure(call: Call<BasicResponse>, t: Throwable) {
                }

            })

        }

        edtPwRe.addTextChangedListener {

            val PwRe = edtPwRe.text.toString()
            val Pw = edtPwJoin.text.toString()
            val PwNot = txtPwNot

            if ( PwRe == Pw ) {
                PwNot.text = "일치 확인"
                PwNot.setTextColor( Color.parseColor("#6799FF") )
                }

            else {
                PwNot.text = "비밀번호 불일치"
                PwNot.setTextColor( Color.parseColor("#FF0000"))
                }
        }

        edtPwJoin.addTextChangedListener {
            val PwRe = edtPwRe.text.toString()
            val Pw = edtPwJoin.text.toString()
            val PwNot = txtPwNot

            if ( Pw == PwRe ) {
                PwNot.text = "일치 확인"
                PwNot.setTextColor( Color.parseColor("#6799FF") )
                }

            else {
                PwNot.text = "비밀번호 불일치"
                PwNot.setTextColor( Color.parseColor("#FF0000"))
                }
        }
    }



}



