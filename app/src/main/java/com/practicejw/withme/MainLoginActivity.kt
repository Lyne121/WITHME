package com.practicejw.withme

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.practicejw.withme.datas.BasicResponse
import kotlinx.android.synthetic.main.activity_main_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
// BaseActivity를 상속받게 설정해야 한다 !!
class MainLoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_login)


//        로그인 버튼 > 선생님찾기 페이지(메인페이지) 이동
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

                    if(response.isSuccessful) {

//                        로그인 시도 > 로그인 성공인 경우
//                        해야할 일 : 화면 이동 (Intent)
                        val myIntent = Intent(this@MainLoginActivity, MainSearchTActivity::class.java)
                        startActivity(myIntent)

                        finish()


                    }
                    else {
//                        로그인 시도 > 아이디/비번 실패
//                        해야할 일 : 토스트 출력 (로그인에 실패했습니다.)
                        Toast.makeText(this@MainLoginActivity, "로그인에 실패했습니다.", Toast.LENGTH_SHORT).show()

                    }

                }

                override fun onFailure(call: Call<BasicResponse>, t: Throwable) {
                }


            } )

        }

//        회원가입 버튼 > 회원가입 페이지 이동
        btnJoin.setOnClickListener {
            val intent = Intent(this, JoinFirstActivity::class.java)
            startActivity(intent)

        }
    }
}