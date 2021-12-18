package com.example.androidprojecttemplate.data.datasource

import com.example.androidprojecttemplate.data.model.FindRepoByKeywordResponse
import com.example.androidprojecttemplate.domain.core.Either

interface GithubRemoteDataSource {
    suspend fun findRepoByKeyword(keyword: String): Either<Exception, FindRepoByKeywordResponse>
}