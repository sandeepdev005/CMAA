package com.conduent.cmaapoc.domain.usecaseinterfaces.login

import com.conduent.cmaapoc.domain.common.api.APIResponse
import com.conduent.cmaapoc.domain.common.utilities.Constants


interface ILoginUsecaseProvider {
    fun proivideLoginUsecase(requestType: Constants.RequestCategory, callback: APIResponse): ILoginUsecase
}