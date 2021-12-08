package com.practicejw.withme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import com.practicejw.withme.datas.BasicResponse
import kotlinx.android.synthetic.main.activity_find_id_pw.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FindIdPwActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_id_pw)

        btnFindPw.setOnClickListener {

            val inputNick = edtNick_findPw.text.toString()
            val inputEmail = edtEmail_findPw.text.toString()

            apiService.postRequestFindPw(
                inputNick,
                inputEmail
            ).enqueue(object : Callback<BasicResponse> {
                override fun onResponse(
                    call: Call<BasicResponse>,
                    response: Response<BasicResponse>
                ) {

                    if ( response.isSuccessful ) {

                        Toast.makeText(this@FindIdPwActivity , "임시 비밀번호가 이메일로 전송되었습니다",Toast.LENGTH_SHORT).show()

                        val myIntent = Intent(this@FindIdPwActivity , MainLoginActivity::class.java)
                        startActivity(myIntent)

                        finish()

                    }

                    else{
                        Toast.makeText(this@FindIdPwActivity, "일치하는 회원 정보가 없습니다. 이름 또는 아이디를 확인해주세요",Toast.LENGTH_SHORT).show()
                    }

                }
                override fun onFailure(call: Call<BasicResponse>, t:Throwable) {
                }

            } )

            }


        Linear_FindId.visibility = View.VISIBLE
        Linear_FindPw.visibility = View.GONE

        btnToFindId.setOnClickListener {

//            1. 아이디찾기 레이아웃 보여주기 (VISIBLE)
            Linear_FindId.visibility = View.VISIBLE

//            2. 비번찾기 레이아웃 숨김 (GONE)
            Linear_FindPw.visibility = View.GONE

        }

        btnToFindPw.setOnClickListener {

//            아이디 찾기 버튼과 반대로 동작
//            1. 비번찾기 레이아웃 보여주기
            Linear_FindPw.visibility = View.VISIBLE

//            2. 아이디찾기 레이아웃 숨기기
            Linear_FindId.visibility = View.GONE

        }
    }

}