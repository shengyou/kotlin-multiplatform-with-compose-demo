package io.kraftsman.multiplatform

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import io.kraftsman.multiplatform.data.Target
import io.kraftsman.multiplatform.functions.getTarget
import io.kraftsman.multiplatform.ui.screens.desktop.LoginScreen as DesktopLoginScreen
import io.kraftsman.multiplatform.ui.screens.mobile.LoginScreen as MobileLoginScreen

@Composable
fun MainApplication() {

    val screen = when (getTarget()) {
        Target.DESKTOP -> DesktopLoginScreen
        else -> MobileLoginScreen
    }

    Navigator(screen)
}
