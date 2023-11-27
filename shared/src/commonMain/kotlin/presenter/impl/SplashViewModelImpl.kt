package presenter.impl

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.delay
import presenter.SplashViewModel
import kotlinx.coroutines.launch
import ui.intent.SplashIntent
import util.direction.SplashDirection

class SplashViewModelImpl(
    private val direction: SplashDirection
) : SplashViewModel, ScreenModel {

    init {
        screenModelScope.launch {
            delay(1000)
            direction.openRegistrationScreen()
        }
    }

    override fun onEventDispatch(splashIntent: SplashIntent) {
        when(splashIntent){
            is SplashIntent.OpenScreen -> screenModelScope.launch {
                direction.openRegistrationScreen()
            }
        }
    }
}