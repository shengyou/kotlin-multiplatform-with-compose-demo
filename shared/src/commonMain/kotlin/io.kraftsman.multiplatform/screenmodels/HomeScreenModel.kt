package io.kraftsman.multiplatform.screenmodels

import cafe.adriel.voyager.core.model.ScreenModel
import io.kraftsman.multiplatform.data.User

class HomeScreenModel(
    val user: User,
): ScreenModel {

    override fun onDispose() {
        // ...
    }
}
