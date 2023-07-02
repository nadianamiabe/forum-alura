package br.com.alura.aluraforum.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Topic(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        var title: String,
        var message: String,
        val createdAt: LocalDateTime = LocalDateTime.now(),
        @ManyToOne
        val course: Course,
        @ManyToOne
        val author: AppUser,
        @Enumerated(value = EnumType.STRING)
        val status: TopicStatus = TopicStatus.NOT_ANSWERED,
        @OneToMany(mappedBy = "topic")
        val answers: List<Answer> = ArrayList()
)