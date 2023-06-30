package br.com.alura.aluraforum.dto

import br.com.alura.aluraforum.model.TopicStatus
import java.time.LocalDateTime

data class TopicResponseDTO(
    val id: Long,
    val title: String,
    val message: String,
    val status: TopicStatus,
    val createdAt: LocalDateTime
)
