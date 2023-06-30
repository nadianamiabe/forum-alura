package br.com.alura.aluraforum.service

import br.com.alura.aluraforum.dto.TopicInputDTO
import br.com.alura.aluraforum.dto.TopicResponseDTO
import br.com.alura.aluraforum.model.Topic
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicService(
    private var topics: List<Topic> = listOf(),
    private val courseService: CourseService,
    private val userService: UserService
) {

    fun list(): List<TopicResponseDTO> {
        return topics.stream().map { TopicResponseDTO(
            id = it.id!!,
            title = it.title,
            message = it.message,
            status = it.status,
            createdAt = it.createdAt
        ) }.collect(Collectors.toList())
    }

    fun getById(id: Long): TopicResponseDTO {
        val topic = topics.stream().filter { t ->
            t.id == id
        }.findFirst().get()
        return TopicResponseDTO(
            id = topic.id!!,
            title = topic.title,
            message = topic.message,
            status = topic.status,
            createdAt = topic.createdAt
        )
    }

    fun create(dto: TopicInputDTO) {
        topics = topics.plus(
            Topic(
                id = topics.size.toLong() + 1,
                title = dto.title,
                message = dto.message,
                course = courseService.getById(dto.courseId),
                author = userService.getById(dto.authorId)
            )
        )
    }
}