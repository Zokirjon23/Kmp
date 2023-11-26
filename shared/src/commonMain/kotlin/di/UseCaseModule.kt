package all.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import all.domain.usecase.ChatUserUsesCase
import all.domain.usecase.ChatUsesCase
import all.domain.usecase.DirectionUsesCase
import all.domain.usecase.PassengerMapUsesCase
import all.domain.usecase.PassengerSettingUsesCase
import all.domain.usecase.impl.ChatUserUsesCaseImpl
import all.domain.usecase.impl.ChatUsesCaseImpl
import all.domain.usecase.impl.DirectionUsesCaseImpl
import all.domain.usecase.impl.PassengerMapUsesCaseImpl
import all.domain.usecase.impl.PassengerSettingUsesCaseImpl

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