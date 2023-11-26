package di

import org.koin.dsl.binds
import org.koin.dsl.module


val navigationModule = module {
    single { NavigationImpl() } binds arrayOf(Navigation::class, NavigationDispatcher::class)
}