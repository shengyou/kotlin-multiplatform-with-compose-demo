package io.kraftsman.multiplatform.functions

import io.kraftsman.multiplatform.data.Target

actual fun getPlatformName(): String = Target.DESKTOP.name
    .lowercase()
    .replaceFirstChar(Char::uppercaseChar) +
        " (JVM ${Runtime.version()})"

actual fun getTarget(): Target = Target.DESKTOP
