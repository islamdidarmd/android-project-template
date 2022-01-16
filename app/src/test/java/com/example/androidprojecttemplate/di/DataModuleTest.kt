package com.example.androidprojecttemplate.di

import com.example.androidprojecttemplate.data.model.FindRepoByKeywordResponse
import com.example.androidprojecttemplate.data.model.OwnerModel
import com.example.androidprojecttemplate.data.model.RepoModel
import org.koin.dsl.module

val dataModuleTest = module {
    factory {
        FindRepoByKeywordResponse(
            items = arrayListOf(
                RepoModel(
                    name = "Test Repo 1",
                    fullName = "Test Repo Full Name",
                    private = false,
                    owner = OwnerModel(
                        avatar = "",
                        profileLink = ""
                    ),
                    repoUrl = "",
                    description = "Description",
                    topics = emptyList()
                )
            )
        )
    }
}