package all.domain.repository.impl

import io.ktor.client.HttpClient
import all.domain.repository.PassengerChatListRepository
import all.domain.repository.PassengerChatRepository
import all.domain.repository.PassengerMapRepository
import all.domain.repository.PassengerSettingRepository
import all.source.local.Storage

class PassengerChatRepositoryImpl(private val storage: Storage, private val api: HttpClient) :
    PassengerChatRepository, PassengerChatListRepository, PassengerMapRepository,
    PassengerSettingRepository {
}