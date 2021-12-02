package com.practicejw.withme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.practicejw.withme.datas.BasicResponse
import kotlinx.android.synthetic.main.activity_main_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainLoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_login)

        btnLogin.setOnClickListener {

//            입력한 id/pw 변수에 저장
            val inputId = edtId.text.toString()
            val inputPw = edtPw.text.toString()

//          서버에 로그인 요청 -> BaseActivity가 물려준 서버 기능 목록 활용

            apiService.postRequestLogin(
                inputId,
                inputPw
            ).enqueue( object : Callback<BasicResponse>  {
                override fun onResponse(
                    call: Call<BasicResponse>,
                    response: Response<BasicResponse>
                ) {
//                    서버에 잘 다녀왔을 때 해줄 일

                }

                override fun onFailure(call: Call<BasicResponse>, t: Throwable) {
                }


            } )

        }

        btnJoin.setOnClickListener {
            val intent = Intent(this, joinFirstActivity::class.java)
            startActivity(intent)

        }
    }
}