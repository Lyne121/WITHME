package com.practicejw.withme.api

import com.practicejw.withme.datas.BasicResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.PUT

interface ServerAPIInterface {

//    서버가 주는 기능 하나하나를 > 함수 하나하나로 대응

//    로그인 기능

    @FormUrlEncoded
    @POST("/user")
    fun postRequestLogin(

        @Field("email") email: String,
        @Field("password") pw: String,

    ) : Call<BasicResponse>

//    회원가입 기능
    @FormUrlEncoded
    @PUT("/user")
    fun postRequestJoin(

    @Field("email") email: String,
    @Field("password") pw : String,
    @Field("nick_name") nick : String,
    @Field("phone") phone : String,

    ) : Call<BasicResponse>

//    비밀번호 찾기 기능
    @FormUrlEncoded
    @POST("/user/find/password")
    fun postRequestFindPw(

    @Field("nick_name") nick : String,
    @Field("email") email: String,

    ) : Call<BasicResponse>

}