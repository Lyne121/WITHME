package com.practicejw.withme

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.practicejw.withme.datas.BasicResponse
import kotlinx.android.synthetic.main.activity_main_login.*
import kotlinx.android.synthetic.main.activity_join_trainer.*
import kotlinx.android.synthetic.main.activity_join_user.*
import kotlinx.android.synthetic.main.activity_join_user.edtIdJoin
import kotlinx.android.synthetic.main.activity_join_user.edtNick
import kotlinx.android.synthetic.main.activity_join_user.edtPhone
import kotlinx.android.synthetic.main.activity_join_user.edtPwJoin
import retrofit2.Call
import retrofit2.Response

// BaseActivity를 상속받게 설정해야 함
class JoinUserActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join_user)

        btnJoinU.setOnClickListener {

//            입력한 id, pw, nick, phone 변수에 저장
            val inputIdJoin = edtIdJoin.text.toString()
            val inputPwJoin = edtPwJoin.text.toString()
            val inputNick = edtNick.text.toString()
            val inputPhone = edtPhone.text.toString()

//            서버에 로그인 요청 > BaseActivity가 물려준 서버 기능 목록 활용
            apiService.putRequestJoin(
                inputIdJoin,
                inputPwJoin,
                inputNick,
                inputPhone
                ).enqueue(object : retrofit2.Callback<BasicResponse> {
                    override fun onResponse(
                        call : Call<BasicResponse>,
                        response: Response<BasicResponse>

                    ) {

                        if(response.isSuccessful) {

//                            회원가입 시도 > 회원가입 성공 : 화면이동
                            val myIntent = Intent(this@JoinUserActivity, JoinFinishActivity::class.java)
                            startActivity(myIntent)

                            finish()
                        }

                        else {
//                            회원가입 시도 > 회원가입 실패 : 필수 항목을 모두 작성해주세요
                            Toast.makeText(this@JoinUserActivity, "필수 항목을 모두 입력해주세요", Toast.LENGTH_SHORT).show()
                        }
                }
                override fun onFailure(call: Call<BasicResponse>, t: Throwable) {
                }

                }  )

        }

        edtPwReU.addTextChangedListener {
            val PwRe = edtPwReU.text.toString()
            val Pw = edtPwJoin.text.toString()
            val PwNot = txtPwNotU

            if ( PwRe == Pw ) {
                PwNot.text = "일치 확인"
                PwNot.setTextColor( Color.parseColor("#6799FF") ) //parse의 기본 재료로 RGB 값

            }

            else {
                PwNot.text = "비밀번호 불일치"
                PwNot.setTextColor( Color.parseColor("#FF0000") )

            }
        }

        edtPwJoin.addTextChangedListener {
            val PwRe = edtPwReU.text.toString()
            val Pw = edtPwJoin.text.toString()
            val PwNot = txtPwNotU

            if ( Pw == PwRe ) {
                PwNot.text = "일치 확인"
                PwNot.setTextColor( Color.parseColor("#6799FF") )
            }

            else {
                PwNot.text = "비밀번호 불일치"
                PwNot.setTextColor( Color.parseColor("#FF0000") )
            }
        }
    }
}