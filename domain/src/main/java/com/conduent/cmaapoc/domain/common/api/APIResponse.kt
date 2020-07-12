package com.conduent.cmaapoc.domain.common.api

interface APIResponse {
    fun onSuccess(response:Any?)
    fun onFailure(response:Any?)
}