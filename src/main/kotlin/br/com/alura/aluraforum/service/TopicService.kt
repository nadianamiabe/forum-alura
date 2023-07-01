package br.com.alura.aluraforum.service

import br.com.alura.aluraforum.dto.TopicInputDTO
import br.com.alura.aluraforum.dto.TopicResponseDTO
import br.com.alura.aluraforum.dto.TopicUpdateInputDTO
import br.com.alura.aluraforum.exception.NotFoundException
import br.com.alura.aluraforum.mapper.TopicInputDTOMapper
import br.com.alura.aluraforum.mapper.TopicResponseDTOMapper
import br.com.alura.aluraforum.model.Topic
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicService(
    private var topics: List<Topic> = listOf(),
    private val topicResponseDTOMapper: TopicResponseDTOMapper,
    private val topicInputDTOMapper: TopicInputDTOMapper,
    private val notFoundMessage: String = "Topic not found"
) {

    fun list(): List<TopicResponseDTO> {
        return topics.stream().map { topicResponseDTOMapper.map(it) }.collect(Collectors.toList())
    }

    fun getById(id: Long): TopicResponseDTO {
        val topic = topics
            .stream()
            .filter { t -> t.id == id }
            .findFirst()
            .orElseThrow{ NotFoundException(notFoundMessage) }
        return topicResponseDTOMapper.map(topic)
    }

    fun create(dto: TopicInputDTO): TopicResponseDTO {
        val topic = topicInputDTOMapper.map(dto)
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)
        return topicResponseDTOMapper.map(topic)
    }

    fun update(dto: TopicUpdateInputDTO): TopicResponseDTO {
        val topic = topics
            .stream()
            .filter { it.id == dto.id }
            .findFirst()
            .orElseThrow{ NotFoundException(notFoundMessage) }
        val updatedTopic = Topic(
            id = topic.id,
            title = dto.title,
            message = dto.message,
            author = topic.author,
            course = topic.course,
            answers = topic.answers,
            status = topic.status,
            createdAt = topic.createdAt
        )
        topics = topics.minus(topic).plus(updatedTopic)
        return topicResponseDTOMapper.map(updatedTopic)
    }

    fun delete(id: Long) {
        val topic = topics
            .stream()
            .filter { it.id == id }
            .findFirst()
            .orElseThrow{ NotFoundException(notFoundMessage) }
        topics = topics.minus(topic)
    }
}