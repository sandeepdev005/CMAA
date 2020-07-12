package com.conduent.cmaapoc.domain.usecaseinterfaces.login

import com.conduent.cmaapoc.entities.login.LoginModel


interface ILoginUsecase {
    fun login(loginRequest: LoginModel.Request)
    //forgotPwd()
    //changePwd()
    //loginWithFingersprint()
}

