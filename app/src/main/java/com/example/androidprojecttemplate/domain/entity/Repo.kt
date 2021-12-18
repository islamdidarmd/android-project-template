package com.example.androidprojecttemplate.domain.entity

class Repo(
    val name: String,
    val private: Boolean,
    val owner: Owner,
    val repoUrl: String,
    val description: String?,
    val topics: List<String>?
)