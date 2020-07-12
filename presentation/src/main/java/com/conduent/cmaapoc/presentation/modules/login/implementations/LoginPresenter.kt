package com.conduent.cmaapoc.presentation.modules.login.implementations

import com.conduent.cmaapoc.entities.login.LoginModel
import com.conduent.cmaapoc.domain.common.api.APIResponse
import com.conduent.cmaapoc.entities.common.Route
import com.conduent.cmaapoc.presentation.modules.login.interfaces.ILoginViewable


class LoginPresenter(var loginViewInterface: ILoginViewable) : APIResponse {

    override fun onSuccess(response: Any?) {
        var loginResponse = response as LoginModel.Response
        var loginPreseneterModel: LoginModel.PresentationModel = LoginModel().PresentationModel();
        loginPreseneterModel.loginstatus = loginResponse.loginstatus


        var route = Route()
        route.nextURL = ""
        route.path = "home"
        route.navigation = Route.NavigationInfo.PUSH
        loginPreseneterModel.route = route

        loginViewInterface.loginSuccess(loginPreseneterModel)
    }

    override fun onFailure(response: Any?) {
        var loginResponse = response as LoginModel.Response
        var loginPreseneterModel: LoginModel.PresentationModel = LoginModel().PresentationModel();
        loginPreseneterModel.loginstatus = loginResponse.failureMessage
        var route = Route()
        route.navigation = Route.NavigationInfo.POPUP
        loginPreseneterModel.route = route
        loginViewInterface.loginFailed(loginPreseneterModel)
    }

}