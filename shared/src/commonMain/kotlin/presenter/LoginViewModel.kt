package uz.uzbekcard.taxiapp.presenter

import kotlinx.coroutines.flow.StateFlow
import ui.intent.LoginIntent
import ui.uistate.LoginUiState

interface LoginViewModel {
    val uiState : StateFlow<LoginUiState>
    fun onEventDispatch(intent : LoginIntent)
}