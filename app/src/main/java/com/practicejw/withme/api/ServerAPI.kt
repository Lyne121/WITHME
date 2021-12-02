package com.practicejw.withme.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServerAPI {

    //        레트로핏 라이브러리 세팅 (서버통신 담당)
    companion object {

//        어떤 서버 접속? 기초 주소
        val BASE_URL = "https://api.gudoc.in"

//        라이브러리 설치해야 작성 가능 코드
        private var retrofit : Retrofit? = null

//        비어있는 retrofit 변수를 채우는 함수

        fun getRetrofit() : Retrofit {

            if ( retrofit == null ) {

                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory( GsonConverterFactory.create() )
                    .build()

            }
//          실제 서버 통신 전담 클래스 작성
            return retrofit!!

        }

    }
}