package ui.intent

sealed interface LoginIntent{
    data object
    DismissError : LoginIntent

    data class Send(val phone : String) : LoginIntent
}