package uz.uzbekcard.taxiapp.presenter.impl

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import uz.uzbekcard.taxiapp.presenter.DirectionPresenter
import ui.intent.DirectionIntent
import ui.uistate.DirectionUiState
import util.direction.DriftDirection

class DirectionPresenterImpl(
    private val direction: DriftDirection,
//    private val useCase: DirectionUsesCase
) : ScreenModel, DirectionPresenter {
    override val uiState = MutableStateFlow(DirectionUiState())

    override fun onEventDispatch(intent: DirectionIntent) {

    }
}