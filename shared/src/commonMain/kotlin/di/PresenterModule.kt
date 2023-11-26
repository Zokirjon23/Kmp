package di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import presenter.impl.SplashViewModelImpl
import org.koin.dsl.module
import presenter.ChatPresenter
import presenter.ChatUserPresenter
import presenter.DirectionPresenter
import presenter.LoginViewModel
import presenter.PassengerMapPresenter
import presenter.PassengerSettingPresenter
import presenter.SplashViewModel
import presenter.impl.ChatPresenterImpl
import presenter.impl.ChatUserPresenterImpl
import presenter.impl.DirectionPresenterImpl
import presenter.impl.LoginViewModelImpl
import presenter.impl.PassengerMapPresenterImpl
import presenter.impl.PassengerSettingPresenterPresenterImpl

val presenterModule = module {
    /**
     * Common
     */
    factoryOf(::SplashViewModelImpl) bind(SplashViewModel::class)
    factoryOf(::LoginViewModelImpl) bind (LoginViewModel::class)

    /**
     * Passenger
     */
    factoryOf(::ChatPresenterImpl) bind(ChatPresenter::class)
    factoryOf(::ChatUserPresenterImpl) bind(ChatUserPresenter::class)
    factoryOf(::DirectionPresenterImpl) bind(DirectionPresenter::class)
    factoryOf(::PassengerSettingPresenterPresenterImpl) bind(PassengerSettingPresenter::class)
    factoryOf(::PassengerMapPresenterImpl) bind(PassengerMapPresenter::class)
}