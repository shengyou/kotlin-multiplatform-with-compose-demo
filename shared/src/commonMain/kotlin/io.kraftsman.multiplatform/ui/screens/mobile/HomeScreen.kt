package io.kraftsman.multiplatform.ui.screens.mobile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import io.kraftsman.multiplatform.data.User
import io.kraftsman.multiplatform.functions.optionsList
import io.kraftsman.multiplatform.functions.prepareOptionsData
import io.kraftsman.multiplatform.screenmodels.HomeScreenModel
import io.kraftsman.multiplatform.ui.components.OptionItem
import io.kraftsman.multiplatform.ui.components.UserProfile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

data class HomeScreen(
    val user:User
) : Screen {

    @Composable
    override fun Content() {
        val screenModel = rememberScreenModel { HomeScreenModel(user) }
        var listPrepared by remember { mutableStateOf(false) }

        LaunchedEffect(Unit) {
            withContext(Dispatchers.Default) {
                optionsList.clear()

                // Add the data to optionsList
                prepareOptionsData()

                listPrepared = true
            }
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (listPrepared) {

                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {

                    item {
                        // User's image, name, email and edit button
                        UserProfile(screenModel.user)
                    }

                    // Show the options
                    items(optionsList.size) { index ->
                        OptionItem(item = optionsList[index])
                    }
                }
            }
        }
    }
}
