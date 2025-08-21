package com.example.userlistapp.network

import com.example.userlistapp.data.*
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class ApiClient {
    private val httpClient = HttpClient(Android) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                isLenient = true
            })
        }
        install(Logging) {
            level = LogLevel.INFO
        }
    }

    suspend fun getUsers(): UsersResponse {
        return httpClient.get("https://dummyjson.com/users").body<UsersResponse>()
    }

    suspend fun getUsersPage(limit: Int, skip: Int): UsersResponse {
        return httpClient.get("https://dummyjson.com/users?limit=${limit}&skip=${skip}").body<UsersResponse>()
    }

    suspend fun getAllUsers(): List<User> {
        val pageSize = 100  // usa 100 como tamaño de página
        var skip = 0
        val all = mutableListOf<User>()
        var total = Int.MAX_VALUE
        do {
            val page = getUsersPage(limit = pageSize, skip = skip)
            if (total == Int.MAX_VALUE) total = page.total
            all += page.users
            skip += page.limit
        } while (all.size < total && page.users.isNotEmpty())
        return all
    }

    fun close() {
        httpClient.close()
    }
}