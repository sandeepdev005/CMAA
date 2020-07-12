package com.conduent.cmaapoc.presentation.modules.home.interfaces

import com.conduent.cmaapoc.presentation.modules.common.IRoutable

interface IHomeRoutable : IRoutable {
    fun updateTransactions()
    fun showChangePassword()
}