package util.navigation

import cafe.adriel.voyager.core.screen.Screen
import kotlinx.coroutines.flow.MutableSharedFlow


class NavigatorImpl : NavigatorDispatcher, Navigator {
    override val navigatorFlow =
        MutableSharedFlow<cafe.adriel.voyager.navigator.Navigator.() -> Unit>()

    private suspend fun navigator(block: cafe.adriel.voyager.navigator.Navigator.() -> Unit) {
        navigatorFlow.emit(block)
    }

    override suspend fun navigateTo(screen: Screen) = navigator {
        push(screen)
    }

    override suspend fun replace(screen: Screen) = navigator {
        push(screen)
    }

    override suspend fun back() = navigator {
        pop()
    }
}