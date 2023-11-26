package domain.usecase.impl

import domain.repository.PassengerChatRepository
import domain.usecase.ChatUsesCase

class ChatUsesCaseImpl(private val chatRepository: PassengerChatRepository) : ChatUsesCase {
}