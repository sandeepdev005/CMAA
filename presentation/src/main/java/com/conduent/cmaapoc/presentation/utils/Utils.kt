package com.conduent.cmaapoc.presentation.utils

import android.content.Context
import android.provider.Settings

object Utils {


    /**
     * Returns the unique device ID
     * @return
     */
    fun getDeviceID(context: Context): String {
        return Settings.Secure.getString(
            context.contentResolver,
            Settings.Secure.ANDROID_ID
        )
    }

}