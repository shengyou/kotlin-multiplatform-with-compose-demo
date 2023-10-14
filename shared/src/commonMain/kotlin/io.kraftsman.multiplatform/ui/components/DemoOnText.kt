package io.kraftsman.multiplatform.ui.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import io.kraftsman.multiplatform.functions.getPlatformName

@Composable
fun DemoOnText() {
    Text(
        text = "Demo on ${getPlatformName()}",
        style = TextStyle(
            fontSize = 14.sp,
            fontFamily = FontFamily.Default,
            color = Color.Gray
        ),
    )
}
