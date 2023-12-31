package ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.koin.getScreenModel
import presenter.LoginViewModel
import presenter.impl.LoginViewModelImpl
import ui.intent.LoginIntent
import ui.uistate.LoginUiState
import util.AppScreen
import util.color_primary
import util.component.BoxApp
import util.component.TextApp
import util.component.TextFieldPhoneApp
import util.component.ColumnApp
import util.component.ToolbarApp
import util.text_color

class LoginScreen : AppScreen {

    @Composable
    override fun Content() {
        val viewModel: LoginViewModel = getScreenModel<LoginViewModelImpl>()
        val uiState = viewModel.uiState.collectAsState()
        LoginContent(uiState, viewModel::onEventDispatch)
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun LoginContent(uiState: State<LoginUiState>, intent: (LoginIntent) -> Unit) {
        val phone = remember { mutableStateOf("") }
        val focusRequester = remember { FocusRequester() }

        LaunchedEffect(focusRequester) {
            focusRequester.requestFocus()
        }

        BoxApp(modifier = Modifier.fillMaxSize()) {
            ColumnApp {
                ToolbarApp(title = "Login")
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontSize = 32.sp,
                                color = text_color,
                            )
                        ) {
                            append("Welcome \n")
                        }
                        withStyle(
                            style = SpanStyle(
                                fontSize = 32.sp,
                                color = color_primary,
                            )
                        ) {
                            append("Login ")
                        }
                        withStyle(
                            style = SpanStyle(
                                fontSize = 32.sp,
                                color = text_color,
                            )
                        ) {
                            append("Now !")
                        }
                    },
                    modifier = Modifier.padding(top = 30.dp, start = 16.dp, end = 16.dp),
                    lineHeight = 44.sp
                )
            }

            Column(
                Modifier
                    .padding(horizontal = 16.dp)
                    .align(Alignment.Center)
            ) {
                TextApp(
                    text = "Phone Number",
                    modifier = Modifier.padding(bottom = 11.dp)
                )
                TextFieldPhoneApp(
                    phone = phone.value,
                    onPhoneChanged = { if (!uiState.value.loading) phone.value = it },
                    modifier = Modifier.focusRequester(focusRequester)
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 43.dp)
                        .width(171.dp)
                        .height(40.dp)
                        .background(
                            color = color_primary,
                            shape = RoundedCornerShape(size = 5.dp)
                        )
                        .clickable {
                            intent(LoginIntent.Send(phone.value))
                        }

                ) {
                    if (!uiState.value.loading) {
                        TextApp(
                            text = "Sign In",
                            fontWeight = FontWeight(400),
                            color = Color(0xFFFFFFFF),
                            modifier = Modifier.align(Alignment.Center)
                        )
//                        IconApp(
//                            R.drawable.ic_arrow_left,
//                            tint = Color.White,
//                            modifier = Modifier
//                                .align(Alignment.CenterEnd)
//                                .padding(end = 12.dp)
//                        )
                    } else {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .size(30.dp), color = Color.White
                        )
                    }
                }
            }


//            uiState.value.message?.let {
//                ToastError(text = it.massageToText()) { intent(LoginIntent.DismissError) }
//            }
        }
    }
}