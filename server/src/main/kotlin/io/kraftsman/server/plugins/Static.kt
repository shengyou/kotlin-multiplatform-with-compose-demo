package io.kraftsman.server.plugins

import io.ktor.server.application.Application
import io.ktor.server.http.content.resources
import io.ktor.server.http.content.static
import io.ktor.server.routing.routing

fun Application.configureStatic() {
    routing {
        static("static") {
            resources("static")
        }
    }
}
