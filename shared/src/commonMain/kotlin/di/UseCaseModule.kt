package di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import domain.usecase.ChatUserUsesCase
import domain.usecase.ChatUsesCase
import domain.usecase.DirectionUsesCase
import domain.usecase.PassengerMapUsesCase
import domain.usecase.PassengerSettingUsesCase
import domain.usecase.impl.ChatUserUsesCaseImpl
import domain.usecase.impl.ChatUsesCaseImpl
import domain.usecase.impl.DirectionUsesCaseImpl
import domain.usecase.impl.PassengerMapUsesCaseImpl
import domain.usecase.impl.PassengerSettingUsesCaseImpl

val useCaseModule = module {
    /**
     * Passenger
     */
    factoryOf(::ChatUsesCaseImpl) bind(ChatUsesCase::class)
    factoryOf(::ChatUserUsesCaseImpl) bind(ChatUserUsesCase::class)
    factoryOf(::DirectionUsesCaseImpl) bind(DirectionUsesCase::class)
    factoryOf(::PassengerSettingUsesCaseImpl) bind(PassengerSettingUsesCase::class)
    factoryOf(::PassengerMapUsesCaseImpl) bind(PassengerMapUsesCase::class)
}