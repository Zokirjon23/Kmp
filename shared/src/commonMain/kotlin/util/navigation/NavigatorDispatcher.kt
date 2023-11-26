package util.navigation

import cafe.adriel.voyager.navigator.Navigator
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

interface NavigatorDispatcher {
    val navigatorFlow: MutableSharedFlow<Navigator.() -> Unit>
}