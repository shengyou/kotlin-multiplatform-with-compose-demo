package io.kraftsman.server.plugins

import io.kraftsman.multiplatform.data.LoginRequest
import io.kraftsman.multiplatform.data.LoginResponse
import io.kraftsman.server.data.userDatabase
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureLogin() {

    routing {
        post("/users/login") {
            val loginRequest = call.receive<LoginRequest>()
            val loggedInUser = userDatabase.firstOrNull {
                it.username == loginRequest.username &&
                it.password == loginRequest.password
            }

            call.respond(
                LoginResponse(
                    result = (loggedInUser != null),
                    message = if (loggedInUser != null) { "login success" } else { "wrong username and password" },
                    user = loggedInUser
                )
            )
        }
    }
}
