package com.example.ko.data.datasources

import com.example.ko.data.model.Posts
import kotlinx.coroutines.flow.Flow

interface Remote {
    suspend fun getPosts(): Flow<Posts>
}