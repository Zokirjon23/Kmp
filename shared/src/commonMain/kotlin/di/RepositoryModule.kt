package all.di

import all.domain.repository.AuthRepository
import all.domain.repository.impl.AuthRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.binds
import org.koin.dsl.module
import all.domain.repository.PassengerChatListRepository
import all.domain.repository.PassengerChatRepository
import all.domain.repository.PassengerMapRepository
import all.domain.repository.PassengerSettingRepository
import all.domain.repository.impl.PassengerChatRepositoryImpl

val authRepositoryModule = module {
    singleOf(::AuthRepositoryImpl) bind (AuthRepository::class)
    singleOf(::PassengerChatRepositoryImpl) binds (arrayOf(
        PassengerChatRepository::class,
        PassengerChatListRepository::class,
        PassengerMapRepository::class,
        PassengerSettingRepository::class
    ))
}