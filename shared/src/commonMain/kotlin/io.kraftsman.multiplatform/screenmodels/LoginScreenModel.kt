package io.kraftsman.multiplatform.screenmodels

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import io.kraftsman.multiplatform.data.LoginRequest
import io.kraftsman.multiplatform.data.LoginResponse
import io.kraftsman.multiplatform.data.User
import io.kraftsman.multiplatform.data.apiBaseUrl
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.launch

class LoginScreenModel :
    StateScreenModel<LoginScreenModel.State>(State.Init) {

    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json()
        }
        defaultRequest {
            url(apiBaseUrl)
        }
        expectSuccess = true
    }

    sealed class State {
        data object Init : State()
        data class LoggedIn(val user: User) : State()
    }

    fun login(username: String, password: String) {
        coroutineScope.launch {
            val loginResponse: LoginResponse = httpClient.post("/users/login") {
                setBody(LoginRequest(username, password))
                contentType(ContentType.Application.Json)
            }.body()

            if (loginResponse.result) {
                mutableState.value = State.LoggedIn(loginResponse.user!!)
            }
        }
    }

    override fun onDispose() {
        httpClient.close()
    }
}
