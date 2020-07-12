package com.conduent.benifitwallet.sample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.conduent.cmaapoc.R


class SettingsFragment : Fragment() {

    interface SettingsInterface {
        fun changePwdClicked();
    }

    var settingsInterface: SettingsInterface? = null;
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val toolbar = activity!!.findViewById<View>(R.id.toolbar_top) as Toolbar
        var title: TextView = toolbar.findViewById(R.id.toolbar_title);
        title.setText(resources.getString(R.string.settings_view_title))
        var view: View = inflater.inflate(R.layout.fragment_settings, container, false);
        var chnagePwdBtn: Button = view.findViewById<Button>(R.id.change_pwd);
        chnagePwdBtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                if (settingsInterface != null) {
                    settingsInterface?.changePwdClicked()
                }
            }

        })
        return view;
    }

    public fun setListener(settingsInterface: SettingsInterface) {
        this.settingsInterface = settingsInterface;
    }
}