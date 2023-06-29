package br.com.alura.aluraforum.model

import java.time.LocalDateTime

data class Answer(
    val id: Long?,
    val message: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val author: AppUser,
    val topic: Topic,
    val isSolution: Boolean
)
