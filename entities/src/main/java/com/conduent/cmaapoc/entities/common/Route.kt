package com.conduent.cmaapoc.entities.common

class Route {

    enum class NavigationInfo {
        PUSH,
        REFRESH,
        POPUP,
        POP
    }
    var id: String? = null
    var path: String?= null
    var nextURL: String?= null
    var navigation: NavigationInfo = NavigationInfo.PUSH

}



