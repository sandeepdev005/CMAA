package com.conduent.cmaapoc.entities.home

import com.conduent.cmaapoc.entities.common.Route


class HomeModel {

    inner class Request {

    }

    inner class Response {

    }

    inner class PresentationModel {
        var loginstatus: String? = null
        var route: Route? = null
    }
}