package io.kraftsman.multiplatform.ui.screens.mobile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import io.kraftsman.multiplatform.ui.components.DemoOnText
import io.kraftsman.multiplatform.ui.components.LoginForm
import io.kraftsman.multiplatform.ui.components.Logo
import io.kraftsman.multiplatform.ui.components.PasswordForgetLink
import io.kraftsman.multiplatform.ui.components.SignUpLink

object LoginScreen : Screen {

    @Composable
    override fun Content() {
        val username = remember { mutableStateOf(TextFieldValue()) }
        val password = remember { mutableStateOf(TextFieldValue()) }

        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Logo()

            DemoOnText()

            Spacer(modifier = Modifier.height(20.dp))

            Column(
                modifier = Modifier.width(280.dp)
            ) {
                LoginForm(username, password)
            }

            Spacer(modifier = Modifier.height(20.dp))

            PasswordForgetLink()
        }

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            SignUpLink()
        }
    }
}
