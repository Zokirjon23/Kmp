package presenter.impl

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import domain.usecase.PassengerMapUsesCase
import presenter.PassengerMapPresenter
import ui.intent.PassagerMapIntent
import ui.uistate.PassagerMapUiState

class PassengerMapPresenterImpl(
    private val direction: PassengerMapUsesCase,
    private val usesCase: PassengerMapUsesCase
) : ScreenModel, PassengerMapPresenter {
    override val uiState = MutableStateFlow(PassagerMapUiState())

    override fun onEventDispatch(intent: PassagerMapIntent) {

    }
}