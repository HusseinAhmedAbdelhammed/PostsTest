package com.example.ko.data.repo

import com.example.ko.data.model.Posts
import kotlinx.coroutines.flow.Flow

interface Repo {
    suspend fun getPosts(): Flow<Posts>
}