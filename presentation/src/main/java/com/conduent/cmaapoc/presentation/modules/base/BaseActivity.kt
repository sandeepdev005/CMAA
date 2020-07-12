package com.conduent.cmaapoc.presentation.modules.base

import android.app.ProgressDialog
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.conduent.cmaapoc.R

open class BaseActivity : AppCompatActivity() {

    //TODO: Need to make use of progress bar here
    var progressDialog: ProgressDialog? = null;

    fun showProgressDialog(): Unit {
        if (progressDialog == null) {
            progressDialog = ProgressDialog.show(
                this,
                resources.getString(R.string.app_name),
                resources.getString(R.string.loading_text),
                true
            );
        }
        if (progressDialog != null && !(progressDialog!!.isShowing())) {
            progressDialog!!.show();
        }

    }

    fun hideProgressDialog() {
        if (progressDialog != null && (progressDialog!!.isShowing())) {
            progressDialog!!.dismiss();
        }
    }

    fun showToastMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    fun addFragment(fragment: Fragment, containerId: Int, name: String, replace: Boolean, addBackstack: Boolean) {

        var fragmentManager: FragmentManager = supportFragmentManager;
        var fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction();
        if (replace) {
            fragmentTransaction.replace(containerId, fragment, name)
        } else {
            fragmentTransaction.add(containerId, fragment, name)
        }
        if (addBackstack) {
            fragmentTransaction.addToBackStack(name)
        }
        fragmentTransaction.commitAllowingStateLoss()
    }
}
