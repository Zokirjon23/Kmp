package domain.usecase.impl

import domain.repository.PassengerChatListRepository
import domain.usecase.ChatUserUsesCase

class ChatUserUsesCaseImpl(private val chatRepository : PassengerChatListRepository) :
    ChatUserUsesCase {
}