package com.example.androidprojecttemplate.domain.core

open class AppError(val message: String?) {}
open class ApiError(message: String?) : AppError(message = message)
class InvalidApiResponseError : ApiError(message = "Invalid Api Response")
class DataNotFoundError : ApiError(message = "No repository found")