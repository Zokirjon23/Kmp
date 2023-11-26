package all.domain.usecase.impl

import all.domain.repository.PassengerChatRepository
import all.domain.usecase.ChatUsesCase

class ChatUsesCaseImpl(private val chatRepository: PassengerChatRepository) : ChatUsesCase {
}