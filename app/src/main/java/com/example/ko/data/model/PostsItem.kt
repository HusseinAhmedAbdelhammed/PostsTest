package com.example.ko.data.model

import kotlinx.serialization.Serializable

@Serializable
data class PostsItem(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)