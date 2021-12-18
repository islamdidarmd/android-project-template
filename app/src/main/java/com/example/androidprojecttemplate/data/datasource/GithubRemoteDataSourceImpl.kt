package com.example.androidprojecttemplate.data.datasource

import com.example.androidprojecttemplate.data.model.FindRepoByKeywordResponse
import com.example.androidprojecttemplate.data.network.GithubApiService
import com.example.androidprojecttemplate.domain.core.Either
import java.util.concurrent.CancellationException

class GithubRemoteDataSourceImpl(private val api: GithubApiService) : GithubRemoteDataSource {
    override suspend fun findRepoByKeyword(keyword: String): Either<Exception, FindRepoByKeywordResponse> {
        return try {
            val response = api.findRepoByKeyword(keyword = keyword)
            if (response.isSuccessful && response.body() != null) {
                Either.Right(right = response.body()!!)
            } else {
               Either.Left(left = IllegalArgumentException())
            }
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            else Either.Left(e)
        }
    }
}