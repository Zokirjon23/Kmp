package ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.seiko.imageloader.rememberImagePainter
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import presenter.ChatUserPresenter
import presenter.impl.ChatUserPresenterImpl
import ui.intent.ChatUserIntent
import ui.uistate.ChatUserUiState
import util.color_primary
import util.component.BoxApp
import util.component.TextApp

class ChatUserScreen : Tab {

    @OptIn(ExperimentalResourceApi::class)
    override val options: TabOptions
        @Composable
        get() {
            val title = "Chat"
            val icon = painterResource("")

            return remember {
                TabOptions(
                    index = 2u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        val viewModel: ChatUserPresenter = getScreenModel<ChatUserPresenterImpl>()
        val uiState = viewModel.uiState.collectAsState()
        ChatUserScreenContent(uiState, viewModel::onEventDispatch)
    }

    @Composable
    fun ChatUserScreenContent(
        uiState: State<ChatUserUiState>,
        intent: (ChatUserIntent) -> Unit,
    ) {
        BoxApp(
            modifier = Modifier
                .width(428.dp)
                .height(926.dp)
                .background(color = color_primary)
        ) {
            Column {
                Column(Modifier) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .shadow(elevation = 10.dp)
                            .background(color_primary)
                            .height(56.dp).padding(start = 20.dp)
                    ) {
                        TextApp(
                            text = "Chat Taxi",
                            fontSize = 22.sp,
                            color = Color(0xFFFFFFFF)
                        )
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp)
                    ) {
                        TextApp(
                            text = "Online taksistlar",
                            fontSize = 20.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFFFFFFFF), modifier = Modifier.padding(start = 16.dp)
                        )

                        TextApp(
                            text = "See All",
                            fontSize = 15.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFFFFFFFF),
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .padding(end = 16.dp)
                        )
                    }

                    LazyRow {
                        items(10) {
                            val painter = rememberImagePainter("https://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50.jpg")
                            Column(modifier = Modifier.padding(start = 16.dp)) {
                                Image(
                                    modifier = Modifier
                                        .size(64.dp)
                                        .shadow(3.dp, RoundedCornerShape(50))
                                        .background(
                                            color = Color(0xFFEAEBEB),
                                            RoundedCornerShape(50)
                                        ),
                                    painter = painter,
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop
                                )

                                TextApp(
                                    text = "Amit",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFFFFFFFF),
                                    letterSpacing = 1.08.sp,
                                    modifier = Modifier.align(Alignment.CenterHorizontally)
                                )
                            }
                        }
                    }
                }
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            color = Color(0xFFFFFFFF),
                            shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)
                        )
                        .padding(top = 20.dp)
                ) {
                    item {
                        TextApp(
                            text = "Recent Chat",
                            fontSize = 24.sp,
                            fontWeight = FontWeight(600),
                            color = Color(0xFF000000),
                            modifier = Modifier.padding(bottom = 10.dp, start = 16.dp)
                        )
                    }
                    items(20) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { intent(ChatUserIntent.OpenChat()) }
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                        ) {
                            val painter = rememberImagePainter("https://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50.jpg")
                            Image(
                                modifier = Modifier
                                    .padding(end = 18.dp)
                                    .size(55.dp)
                                    .shadow(3.dp, RoundedCornerShape(50))
                                    .background(
                                        Color(0xFFEAEBEB),
                                        RoundedCornerShape(50)
                                    ),
                                painter = painter,
                                contentDescription = null,
                            )
                            Column(Modifier.weight(0.8f)) {
                                TextApp(
                                    text = "Diana Leo",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFF000000),
                                )
                                TextApp(
                                    text = "ur welcome",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight(300),
                                    color = Color(0xFF726E6E),
                                )
                            }
                            Column(Modifier.weight(0.2f), horizontalAlignment = Alignment.End) {
                                TextApp(
                                    text = "12:05",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight(300),
                                    color = Color(0xFF878787),

                                    )
//                                Image(
//                                    painter = painterResource(id = R.drawable.ic_chat_done),
//                                    contentDescription = "image description",
//                                    Modifier.padding(top = 5.dp)
//                                )
                            }
                        }
                    }
                }
            }
        }
    }
}