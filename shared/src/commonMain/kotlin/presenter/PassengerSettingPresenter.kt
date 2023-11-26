package presenter

import kotlinx.coroutines.flow.StateFlow
import ui.intent.PassagerSettingIntent
import ui.uistate.PassengerSettingUiState

interface PassengerSettingPresenter {
    val uiState : StateFlow<PassengerSettingUiState>
    fun onEventDispatch(intent : PassagerSettingIntent)
}