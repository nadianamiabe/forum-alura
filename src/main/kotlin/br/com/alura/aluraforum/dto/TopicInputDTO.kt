package br.com.alura.aluraforum.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class TopicInputDTO(
    @field:NotEmpty
    @field:Size(min = 5, max = 100)
    val title: String,
    @field:NotEmpty
    val message: String,
    @field:NotNull
    val courseId: Long,
    @field:NotNull
    val authorId: Long
)
