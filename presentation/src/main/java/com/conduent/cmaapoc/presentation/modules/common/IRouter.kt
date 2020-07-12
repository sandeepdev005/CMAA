package com.conduent.cmaapoc.presentation.modules.common

import android.os.Bundle
import com.conduent.cmaapoc.entities.common.Route

interface IRouter {
    fun pop()
    fun push(route: Route?)
    fun push(route: Route?, bundle:Bundle)
    fun perform(viewModel: Any?)
    fun present(msg:String)

}