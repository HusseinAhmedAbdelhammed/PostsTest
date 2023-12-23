package com.example.ko.data.api

import com.example.ko.data.model.Posts

interface KtorServices {
    suspend fun getPosts():Posts
}