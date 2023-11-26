package presenter.impl

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import domain.usecase.ChatUsesCase
import presenter.ChatPresenter
import ui.intent.ChatIntent
import ui.uistate.ChatUiState
import util.direction.ChatDirection

class ChatPresenterImpl(private val direction: ChatDirection, private val usesCase: ChatUsesCase) :
    ScreenModel, ChatPresenter {
    override val uiState = MutableStateFlow(ChatUiState())

    override fun onEventDispatch(intent: ChatIntent) {

    }
}