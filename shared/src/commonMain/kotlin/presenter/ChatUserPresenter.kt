package uz.uzbekcard.taxiapp.presenter

import kotlinx.coroutines.flow.StateFlow
import ui.intent.ChatUserIntent
import ui.uistate.ChatUserUiState

interface ChatUserPresenter {
    val uiState: StateFlow<ChatUserUiState>
    fun onEventDispatch(intent : ChatUserIntent)
}