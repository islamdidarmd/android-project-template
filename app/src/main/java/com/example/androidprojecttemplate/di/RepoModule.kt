package com.example.androidprojecttemplate.di

import com.example.androidprojecttemplate.data.repository.GithubRepositoryImpl
import com.example.androidprojecttemplate.domain.repository.GithubRepository
import org.koin.dsl.module

val repoModule = module {
    factory<GithubRepository> { GithubRepositoryImpl(remoteDataSource = get()) }
}