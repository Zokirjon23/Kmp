package ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.koin.getScreenModel
import util.AppScreen
import presenter.SplashViewModel
import presenter.impl.SplashViewModelImpl
import ui.intent.SplashIntent

class SplashScreen : AppScreen {
    @Composable
    override fun Content() {
        val viewModel: SplashViewModel = getScreenModel<SplashViewModelImpl>()
        SplashContent(viewModel::onEventDispatch)
    }

    @Composable
    fun SplashContent(intent: (SplashIntent) -> Unit) {
        Box(Modifier.fillMaxSize()) {

        }
    }
}