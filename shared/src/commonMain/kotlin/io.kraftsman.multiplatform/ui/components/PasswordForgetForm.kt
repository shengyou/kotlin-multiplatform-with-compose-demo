package io.kraftsman.multiplatform.ui.components

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp

@Composable
fun PasswordForgetLink() {
    ClickableText(
        text = AnnotatedString("Forgot password?"),
        style = TextStyle(
            fontSize = 14.sp,
            fontFamily = FontFamily.Default
        ),
        onClick = { },
    )
}
