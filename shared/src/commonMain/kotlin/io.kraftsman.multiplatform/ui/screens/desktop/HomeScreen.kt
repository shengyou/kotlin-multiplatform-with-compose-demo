package io.kraftsman.multiplatform.ui.screens.desktop

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import io.kraftsman.multiplatform.data.User
import io.kraftsman.multiplatform.functions.optionsList
import io.kraftsman.multiplatform.functions.prepareOptionsData
import io.kraftsman.multiplatform.ui.components.OptionItem
import io.kraftsman.multiplatform.ui.components.UserProfile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

data class HomeScreen(
    val user: User
) : Screen {

    @Composable
    override fun Content() {
        var listPrepared by remember { mutableStateOf(false) }

        LaunchedEffect(Unit) {
            withContext(Dispatchers.Default) {
                optionsList.clear()

                // Add the data to optionsList
                prepareOptionsData()

                listPrepared = true
            }
        }

        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
        ) {
            if (listPrepared) {
                Column(
                    modifier = Modifier.width(400.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    UserProfile(user)
                }

                Column(
                    modifier = Modifier.fillMaxHeight().padding(0.dp, 0.dp, 20.dp, 0.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        // Show the options
                        items(optionsList.size) { index ->
                            OptionItem(item = optionsList[index])
                        }
                    }
                }
            }
        }
    }
}
