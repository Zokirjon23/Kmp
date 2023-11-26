package di

import org.jetbrains.skiko.OS
import org.koin.dsl.module

val networkModule = module {
    single { provideClient(get()) }
}

private fun provideClient(storage : Storage) : HttpClient{
    return HttpClient(OS.Android){
        install(ContentNegotiation) {
            json()
        }

        if (BuildConfig.DEBUG){
            install(Logging){
                level = LogLevel.ALL
            }
        }

        expectSuccess = true

        HttpResponseValidator {
            handleResponseExceptionWithRequest { exception, _ ->
                Log.d("NETWORK_ERROR", "network error:${exception.message} ")
            }
        }

        defaultRequest {
            url(BuildConfig.BASE_URL)
            if (!storage.token.isNullOrEmpty()) {
                header("Authentication", storage.token)
            }
        }
    }
}