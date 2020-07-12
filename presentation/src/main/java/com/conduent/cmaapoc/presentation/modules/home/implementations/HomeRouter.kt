package com.conduent.cmaapoc.presentation.modules.home.implementations

import android.app.Application
import android.content.Intent
import android.os.Bundle
import com.conduent.cmaapoc.entities.common.Route
import com.conduent.cmaapoc.entities.home.HomeModel
import com.conduent.cmaapoc.presentation.modules.common.IRouter
import com.conduent.cmaapoc.presentation.modules.home.HomeActivity
import com.conduent.cmaapoc.presentation.modules.home.interfaces.IHomeRoutable

class HomeRouter(var application: Application, var routerCallback: IHomeRoutable) : IRouter {

    override fun pop() {
        routerCallback.popCurrent()
    }

    override fun push(route: Route?) {
        when (route?.path) {
            "change_pwd" -> {
                routerCallback.showChangePassword()
            }
        }
    }

    override fun push(route: Route?, bundle: Bundle) {
        when (route?.path) {
            "home" -> {
                var intent = Intent(application, HomeActivity::class.java)
                intent.putExtras(bundle)
                application.startActivity(intent)
            }
        }
    }

    override fun perform(viewModel: Any?) {
        //TODO: how to decide start activity or start activity result
        //TODO: will they say finish current and move next?
        var isResultCapture: Boolean = false
        var isFinishCurrent: Boolean = false

        var presenterModel = viewModel as HomeModel.PresentationModel;

        when (presenterModel.route?.navigation) {
            Route.NavigationInfo.PUSH -> {
                push(presenterModel.route)
            }
            Route.NavigationInfo.POPUP -> {
                routerCallback.showMessage("message")
            }
            Route.NavigationInfo.REFRESH -> {
                // send transaction list
                routerCallback.updateTransactions()
            }
            Route.NavigationInfo.POP -> {
                pop()
            }
        }

    }


    override fun present(msg: String) {
        routerCallback.showMessage(msg)
    }

}