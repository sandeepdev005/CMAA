package com.conduent.cmaapoc.platform.common.api

import com.conduent.cmaapoc.entities.login.LoginModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

internal interface APIService {

    @Headers("Content-Type:application/json")
    @POST("LoginWSPort/authenticateLogin")
    fun login(@Body data: LoginModel.Request): Call<LoginModel.Response>
}