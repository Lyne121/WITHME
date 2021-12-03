package com.practicejw.withme

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.practicejw.withme.api.ServerAPI
import com.practicejw.withme.api.ServerAPIInterface

abstract class BaseActivity: AppCompatActivity() {

//    서버 기능 목록 -> 물려주자

    lateinit var apiService : ServerAPIInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        실제 서버 통신 전담 변수
        val retrofit = ServerAPI.getRetrofit()

//        기능 목록에 결합해서 -> apiService 에 대입
        apiService = retrofit.create( ServerAPIInterface::class.java )

    }


}