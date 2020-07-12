package com.conduent.cmaapoc.platform.usecaseimplementations.login

import com.conduent.cmaapoc.entities.login.LoginModel
import com.conduent.cmaapoc.domain.usecaseinterfaces.login.ILoginUsecase
import com.conduent.cmaapoc.domain.common.api.APIResponse

internal class LoginUsecaseLocal : ILoginUsecase {
    val TAG: String = LoginUsecaseLocal::class.java.simpleName;
    private var responseCallback: APIResponse? = null;

    constructor(responseCallback: APIResponse) {
        this.responseCallback = responseCallback;
    }

    override fun login(request: LoginModel.Request) {

        if (request.userName.equals("bwprince1", true) && request.password.equals("BWdemo@2", true)) {
            responseCallback?.onSuccess(LoginModel().Response())
        } else {
            var response = LoginModel().Response()
            response.failureMessage = "Login failed, please check user name and password"
            responseCallback?.onFailure(response)

        }

    }
}