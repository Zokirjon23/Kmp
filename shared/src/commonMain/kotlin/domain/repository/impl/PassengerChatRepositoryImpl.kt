package domain.repository.impl

import io.ktor.client.HttpClient
import domain.repository.PassengerChatListRepository
import domain.repository.PassengerChatRepository
import domain.repository.PassengerMapRepository
import domain.repository.PassengerSettingRepository

class PassengerChatRepositoryImpl(private val api: HttpClient) :
    PassengerChatRepository, PassengerChatListRepository, PassengerMapRepository,
    PassengerSettingRepository {
}