package io.kraftsman.multiplatform.data

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val result: Boolean,
    val message: String,
    val user: User? = null,
)
