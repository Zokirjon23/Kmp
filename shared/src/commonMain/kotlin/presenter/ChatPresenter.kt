package presenter

import kotlinx.coroutines.flow.StateFlow
import ui.intent.ChatIntent
import ui.uistate.ChatUiState

interface ChatPresenter {
    val uiState : StateFlow<ChatUiState>
    fun onEventDispatch(intent : ChatIntent)
}