package di

import domain.repository.AuthRepository
import domain.repository.impl.AuthRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.binds
import org.koin.dsl.module
import domain.repository.PassengerChatListRepository
import domain.repository.PassengerChatRepository
import domain.repository.PassengerMapRepository
import domain.repository.PassengerSettingRepository
import domain.repository.impl.PassengerChatRepositoryImpl

val repositoryModule = module {
    singleOf(::AuthRepositoryImpl) bind (AuthRepository::class)
    singleOf(::PassengerChatRepositoryImpl) binds (arrayOf(
        PassengerChatRepository::class,
        PassengerChatListRepository::class,
        PassengerMapRepository::class,
        PassengerSettingRepository::class
    ))
}