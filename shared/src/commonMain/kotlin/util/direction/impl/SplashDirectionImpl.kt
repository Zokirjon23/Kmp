package util.direction.impl

import ui.screen.LoginScreen
import util.direction.SplashDirection
import util.navigation.Navigator

class SplashDirectionImpl constructor(private val navigation : Navigator) : SplashDirection {
   override suspend fun openRegistrationScreen(){
       navigation.replace(LoginScreen())
   }
}