import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Compose for Desktop demo application",
        state = WindowState(
            size = DpSize(1024.dp, 768.dp),
            position = WindowPosition.Aligned(Alignment.Center),
        )
    ) {
        MainView()
    }
}
