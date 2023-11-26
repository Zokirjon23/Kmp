import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import org.koin.compose.koinInject
import ui.screen.SplashScreen
import util.navigation.NavigatorDispatcher

@Composable
fun Application() {
    MaterialTheme {
        val navigatorDispatcher = koinInject<NavigatorDispatcher>()
        Navigator(screen = SplashScreen()) {
            LaunchedEffect(Unit) {
                navigatorDispatcher.navigatorFlow.onEach { navigate ->
                    navigate(it)
                }.collect()
            }
            SlideTransition(it)
        }
    }
}

