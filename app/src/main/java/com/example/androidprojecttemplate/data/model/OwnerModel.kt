package com.example.androidprojecttemplate.data.model

import com.example.androidprojecttemplate.domain.entity.Owner
import com.squareup.moshi.Json

class OwnerModel(
    @field:Json(name = "avatar_url")
    val avatar: String?,

    @field:Json(name = "html_url")
    val profileLink: String
) {
    fun toEntity(): Owner {
        return Owner(avatar = avatar, profileLink = profileLink)
    }
}
