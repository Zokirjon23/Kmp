package all.presenter.impl

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import all.domain.usecase.ChatUsesCase
import uz.uzbekcard.taxiapp.presenter.ChatPresenter
import ui.intent.ChatIntent
import ui.uistate.ChatUiState
import uz.uzbekcard.taxiapp.util.direction.ChatDirection

class ChatPresenterImpl(private val direction: ChatDirection, private val usesCase: ChatUsesCase) :
    ScreenModel, ChatPresenter {
    override val uiState = MutableStateFlow(ChatUiState())

    override fun onEventDispatch(intent: ChatIntent) {

    }
}