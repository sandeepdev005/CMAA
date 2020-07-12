package com.conduent.cmaapoc.presentation.modules.login

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.conduent.cmaapoc.R
import com.conduent.cmaapoc.entities.login.LoginModel
import com.conduent.cmaapoc.presentation.MyApplication
import com.conduent.cmaapoc.presentation.modules.common.IRouter
import com.conduent.cmaapoc.presentation.modules.base.BaseActivity
import com.conduent.cmaapoc.presentation.modules.login.implementations.ILoginInteractor
import com.conduent.cmaapoc.presentation.modules.login.interfaces.ILoginRoutable
import com.conduent.cmaapoc.presentation.modules.login.interfaces.ILoginViewable
import com.conduent.cmaapoc.presentation.utils.Utils


class LoginActivity : BaseActivity(), View.OnClickListener,
    ILoginViewable,
    ILoginRoutable {


    private var loginInteractor: ILoginInteractor? = null
    private var usernameEdt: EditText? = null
    private var passwordEdt: EditText? = null
    private var loginBtn: Button? = null;
    private var loginRouter: IRouter? = null;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        (application as MyApplication).mActivity = this;
        initViews()
        var builder = LoginConfigurator(application, this, this);
        loginInteractor = builder.interactor;
        loginRouter = builder.router
    }

    private fun initViews() {
        usernameEdt = findViewById(R.id.et_userid)
        passwordEdt = findViewById(R.id.et_pwd)
        loginBtn = findViewById(R.id.btn_login)
        loginBtn?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_login -> {
                // validations must be done before we call api
                var userId = usernameEdt?.text.toString();
                var pwd = passwordEdt?.text.toString()
                if (TextUtils.isEmpty(userId)) {
                    showToastMessage(resources.getString(R.string.error_message_enter_user_id))
                } else if (TextUtils.isEmpty(pwd)) {
                    showToastMessage(resources.getString(R.string.error_message_enter_pwd))
                } else {
                    showProgressDialog()
                    loginInteractor?.login(
                        userId,
                        pwd,
                        Utils.getDeviceID(this),
                        true
                    )
                }
            }
        }
    }

    override fun loginSuccess(loginResponse: LoginModel.PresentationModel?) {
        hideProgressDialog()
        showToastMessage(resources.getString(R.string.message_login_success))
        loginRouter?.perform(loginResponse)
    }

    override fun loginFailed(loginResponse: LoginModel.PresentationModel?) {
        hideProgressDialog()
        loginRouter?.perform(loginResponse)
    }


    override fun showMessage(str: String) {
        // here we can decide on how do you represent message to user, it could be dialog or toast or some such
        showToastMessage(str);
    }

    override fun popCurrent() {
        onBackPressed()
    }
}
