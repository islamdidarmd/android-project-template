package com.example.androidprojecttemplate.di

import com.example.androidprojecttemplate.domain.usecase.FindRepoByKeywordUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory<FindRepoByKeywordUseCase> { FindRepoByKeywordUseCase(repository = get()) }
}