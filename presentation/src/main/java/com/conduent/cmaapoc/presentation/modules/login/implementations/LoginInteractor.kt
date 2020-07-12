package com.conduent.cmaapoc.presentation.modules.login.implementations

import com.conduent.cmaapoc.entities.login.LoginModel
import com.conduent.cmaapoc.domain.usecaseinterfaces.login.ILoginUsecase
import com.conduent.cmaapoc.domain.usecaseinterfaces.login.ILoginUsecaseProvider
import com.conduent.cmaapoc.domain.common.api.APIResponse
import com.conduent.cmaapoc.domain.common.utilities.Constants
import com.conduent.cmaapoc.platform.usecaseimplementations.login.LoginUsecaseProvider


interface ILoginInteractor {
    fun login(username: String, password: String, deviceId: String, firstTimeAccess: Boolean);
}

class LoginInteractor() : ILoginInteractor {


    var loginUsecaseProvider: ILoginUsecaseProvider? = LoginUsecaseProvider()
    // presenter object is filled by builder
    var apiResponse: APIResponse? = null;

    override fun login(username: String, password: String, deviceId: String, firstTimeAccess: Boolean) {

        var loginUsecase: ILoginUsecase? =
            loginUsecaseProvider?.proivideLoginUsecase(Constants.RequestCategory.REMOTE, apiResponse as APIResponse)
        var loginRequest: LoginModel.Request = LoginModel().Request()
        loginRequest.userName = username
        loginRequest.deviceId = deviceId
        // FIXME: remove hard coding
        loginRequest.deviceType = "Android"
        loginRequest.version = "3"
        loginRequest.password = password
        loginRequest.firstTimeAccess = firstTimeAccess
        loginUsecase?.login(loginRequest)
    }

}