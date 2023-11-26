package ui.uistate

import source.model.Message

data class SmsVerificationUiState(val loading : Boolean = true,val message: Message? = null)