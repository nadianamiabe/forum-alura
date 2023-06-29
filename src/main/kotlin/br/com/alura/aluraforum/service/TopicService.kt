package br.com.alura.aluraforum.service

import br.com.alura.aluraforum.model.AppUser
import br.com.alura.aluraforum.model.Course
import br.com.alura.aluraforum.model.Topic
import org.springframework.stereotype.Service

@Service
class TopicService(private var topics: List<Topic>) {
    init {
        val topic = Topic(
            id = 1,
            title = "Duvida Kotlin",
            message = "xxx",
            course = Course(
                id = 1,
                name = "Kotlin",
                category = "programming"
            ),
            author = AppUser(
                id = 1,
                name = "Ana da Silva",
                email = "ana@email.com"
            )
        )
        val topic2 = Topic(
            id = 2,
            title = "Duvida Kotlin",
            message = "xxx",
            course = Course(
                id = 1,
                name = "Kotlin",
                category = "programming"
            ),
            author = AppUser(
                id = 1,
                name = "Ana da Silva",
                email = "ana@email.com"
            )
        )
        val topic3 = Topic(
            id = 3,
            title = "Duvida Kotlin",
            message = "xxx",
            course = Course(
                id = 1,
                name = "Kotlin",
                category = "programming"
            ),
            author = AppUser(
                id = 1,
                name = "Ana da Silva",
                email = "ana@email.com"
            )
        )

        topics = listOf(topic, topic2, topic3)
    }
    fun list(): List<Topic> {
        return topics
    }

    fun getById(id: Long): Topic {
        return topics.stream().filter { t ->
            t.id == id
        }.findFirst().get()
    }
}