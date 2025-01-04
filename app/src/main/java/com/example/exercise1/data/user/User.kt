package com.example.exercise1.data.user

import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class User(
    val firstName: String,
    val lastName: String,
    val age: Int,
    val image: Int
) {
    private val id: String = UUID.randomUUID().toString()

    fun getId(): String {
        return id
    }
}