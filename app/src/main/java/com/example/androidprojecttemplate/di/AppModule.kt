package com.example.androidprojecttemplate.di

import com.example.androidprojecttemplate.presentation.feature.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<HomeViewModel> { HomeViewModel(findRepoByKeywordUseCase = get()) }
}