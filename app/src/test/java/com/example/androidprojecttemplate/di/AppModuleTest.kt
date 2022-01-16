package com.example.androidprojecttemplate

import com.example.androidprojecttemplate.presentation.feature.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModuleTest = module {
    viewModel { HomeViewModel(findRepoByKeywordUseCase = get()) }
}