package com.conduent.cmaapoc.presentation.modules.login.interfaces

import com.conduent.cmaapoc.entities.login.LoginModel


interface ILoginViewable {
    fun loginSuccess(loginResponse: LoginModel.PresentationModel?)
    fun loginFailed(loginResponse: LoginModel.PresentationModel?)
}
