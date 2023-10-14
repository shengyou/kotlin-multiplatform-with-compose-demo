package io.kraftsman.server

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.kraftsman.server.plugins.*
import io.kraftsman.server.plugins.configureHome
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        install(ContentNegotiation) {
            json()
        }

        configureHome()
        configureStatic()
        configureLogin()
    }.start(wait = true)
}
