package com.example.androidprojecttemplate.domain.usecase

import com.example.androidprojecttemplate.domain.core.ApiError
import com.example.androidprojecttemplate.domain.core.Either
import com.example.androidprojecttemplate.domain.entity.Repo
import com.example.androidprojecttemplate.domain.repository.GithubRepository

class FindRepoByKeywordUseCase(
    private val repository: GithubRepository
) {
    suspend operator fun invoke(keyword: String): Either<ApiError, List<Repo>> {
        return repository.findRepoByKeyword(keyword = keyword)
    }
}