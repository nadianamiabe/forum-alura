package br.com.alura.aluraforum.service

import br.com.alura.aluraforum.dto.TopicInputDTO
import br.com.alura.aluraforum.dto.TopicResponseDTO
import br.com.alura.aluraforum.dto.TopicUpdateInputDTO
import br.com.alura.aluraforum.mapper.TopicInputDTOMapper
import br.com.alura.aluraforum.mapper.TopicResponseDTOMapper
import br.com.alura.aluraforum.model.Topic
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicService(
    private var topics: List<Topic> = listOf(),
    private val topicResponseDTOMapper: TopicResponseDTOMapper,
    private val topicInputDTOMapper: TopicInputDTOMapper
) {

    fun list(): List<TopicResponseDTO> {
        return topics.stream().map { topicResponseDTOMapper.map(it) }.collect(Collectors.toList())
    }

    fun getById(id: Long): TopicResponseDTO {
        val topic = topics.stream().filter { t ->
            t.id == id
        }.findFirst().get()
        return topicResponseDTOMapper.map(topic)
    }

    fun create(dto: TopicInputDTO) {
        val topic = topicInputDTOMapper.map(dto)
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)
    }

    fun update(dto: TopicUpdateInputDTO) {
        val topic = topics.stream().filter { it.id == dto.id }.findFirst().get()
        topics = topics.minus(topic).plus(
            Topic(
                id = topic.id,
                title = dto.title,
                message = dto.message,
                author = topic.author,
                course = topic.course,
                answers = topic.answers,
                status = topic.status,
                createdAt = topic.createdAt
            )
        )
    }
}