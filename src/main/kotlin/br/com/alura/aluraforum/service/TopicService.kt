package br.com.alura.aluraforum.service

import br.com.alura.aluraforum.dto.TopicInputDTO
import br.com.alura.aluraforum.dto.TopicResponseDTO
import br.com.alura.aluraforum.dto.TopicUpdateInputDTO
import br.com.alura.aluraforum.exception.NotFoundException
import br.com.alura.aluraforum.mapper.TopicInputDTOMapper
import br.com.alura.aluraforum.mapper.TopicResponseDTOMapper
import br.com.alura.aluraforum.repository.TopicRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicService(
    private val repository: TopicRepository,
    private val topicResponseDTOMapper: TopicResponseDTOMapper,
    private val topicInputDTOMapper: TopicInputDTOMapper,
    private val notFoundMessage: String = "Topic not found"
) {

    fun list(): List<TopicResponseDTO> {
        return repository.findAll().stream().map { topicResponseDTOMapper.map(it) }.collect(Collectors.toList())
    }

    fun getById(id: Long): TopicResponseDTO {
        val topic = repository.findById(id)
            .orElseThrow{ NotFoundException(notFoundMessage) }
        return topicResponseDTOMapper.map(topic)
    }

    fun create(dto: TopicInputDTO): TopicResponseDTO {
        val topic = topicInputDTOMapper.map(dto)
        repository.save(topic)
        return topicResponseDTOMapper.map(topic)
    }

    fun update(dto: TopicUpdateInputDTO): TopicResponseDTO {
        val topic = repository.findById(dto.id)
            .orElseThrow{ NotFoundException(notFoundMessage) }
        topic.title = dto.title
        topic.message = dto.message
        return topicResponseDTOMapper.map(topic)
    }

    fun delete(id: Long) {
        repository.deleteById(id)
    }
}