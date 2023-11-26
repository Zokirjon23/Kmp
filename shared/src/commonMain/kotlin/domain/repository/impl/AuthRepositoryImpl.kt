package domain.repository.impl

import domain.repository.AuthRepository
import io.ktor.client.HttpClient

class AuthRepositoryImpl(private val api : HttpClient) :
    AuthRepository {

}