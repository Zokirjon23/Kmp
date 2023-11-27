package di

fun appModule() = listOf(
    navigationModule, useCaseModule, repositoryModule, presenterModule,
    directionModule, networkModule
)