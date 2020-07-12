package com.conduent.cmaapoc.platform

import com.conduent.cmaapoc.entities.login.LoginModel
import com.conduent.cmaapoc.domain.common.api.APIResponse
import com.conduent.cmaapoc.platform.usecaseimplementations.login.LoginUsecaseLocal
import com.conduent.cmaapoc.platform.usecaseimplementations.login.LoginUsecaseRemote
import org.junit.Test

import org.junit.Assert.*
import java.util.concurrent.CompletableFuture


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class LoginLocalTest {
    @Test
    fun testLoginFailed() {
        System.out.println("****testLoginFailed start****")
        var completableFuture = CompletableFuture<LoginModel.Response>();
        var responseCallback: APIResponse = object : APIResponse {
            override fun onSuccess(response: Any?) {
                System.out.println("Login success ")
                completableFuture.complete(response as LoginModel.Response)
            }

            override fun onFailure(response: Any?) {
                System.out.println("Login failed")
                assertTrue(response != null)
                completableFuture.complete(response as LoginModel.Response)
            }
        }

        var loginRequest: LoginModel.Request = LoginModel().Request()
        loginRequest.userName = "sad"
        loginRequest.deviceId = "sddsa"
        // FIXME: remove hard coding
        loginRequest.deviceType = "Android"
        loginRequest.version = "3"
        loginRequest.password = "dssda"
        loginRequest.firstTimeAccess = false
        var usecase = LoginUsecaseLocal(responseCallback);
        usecase.login(loginRequest)

        var response = completableFuture.get();
        assertTrue(response != null)
        if (response != null) {
            var resp = response as LoginModel.Response;
            if (resp.failureMessage != null) {
                System.out.println("Login failed:" + response.failureMessage)
                assertTrue(!response.failureMessage.isNullOrEmpty())
            }
        }
        System.out.println("****testLoginFailed end****")

    }

    @Test
    fun testLoginSuccess() {

        System.out.println("****testLoginSuccess start****")
        var completableFuture = CompletableFuture<LoginModel.Response>();
        var responseCallback: APIResponse = object : APIResponse {
            override fun onSuccess(response: Any?) {
                System.out.println("Login success")
                completableFuture.complete(response as LoginModel.Response)
            }

            override fun onFailure(response: Any?) {
                assertTrue(response != null)
                System.out.println("Login failed")
                completableFuture.complete(response as LoginModel.Response)
            }

        }

        var loginRequest: LoginModel.Request = LoginModel().Request()
        loginRequest.userName = "bwprince1"
        loginRequest.deviceId = "sddsa"
        // FIXME: remove hard coding
        loginRequest.deviceType = "Android"
        loginRequest.version = "3"
        loginRequest.password = "BWdemo@2"
        loginRequest.firstTimeAccess = false
        var usecase = LoginUsecaseRemote(responseCallback);
        usecase.login(loginRequest)


        var response = completableFuture.get();
        assertTrue(response != null)
        if (response != null) {
            var resp = response as LoginModel.Response;
            assertTrue(resp.failureMessage == null || (resp.failureMessage as String).length == 0)
        }

        System.out.println("****testLoginSuccess end****")
    }
}