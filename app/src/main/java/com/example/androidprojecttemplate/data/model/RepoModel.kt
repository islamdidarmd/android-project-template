package com.example.androidprojecttemplate.data.model

import com.example.androidprojecttemplate.domain.entity.Repo
import com.squareup.moshi.Json

class RepoModel(
    @field:Json(name = "name")
    val name: String,

    @field:Json(name = "full_name")
    val fullName: String,

    @field:Json(name = "private")
    val private: Boolean,

    @field:Json(name = "owner")
    val owner: OwnerModel,

    @field:Json(name = "html_url")
    val repoUrl: String,

    @field:Json(name = "description")
    val description: String?,

    @field:Json(name = "topics")
    val topics: List<String>?
) {
    fun toEntity(): Repo {
        return Repo(
            name = name,
            private = private,
            owner = owner.toEntity(),
            repoUrl = repoUrl,
            description = description,
            topics = topics
        )
    }
}