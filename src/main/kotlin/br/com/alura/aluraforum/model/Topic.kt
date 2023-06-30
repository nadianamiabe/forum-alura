package br.com.alura.aluraforum.model

import java.time.LocalDateTime

data class Topic(
    var id: Long? = null,
    val title: String,
    val message: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val course: Course,
    val author: AppUser,
    val status: TopicStatus = TopicStatus.NOT_ANSWERED,
    val answers: List<Answer> = ArrayList()
)