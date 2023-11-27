package ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import presenter.PassengerSettingPresenter
import presenter.impl.PassengerSettingPresenterPresenterImpl
import ui.intent.PassagerSettingIntent
import ui.uistate.PassengerSettingUiState

class PassengerSettingScreen : Tab {

    @OptIn(ExperimentalResourceApi::class)
    override val options: TabOptions
        @Composable
        get() {
            val title = "Setting"
            val icon = painterResource("")

            return remember {
                TabOptions(
                    index = 3u,
                    title = title,
                    icon = icon
                )
            }
        }
    @Composable
    override fun Content() {
        val viewModel : PassengerSettingPresenter = getScreenModel<PassengerSettingPresenterPresenterImpl>()
        val uiState = viewModel.uiState.collectAsState()
        PassengerSettingContent(uiState,viewModel::onEventDispatch)
    }

    @Composable
    fun PassengerSettingContent(
        uiState: State<PassengerSettingUiState>,
        intent: (PassagerSettingIntent) -> Unit
    ) {

    }
}