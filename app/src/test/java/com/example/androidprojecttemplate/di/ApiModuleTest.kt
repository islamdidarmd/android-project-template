package com.example.androidprojecttemplate

import com.example.androidprojecttemplate.config.BASE_URL
import com.example.androidprojecttemplate.data.network.GithubApiService
import com.example.androidprojecttemplate.data.network.getOkHttpClient
import com.example.androidprojecttemplate.data.network.getRetrofit
import io.mockk.mockk
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModuleTest = module {
    single { mockk<GithubApiService>() }
}