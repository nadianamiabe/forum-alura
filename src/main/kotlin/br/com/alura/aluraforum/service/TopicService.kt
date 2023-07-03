package br.com.alura.aluraforum.service

import br.com.alura.aluraforum.dto.TopicInputDTO
import br.com.alura.aluraforum.dto.TopicPerCategoryDTO
import br.com.alura.aluraforum.dto.TopicResponseDTO
import br.com.alura.aluraforum.dto.TopicUpdateInputDTO
import br.com.alura.aluraforum.exception.NotFoundException
import br.com.alura.aluraforum.mapper.TopicInputDTOMapper
import br.com.alura.aluraforum.mapper.TopicResponseDTOMapper
import br.com.alura.aluraforum.repository.TopicRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicService(
    private val repository: TopicRepository,
    private val topicResponseDTOMapper: TopicResponseDTOMapper,
    private val topicInputDTOMapper: TopicInputDTOMapper,
    private val notFoundMessage: String = "Topic not found"
) {

    fun list(courseName: String?, pageable: Pageable): Page<TopicResponseDTO> {
        val topics = if (courseName == null) {
            repository.findAll(pageable)
        } else {
            repository.findByCourseName(courseName, pageable)
        }
        return topics.map { topicResponseDTOMapper.map(it) }
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

    fun report(): List<TopicPerCategoryDTO> {
        return repository.report()
    }
}