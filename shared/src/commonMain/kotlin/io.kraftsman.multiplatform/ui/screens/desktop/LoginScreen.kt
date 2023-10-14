package io.kraftsman.multiplatform.ui.screens.desktop

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import io.kraftsman.multiplatform.screenmodels.LoginScreenModel
import io.kraftsman.multiplatform.ui.components.DemoOnText
import io.kraftsman.multiplatform.ui.components.LoginForm
import io.kraftsman.multiplatform.ui.components.Logo
import io.kraftsman.multiplatform.ui.components.PasswordForgetLink
import io.kraftsman.multiplatform.ui.components.SignUpLink

object LoginScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val screenModel = rememberScreenModel { LoginScreenModel() }
        val state by screenModel.state.collectAsState()

        val username = remember { mutableStateOf(TextFieldValue()) }
        val password = remember { mutableStateOf(TextFieldValue()) }

        when (val loggedInState = state) {
            is LoginScreenModel.State.Init -> { }
            is LoginScreenModel.State.LoggedIn -> {
                navigator.push(HomeScreen(loggedInState.user))
            }
        }

        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Logo(
                    modifier = Modifier.width(500.dp).height(500.dp)
                )

                DemoOnText()
            }

            Column(
                modifier = Modifier.fillMaxHeight().padding(0.dp, 250.dp, 60.dp, 20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.height(20.dp))

                LoginForm(username, password, screenModel)

                Spacer(modifier = Modifier.height(20.dp))

                PasswordForgetLink()

                SignUpLink()
            }
        }
    }
}
