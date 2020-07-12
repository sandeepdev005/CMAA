package com.conduent.cmaapoc.platform.usecaseimplementations.login

import com.conduent.cmaapoc.domain.usecaseinterfaces.login.ILoginUsecase
import com.conduent.cmaapoc.domain.usecaseinterfaces.login.ILoginUsecaseProvider
import com.conduent.cmaapoc.domain.common.api.APIResponse
import com.conduent.cmaapoc.domain.common.utilities.Constants

class LoginUsecaseProvider : ILoginUsecaseProvider {
    override fun proivideLoginUsecase(requestType: Constants.RequestCategory, callback: APIResponse): ILoginUsecase {
        when (requestType) {
            Constants.RequestCategory.LOCAL -> {
                return LoginUsecaseLocal(callback)
            }

            Constants.RequestCategory.REMOTE -> {
                return LoginUsecaseRemote(callback)
            }

        }

    }
}