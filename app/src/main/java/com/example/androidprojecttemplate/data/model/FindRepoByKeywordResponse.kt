package com.example.androidprojecttemplate.data.model

import com.example.androidprojecttemplate.domain.entity.Repo
import com.squareup.moshi.Json

class FindRepoByKeywordResponse(
    @field:Json(name = "items")
    private val items: List<RepoModel>
) {
    fun toEntity(): List<Repo> {
        return items.map { it.toEntity() }
    }
}