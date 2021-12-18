package com.example.androidprojecttemplate.data.network

import com.example.androidprojecttemplate.config.REPO_SEARCH_URL
import com.example.androidprojecttemplate.data.model.FindRepoByKeywordResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApiService {
    @GET(value = REPO_SEARCH_URL)
    suspend fun findRepoByKeyword(@Query("q") keyword: String): Response<FindRepoByKeywordResponse>
}