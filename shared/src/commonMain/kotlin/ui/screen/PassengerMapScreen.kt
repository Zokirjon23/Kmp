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
import presenter.PassengerMapPresenter
import presenter.impl.PassengerMapPresenterImpl
import ui.intent.PassagerMapIntent
import ui.uistate.PassagerMapUiState

class PassengerMapScreen : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val title = "Map"
            val icon = rememberVectorPainter(ImageVector.vectorResource(id = R.drawable.ic_map))

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon
                )
            }
        }
    @Composable
    override fun Content() {
        val viewModel : PassengerMapPresenter = getScreenModel<PassengerMapPresenterImpl>()
        val uiState = viewModel.uiState.collectAsState()
        PassengerMapContent(uiState,viewModel::onEventDispatch)
    }

    @Composable
    fun PassengerMapContent(
        uiState: State<PassagerMapUiState>,
        intent: (PassagerMapIntent) -> Unit
    ) {
//        val cameraState = rememberCameraPositionState()
//        BoxApp {
//            val marker = LatLng(41.0, 69.0)
//            GoogleMap(
//                modifier = Modifier.fillMaxSize(),
//                cameraPositionState = cameraState,
//                properties = MapProperties(
//                    isMyLocationEnabled = true,
//                    mapType = MapType.HYBRID,
//                    isTrafficEnabled = true
//                )
//            ) {
//                Marker(
//                    state = MarkerState(position = marker),
//                    title = "MyPosition",
//                    snippet = "This is a description of this Marker",
//                    draggable = true
//                )
//            }
//        }
    }
}