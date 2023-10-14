package io.kraftsman.multiplatform.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import io.kraftsman.multiplatform.data.Target
import io.kraftsman.multiplatform.data.User
import io.kraftsman.multiplatform.functions.getTarget
import io.kraftsman.multiplatform.ui.screens.desktop.HomeScreen as DesktopHomeScreen
import io.kraftsman.multiplatform.ui.screens.mobile.HomeScreen as MobileHomeScreen

@Composable
fun LoginForm(
    username: MutableState<TextFieldValue>,
    password: MutableState<TextFieldValue>,
) {
    val navigator = LocalNavigator.currentOrThrow

    TextField(
        value = username.value,
        label = { Text(text = "Username") },
        onValueChange = { username.value = it },
        modifier = Modifier.fillMaxWidth(),
    )

    Spacer(modifier = Modifier.height(20.dp))

    TextField(
        value = password.value,
        label = { Text(text = "Password") },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        onValueChange = { password.value = it },
        modifier = Modifier.fillMaxWidth(),
    )

    Spacer(modifier = Modifier.height(20.dp))

    Button(
        onClick = {
            val user = User(
                id = 1,
                username = "sampleuser",
                password = "samplepassword",
                email = "sampleuser@sample.com",
                displayName = "Sample User",
                profileImageUrl = "https://randomuser.me/api/portraits/men/43.jpg"
            )
            val screen = when (getTarget()) {
                Target.DESKTOP -> DesktopHomeScreen(user)
                else -> MobileHomeScreen(user)
            }

            navigator.push(screen)
        },
        shape = RoundedCornerShape(50.dp),
        modifier = Modifier.fillMaxWidth().height(50.dp)
    ) {
        Text(text = "Login")
    }
}
