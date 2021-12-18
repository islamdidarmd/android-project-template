package com.example.androidprojecttemplate.data.repository

import com.example.androidprojecttemplate.data.datasource.GithubRemoteDataSource
import com.example.androidprojecttemplate.domain.core.ApiError
import com.example.androidprojecttemplate.domain.core.Either
import com.example.androidprojecttemplate.domain.core.InvalidApiResponseError
import com.example.androidprojecttemplate.domain.entity.Repo
import com.example.androidprojecttemplate.domain.repository.GithubRepository

class GithubRepositoryImpl(
    private val remoteDataSource: GithubRemoteDataSource
) : GithubRepository {

    override suspend fun findRepoByKeyword(keyword: String): Either<ApiError, List<Repo>> {
        val apiResponse = remoteDataSource.findRepoByKeyword(keyword = keyword)
        return if (apiResponse is Either.Left) {
            Either.Left(left = InvalidApiResponseError())
        } else {
            val repoList = (apiResponse as Either.Right).right.toEntity()
            Either.Right(right = repoList)
        }
    }
}