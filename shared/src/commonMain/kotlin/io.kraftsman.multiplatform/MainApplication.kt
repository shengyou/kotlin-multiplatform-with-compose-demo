package io.kraftsman.multiplatform

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import io.kraftsman.multiplatform.functions.getPlatformName

@Composable
fun MainApplication() {
    Text(text = "Hello, ${getPlatformName()}")
}
