package presenter

import kotlinx.coroutines.flow.StateFlow
import ui.intent.DirectionIntent
import ui.uistate.DirectionUiState

interface DirectionPresenter {
    val uiState : StateFlow<DirectionUiState>
    fun onEventDispatch(intent : DirectionIntent)
}