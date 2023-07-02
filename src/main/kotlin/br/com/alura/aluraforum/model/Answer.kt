package br.com.alura.aluraforum.model

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class Answer(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?,
        val message: String,
        val createdAt: LocalDateTime = LocalDateTime.now(),
        @ManyToOne
        val author: AppUser,
        @ManyToOne
        val topic: Topic,
        val isSolution: Boolean
)
