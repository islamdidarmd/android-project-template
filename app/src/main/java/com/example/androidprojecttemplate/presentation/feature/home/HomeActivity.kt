package com.example.androidprojecttemplate.presentation.feature.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import com.example.androidprojecttemplate.ui.theme.AndroidProjectTemplateTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : ComponentActivity() {
    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidProjectTemplateTheme {
                Scaffold { paddingValues ->
                    HomeScreenContent(
                        modifier = Modifier.padding(paddingValues = paddingValues),
                        homeViewModel = homeViewModel
                    )
                }
            }
        }
    }
}