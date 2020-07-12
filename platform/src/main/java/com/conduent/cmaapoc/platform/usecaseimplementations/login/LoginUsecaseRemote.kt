package com.conduent.cmaapoc.platform.usecaseimplementations.login

import com.conduent.cmaapoc.entities.login.LoginModel
import com.conduent.cmaapoc.domain.usecaseinterfaces.login.ILoginUsecase
import com.conduent.cmaapoc.domain.common.api.APIResponse
import com.conduent.cmaapoc.platform.common.api.ApiFactory.apiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

internal class LoginUsecaseRemote : ILoginUsecase {

    val TAG: String = LoginUsecaseRemote::class.java.simpleName;
    private var responseCallback: APIResponse? = null;

    constructor(responseCallback: APIResponse) {
        this.responseCallback = responseCallback;
    }

    override fun login(request: LoginModel.Request) {

        val call: Call<LoginModel.Response> = apiService.login(request)
        call.enqueue(object : Callback<LoginModel.Response> {
            override fun onResponse(call: Call<LoginModel.Response>, response: Response<LoginModel.Response>) {
                // Log.d(TAG, "login success")
                if (response != null) {
                    val status = response.code()
                    if (response.body() != null) {
                        var loginResponse: LoginModel.Response = response.body() as LoginModel.Response;
                        if (status == 200) {
                            if (loginResponse.failureMessage == null || (loginResponse.failureMessage != null && loginResponse.failureMessage?.length === 0)) {
                                responseCallback?.onSuccess(loginResponse)
                            } else {
                                responseCallback?.onFailure(loginResponse)
                            }
                        }
                    }
                }
            }

            override fun onFailure(call: Call<LoginModel.Response>, t: Throwable) {
                responseCallback?.onFailure("Something went wrong while login")
            }
        })
    }
}