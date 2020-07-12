package com.conduent.cmaapoc.presentation.modules.login.implementations

import android.app.Application
import android.content.Intent
import android.os.Bundle
import com.conduent.cmaapoc.entities.common.Route
import com.conduent.cmaapoc.entities.login.LoginModel
import com.conduent.cmaapoc.presentation.modules.common.IRouter
import com.conduent.cmaapoc.presentation.modules.home.HomeActivity
import com.conduent.cmaapoc.presentation.modules.login.interfaces.ILoginRoutable

class LoginRouter(var application: Application, var routerCallBack: ILoginRoutable): IRouter {

    override fun present(msg: String) {
        routerCallBack.showMessage(msg)
    }

    override fun pop() {
        routerCallBack.popCurrent()
    }

   override fun push(route: Route?) {
        when (route?.path) {
            "home" -> {
                var intent: Intent = Intent(application, HomeActivity::class.java)
                application.startActivity(intent)
            }
        }
    }

    override fun push(route: Route?, bundle: Bundle) {
        when (route?.path) {
            "home" -> {
                var b:Bundle = Bundle();
                bundle.putInt("user_id",111);

                var intent: Intent = Intent(application, HomeActivity::class.java)
                intent.putExtra("user_id",111);
                intent.putExtras(bundle)
                application.startActivity(intent)
            }
        }
    }

    // all api responses
    override fun perform(viewModel: Any?) {
        // TODO: how to decide start activity or start activity result
        // TODO: will they say finish current and move next?
        var isResultCapture: Boolean = false
        var isFinishCurrent: Boolean = false

        var presenterModel = viewModel as LoginModel.PresentationModel;

        when (presenterModel.route?.navigation) {
            Route.NavigationInfo.PUSH -> {
                routerCallBack.popCurrent()
                push(presenterModel.route)
            }
            Route.NavigationInfo.POPUP -> {
                routerCallBack.showMessage(presenterModel.loginstatus as String)
            }
            Route.NavigationInfo.REFRESH -> {
                // Call refresh function of corresponding view via routerCallBack
            }
            Route.NavigationInfo.POP -> {
                pop()
            }

        }
    }

}