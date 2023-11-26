package presenter.impl

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import domain.usecase.ChatUserUsesCase
import presenter.ChatUserPresenter
import ui.intent.ChatUserIntent
import ui.uistate.ChatUserUiState
import util.direction.ChatUserDirection

class ChatUserPresenterImpl(
    private val direction: ChatUserDirection,
    private val usesCase: ChatUserUsesCase
) : ScreenModel, ChatUserPresenter {
    override val uiState = MutableStateFlow(ChatUserUiState())
    override fun onEventDispatch(intent: ChatUserIntent) {
        when(intent){
            is ChatUserIntent.OpenChat -> coroutineScope.launch {
                direction.openChat()
            }
        }
    }
}