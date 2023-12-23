package com.example.ko.data.api

import com.example.ko.data.ApiHelpers
import com.example.ko.data.model.Posts
import io.ktor.client.*
import io.ktor.client.request.*

class KtorServicesImp(private val client: HttpClient):KtorServices{
    override suspend fun getPosts(): Posts {
        return client.get {
            url(ApiHelpers.endPoint)
        }
    }
}