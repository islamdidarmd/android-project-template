package com.example.androidprojecttemplate.domain.core

sealed class Either<E, V> {
    class Left<E, V>(val left: E) : Either<E, V>()
    class Right<E, V>(val right: V) : Either<E, V>()
}