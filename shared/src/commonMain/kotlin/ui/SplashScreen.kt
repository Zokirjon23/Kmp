package ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import kotlinx.coroutines.delay

class SplashScreen : Screen {
    @Composable
    override fun Content() {
        SplashContent()
    }

    @Composable
    fun SplashContent() {
        Box(modifier = Modifier.fillMaxSize()) {
            var visible by remember { mutableStateOf(false) }
            AnimatedVisibility(
                visible, modifier = Modifier.align(Alignment.Center), enter = fadeIn(),
                exit = fadeOut()
            ) {
                Text("My App", fontSize = 25.sp)
            }

            LaunchedEffect(Unit) {
                delay(2000)
                visible = true
                delay(2000)
                visible = false
            }
        }
    }
}
