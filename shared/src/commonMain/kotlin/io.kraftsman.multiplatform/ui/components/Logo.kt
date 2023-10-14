package io.kraftsman.multiplatform.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun Logo(modifier: Modifier = Modifier) = Image(
    painter = painterResource("compose-multiplatform.xml"),
    contentDescription = null,
    modifier = modifier,
)
