package uz.uzbekcard.taxiapp.util.direction.impl

import ui.screen.LoginScreen
import uz.uzbekcard.taxiapp.util.direction.SplashDirection
import uz.uzbekcard.taxiapp.util.navigation.Navigation

class SplashDirectionImpl constructor(private val navigation : Navigation) : SplashDirection {
   override suspend fun openRegistrationScreen(){
       navigation.navigateTo(LoginScreen())
   }
}