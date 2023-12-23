package com.example.ko.data.datasources

import com.example.ko.data.api.KtorServices
import com.example.ko.data.model.Posts
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteImp(private val apiServices: KtorServices):Remote {
    override suspend fun getPosts(): Flow<Posts> = flow{
        emit(apiServices.getPosts())
    }
}