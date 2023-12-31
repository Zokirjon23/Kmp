package ui.screen

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import util.AppScreen
import util.component.AuthButton
import util.component.BoxApp
import util.component.ToolbarApp
import util.component.ColumnApp
import util.component.RegistrationCodeInput
import util.component.TextApp

class SmsVerificationScreen : AppScreen {
    @Composable
    override fun Content() {
        SmsVerificationContent()
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SmsVerificationContent() {
        val otp = remember { mutableStateOf("") }
        BoxApp(Modifier.fillMaxSize()) {
            ColumnApp {
                ToolbarApp(title = "Sms Verification")
                TextApp(
                    text = "Almost there ",
                    fontSize = 24.sp,
                    modifier = Modifier.padding(vertical = 30.dp, horizontal = 16.dp)
                )
                TextApp(
                    text = "Please enter the 4-digit code sent to your email +99893 123 45 67 for verification.",
                    fontSize = 14.sp, modifier = Modifier.padding(horizontal = 16.dp)
                )
                RegistrationCodeInput(
                    codeLength = 4,
                    initialCode = otp.value,
                    onTextChanged = {
                        otp.value = it
                        if (it.length >= 4) {
//                            event(SmsVerificationIntent.SendCode(role, otp.value, token))
                        }
                    }, modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 10.dp)
                )
                AuthButton(
                    onClick = { },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .defaultMinSize(minWidth = 170.dp)
                        .padding(top = 30.dp, start = 16.dp, end = 16.dp),
                    text = "Verify",
                    loadingState = false
                )
            }
        }
    }
}