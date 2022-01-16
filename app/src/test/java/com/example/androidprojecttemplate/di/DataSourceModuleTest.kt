package com.example.androidprojecttemplate

import com.example.androidprojecttemplate.data.datasource.GithubRemoteDataSourceImpl
import org.koin.dsl.module

val dataSourceModuleTest = module {
    factory { GithubRemoteDataSourceImpl(api = get()) }
}