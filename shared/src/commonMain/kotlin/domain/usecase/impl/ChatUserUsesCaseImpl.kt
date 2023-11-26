package all.domain.usecase.impl

import all.domain.repository.PassengerChatListRepository
import all.domain.usecase.ChatUserUsesCase

class ChatUserUsesCaseImpl(private val chatRepository : PassengerChatListRepository) :
    ChatUserUsesCase {
}