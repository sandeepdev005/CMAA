package com.conduent.cmaapoc.presentation.modules.login

import android.app.Application
import com.conduent.cmaapoc.presentation.modules.common.IRouter
import com.conduent.cmaapoc.presentation.modules.login.implementations.LoginInteractor
import com.conduent.cmaapoc.presentation.modules.login.implementations.LoginPresenter
import com.conduent.cmaapoc.presentation.modules.login.implementations.LoginRouter
import com.conduent.cmaapoc.presentation.modules.login.interfaces.ILoginRoutable
import com.conduent.cmaapoc.presentation.modules.login.interfaces.ILoginViewable


class LoginConfigurator(application: Application, routerCallBack: ILoginRoutable, viewCallback: ILoginViewable) {

    var interactor: LoginInteractor? = null;
    var presenter: LoginPresenter? = null
    var router: IRouter? = null

    init {
        interactor = LoginInteractor()
        presenter = LoginPresenter(viewCallback)
        router =
            LoginRouter(application, routerCallBack)
        interactor?.apiResponse = presenter
    }

}