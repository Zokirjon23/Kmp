package util.navigation

import cafe.adriel.voyager.core.screen.Screen

interface Navigator {
    suspend fun navigateTo(screen: Screen)
    suspend fun replace(screen: Screen)
    suspend fun back()
}