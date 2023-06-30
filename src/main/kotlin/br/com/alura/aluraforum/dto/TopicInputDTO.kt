package br.com.alura.aluraforum.dto

data class TopicInputDTO(
    val title: String,
    val message: String,
    val courseId: Long,
    val authorId: Long
)
