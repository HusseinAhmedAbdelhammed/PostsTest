package com.example.ko.app.di

import com.example.ko.app.viewmodel.PostsViewModel
import com.example.ko.data.api.KtorServices
import com.example.ko.data.api.KtorServicesImp
import com.example.ko.data.datasources.Remote
import com.example.ko.data.datasources.RemoteImp
import com.example.ko.data.repo.Repo
import com.example.ko.data.repo.RepoImp
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appMod = module {
    single { HttpClient(Android){
        install(Logging){
            level = LogLevel.ALL
        }
        install(JsonFeature){
            serializer = KotlinxSerializer()
        }
    } }
    single<KtorServices>{KtorServicesImp(get())}
    single<Remote> { RemoteImp(get()) }
    single<Repo>{RepoImp(get())}
    viewModel{
        PostsViewModel(get())
    }
}