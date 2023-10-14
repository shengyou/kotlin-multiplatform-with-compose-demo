package io.kraftsman.server.plugins

import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*

fun Application.configureHome() {

    routing {
        get("/") {
            call.respondText("Ktor Server Side API Demo")
        }
    }
}
