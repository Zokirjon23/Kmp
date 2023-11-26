package util.direction.impl

import ui.screen.ChatScreen
import util.direction.ChatUserDirection
import util.navigation.Navigator

class ChatUserDirectionImpl(private val navigation: Navigator) : ChatUserDirection {
    override suspend fun openChat() {
        navigation.navigateTo(ChatScreen())
    }
}