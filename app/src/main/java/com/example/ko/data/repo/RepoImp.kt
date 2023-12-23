package com.example.ko.data.repo

import com.example.ko.data.datasources.Remote
import com.example.ko.data.model.Posts
import kotlinx.coroutines.flow.Flow

class RepoImp(private val dataSource:Remote):Repo {
    override suspend fun getPosts(): Flow<Posts> = dataSource.getPosts()

}