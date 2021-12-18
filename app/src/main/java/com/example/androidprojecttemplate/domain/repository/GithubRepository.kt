package com.example.androidprojecttemplate.domain.repository

import com.example.androidprojecttemplate.domain.core.ApiError
import com.example.androidprojecttemplate.domain.core.Either
import com.example.androidprojecttemplate.domain.entity.Repo

interface GithubRepository {
    suspend fun findRepoByKeyword(keyword: String): Either<ApiError, List<Repo>>
}