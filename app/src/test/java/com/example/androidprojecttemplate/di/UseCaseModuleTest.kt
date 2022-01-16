package com.example.androidprojecttemplate.di

import com.example.androidprojecttemplate.domain.usecase.FindRepoByKeywordUseCase
import io.mockk.mockk
import org.koin.dsl.module

val useCaseModuleTest = module {
    factory { mockk<FindRepoByKeywordUseCase>() }
}