package di

import org.koin.dsl.binds
import org.koin.dsl.module
import util.navigation.Navigator
import util.navigation.NavigatorDispatcher
import util.navigation.NavigatorImpl


val navigationModule = module {
    single { NavigatorImpl() } binds arrayOf(Navigator::class, NavigatorDispatcher::class)
}