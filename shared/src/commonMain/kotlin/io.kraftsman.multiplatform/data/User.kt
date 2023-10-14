package io.kraftsman.multiplatform.data

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Int,
    val username: String,
    val password: String,
    val email: String,
    val displayName: String,
    val profileImageUrl: String,
)
