package presenter

import ui.intent.SplashIntent

interface SplashViewModel {
    fun onEventDispatch(splashIntent: SplashIntent)
}