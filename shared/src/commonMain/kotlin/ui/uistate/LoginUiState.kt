package ui.uistate

import source.model.Message


data class LoginUiState(val loading : Boolean = false,val message : Message? = null)
