package presenter

import kotlinx.coroutines.flow.StateFlow
import ui.intent.PassagerMapIntent
import ui.uistate.PassagerMapUiState

interface PassengerMapPresenter {
    val uiState : StateFlow<PassagerMapUiState>
    fun onEventDispatch(intent: PassagerMapIntent)
}