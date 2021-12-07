package com.practicejw.withme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.practicejw.withme.datas.BasicResponse
import kotlinx.android.synthetic.main.join_trainer_activity.*
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Response

class JoinTrainerActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.join_trainer_activity)


        btnJoin.setOnClickListener {

            val inputID = edtIdJoin.text.toString()
            val inputPw = edtPwJoin.text.toString()
            val inputNick = edtNick.text.toString()
            val inputPhone = edtPhone.text.toString()

            apiService.postRequestJoin(
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
                            Toast.LENGTH_SHORT
                        ).show()
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

                PwNot.text = "확인 완료"

            }

            else {
                PwNot.text = "비밀번호 불일치"

            }


        }

    }



}



