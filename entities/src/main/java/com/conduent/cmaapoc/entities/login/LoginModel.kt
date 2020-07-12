package com.conduent.cmaapoc.entities.login

import com.conduent.cmaapoc.entities.common.Route
import com.google.gson.annotations.SerializedName

class LoginModel {

    inner class Request {

        @SerializedName("userName")
        var userName: String? = null
        @SerializedName("deviceId")
        var deviceId: String? = null
        @SerializedName("deviceType")
        var deviceType: String? = null
        @SerializedName("version")
        var version: String? = null
        @SerializedName("password")
        var password: String? = null
        @SerializedName("firstTimeAccess")
        var firstTimeAccess: Boolean? = true
        //TODO: it should have next url
    }

    inner class Response {

        val showUpdatePopup: Boolean?=null
        val authorization: String?=null
        val lockedFlag: String?=null
        val loginstatus: String?=null
        var failureMessage: String?=null
        val accountNumber: String?=null
        val partnerid: String?=null
        val clientIdentifier: String?=null
        val trustedDevice: Boolean?=null
        val emailCollectionRequired: Boolean?=null
        val esignatureRequired: Boolean?=null
        val termsAndConditionRequired: Boolean?=null
        val securityQuestionScreenRequired: Boolean?=null
        val email: String?=null
        val phoneNumber: Boolean?=null
        val hsaAccount: Boolean?=null
        val textMessagingEnabled: Boolean = false
        val route: Route?=null

    }

    inner class PresentationModel {
        var loginstatus: String? = null
        var route: Route? = null
    }
}

