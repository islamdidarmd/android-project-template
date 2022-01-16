package com.example.androidprojecttemplate.di

import com.example.androidprojecttemplate.data.network.GithubApiService
import io.mockk.mockk
import org.koin.dsl.module

val apiModuleTest = module {
    single { mockk<GithubApiService>() }
}