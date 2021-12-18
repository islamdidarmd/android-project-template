package com.example.androidprojecttemplate.di

import com.example.androidprojecttemplate.config.BASE_URL
import com.example.androidprojecttemplate.data.network.GithubApiService
import com.example.androidprojecttemplate.data.network.getOkHttpClient
import com.example.androidprojecttemplate.data.network.getRetrofit
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single<OkHttpClient> { getOkHttpClient() }
    single<Retrofit> { getRetrofit(okHttpClient = get(), baseUrl = BASE_URL) }
    single<GithubApiService> { get<Retrofit>().create(GithubApiService::class.java) }
}