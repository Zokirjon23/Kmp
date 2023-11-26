package ui.intent

sealed interface ChatIntent{
    data object Back : ChatIntent
}