package all.domain.repository.impl

import all.source.local.Storage
import all.domain.repository.AuthRepository
import io.ktor.client.HttpClient

class AuthRepositoryImpl(private val storage: Storage, private val api : HttpClient) :
    AuthRepository {

}