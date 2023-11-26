package ui.intent

sealed interface ChatUserIntent{
    data class OpenChat(val unit : Unit = Unit) : ChatUserIntent
}