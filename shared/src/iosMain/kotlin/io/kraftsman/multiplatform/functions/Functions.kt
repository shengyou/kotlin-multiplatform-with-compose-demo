package io.kraftsman.multiplatform.functions

import io.kraftsman.multiplatform.data.Target
import platform.UIKit.UIDevice

actual fun getPlatformName(): String = Target.IOS.name
    .replaceFirstChar(Char::lowercaseChar) +
        " (${UIDevice.currentDevice.systemVersion})"

actual fun getTarget(): Target = Target.IOS
