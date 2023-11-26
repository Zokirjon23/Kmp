package di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import util.direction.ChatDirection
import util.direction.ChatUserDirection
import util.direction.DriftDirection
import util.direction.MapDirection
import util.direction.SplashDirection
import util.direction.impl.ChatDirectionImpl
import util.direction.impl.ChatUserDirectionImpl
import util.direction.impl.DriftDirectionImpl
import util.direction.impl.MapDirectionImpl
import util.direction.impl.SplashDirectionImpl

val directionModule = module {
    factoryOf(::SplashDirectionImpl) bind(SplashDirection::class)
    factoryOf(::ChatDirectionImpl) bind(ChatDirection::class)
    factoryOf(::ChatUserDirectionImpl) bind(ChatUserDirection::class)
    factoryOf(::DriftDirectionImpl) bind(DriftDirection::class)
    factoryOf(::MapDirectionImpl) bind(MapDirection::class)
}