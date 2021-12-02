package com.practicejw.withme.api

import com.practicejw.withme.datas.BasicResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ServerAPIInterface {

//    서버가 주는 기능 하나하나를 > 함수 하나하나로 대응


//    로그인 기능

    @FormUrlEncoded
    @POST("/user")
    fun postRequestLogin(

        @Field("email") email: String,
        @Field("password") pw: String,

    ) : Call<BasicResponse>

}