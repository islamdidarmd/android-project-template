package com.example.androidprojecttemplate.di

import com.example.androidprojecttemplate.data.datasource.GithubRemoteDataSource
import com.example.androidprojecttemplate.data.datasource.GithubRemoteDataSourceImpl
import org.koin.dsl.module

val dataSourceModuleTest = module {
    factory<GithubRemoteDataSource> { GithubRemoteDataSourceImpl(api = get()) }
}