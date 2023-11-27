package ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.koin.getScreenModel
import com.seiko.imageloader.rememberImagePainter
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import util.AppScreen
import presenter.SplashViewModel
import presenter.impl.SplashViewModelImpl
import ui.intent.SplashIntent
import util.component.LocalImageApp

class SplashScreen : AppScreen {
    @Composable
    override fun Content() {
        val viewModel: SplashViewModel = getScreenModel<SplashViewModelImpl>()
        SplashContent(viewModel::onEventDispatch)
    }

    @OptIn(ExperimentalResourceApi::class)
    @Composable
    fun SplashContent(intent: (SplashIntent) -> Unit) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            LocalImageApp(painter = painterResource("ic_taxi.xml"), modifier = Modifier.size(80.dp))
        }
    }
}