package com.conduent.cmaapoc.presentation.modules.home

import android.os.Bundle
import android.view.View
import com.conduent.cmaapoc.entities.common.Route
import com.conduent.cmaapoc.presentation.modules.common.IRouter
import com.conduent.cmaapoc.presentation.modules.base.BaseActivity
import com.conduent.cmaapoc.presentation.utils.Constants
import com.conduent.benifitwallet.sample.ChangePwdFragment
import com.conduent.benifitwallet.sample.SettingsFragment
import com.conduent.cmaapoc.R
import com.conduent.cmaapoc.presentation.modules.home.implementations.HomeRouter
import com.conduent.cmaapoc.presentation.modules.home.interfaces.IHomeRoutable
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity(), IHomeRoutable, SettingsFragment.SettingsInterface {

    var homeRouter: IRouter? = null

    override fun updateTransactions() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home);
        homeRouter = HomeRouter(application, this)

        back.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                homeRouter?.pop()
            }
        })

        var settingsFragment = SettingsFragment();
        settingsFragment.setListener(this)
        addFragment(settingsFragment,R.id.container, Constants.SETTINGS_FRAGMENT_NAME, true, true)
    }

    override fun showMessage(str: String) {
        // here we can decide on how do you represent message to user, it could be dialog or toast or some such
        showToastMessage(str);
    }

    override fun popCurrent() {
        onBackPressed()
    }

    // router callback function to show change password ui
    override fun showChangePassword() {
        addFragment(ChangePwdFragment(),R.id.container, Constants.CHANGE_PWD_FRAGMENT_NAME, true, true);
    }

    // fragment callback function when change password clicked
    override fun changePwdClicked() {

        var route: Route = Route()
        route.nextURL = ""
        route.path = "change_pwd"
        route.navigation = Route.NavigationInfo.PUSH
        homeRouter?.push(route)
    }

}