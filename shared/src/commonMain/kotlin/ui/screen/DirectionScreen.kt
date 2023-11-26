package ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import presenter.DirectionPresenter
import presenter.impl.DirectionPresenterImpl
import ui.intent.DirectionIntent
import ui.uistate.DirectionUiState
import util.component.BoxApp
import util.component.IconApp
import util.component.SpinnerApp
import util.component.TextApp
import util.component.ToolbarApp

class DirectionScreen : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val title = "Direction"
            val icon =
                rememberVectorPainter(ImageVector.vectorResource(id = R.drawable.ic_direction))

            return remember {
                TabOptions(
                    index = 1u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        val viewModel: DirectionPresenter = getScreenModel<DirectionPresenterImpl>()
        val uiState = viewModel.uiState.collectAsState()
        DirectionContent(uiState, viewModel::onEventDispatch)
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun DirectionContent(uiState: State<DirectionUiState>, intent: (DirectionIntent) -> Unit) {
        val region = remember { mutableStateOf("") }

        BoxApp(modifier = Modifier.fillMaxSize()) {
            ToolbarApp(title = "Yo'nalish tanlang", navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    IconApp(id = R.drawable.ic_back, tint = Color.White)
                }
            })
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
                    .padding(horizontal = 16.dp),
                colors = CardDefaults.cardColors(Color.White),
                elevation = CardDefaults.cardElevation(10.dp)
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    TextApp(text = "Viloyat")
                    SpinnerApp(
                        selectedOptionText = region,
                        hint = "Viloyat tanlang",
                        onDismiss = { },
                        list = listOf()
                    )
                    TextApp(text = "Tuman", modifier = Modifier.padding(top = 10.dp))
                    SpinnerApp(
                        selectedOptionText = region,
                        hint = "Tuman tanlang",
                        onDismiss = { },
                        list = listOf()
                    )
                    Button(
                        onClick = { },
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .align(Alignment.CenterHorizontally), shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(color_primary)
                    ) {
                        TextApp(text = "Tanlash", color = Color.White)
                    }
                }
            }
        }
    }
}