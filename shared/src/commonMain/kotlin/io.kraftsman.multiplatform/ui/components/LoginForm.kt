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
import io.kraftsman.multiplatform.screenmodels.LoginScreenModel

@Composable
fun LoginForm(
    username: MutableState<TextFieldValue>,
    password: MutableState<TextFieldValue>,
    screenModel: LoginScreenModel
) {
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
        onClick = { screenModel.login(username.value.text, password.value.text) },
        shape = RoundedCornerShape(50.dp),
        modifier = Modifier.fillMaxWidth().height(50.dp)
    ) {
        Text(text = "Login")
    }
}
