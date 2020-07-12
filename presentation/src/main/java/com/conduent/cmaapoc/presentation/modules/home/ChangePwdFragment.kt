package com.conduent.benifitwallet.sample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.conduent.cmaapoc.R

class ChangePwdFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val toolbar = activity!!.findViewById<View>(R.id.toolbar_top) as Toolbar
        var title: TextView = toolbar.findViewById<TextView>(R.id.toolbar_title);
        title.setText(resources.getString(R.string.change_password_view_title))
        return inflater.inflate(R.layout.fragment_change_pwd, container, false);
    }
}