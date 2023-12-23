package com.example.ko.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ko.app.ui.ResponseState
import com.example.ko.data.model.Posts
import com.example.ko.data.repo.Repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class PostsViewModel(private val repo: Repo): ViewModel() {
     var postsResponse : MutableStateFlow<ResponseState<Posts>> = MutableStateFlow(ResponseState.OnLoading(false))
    private val _postsResponse: StateFlow<ResponseState<Posts>> = postsResponse
    fun getPosts(){
        viewModelScope.launch {
            repo.getPosts().flowOn(Dispatchers.IO).catch {
                postsResponse.emit(ResponseState.OnError(it.message?:"Error not Found!!"))
            }.collect{
                postsResponse.emit(ResponseState.OnSuccess(it))
            }
        }
    }
}