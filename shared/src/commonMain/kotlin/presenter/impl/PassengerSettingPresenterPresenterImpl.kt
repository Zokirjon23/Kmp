package presenter.impl

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import domain.usecase.PassengerSettingUsesCase
import presenter.PassengerSettingPresenter
import ui.intent.PassagerSettingIntent
import ui.uistate.PassengerSettingUiState

class PassengerSettingPresenterPresenterImpl(
    private val usesCase : PassengerSettingUsesCase
) : ScreenModel, PassengerSettingPresenter {
    override val uiState = MutableStateFlow(PassengerSettingUiState())

    override fun onEventDispatch(intent: PassagerSettingIntent) {

    }
}