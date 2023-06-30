package br.com.alura.aluraforum.mapper

import br.com.alura.aluraforum.dto.TopicResponseDTO
import br.com.alura.aluraforum.model.Topic
import org.springframework.stereotype.Component

@Component
class TopicResponseDTOMapper: Mapper<Topic, TopicResponseDTO> {
    override fun map(t: Topic): TopicResponseDTO {
        return TopicResponseDTO(
            id = t.id!!,
            title = t.title,
            message = t.message,
            status = t.status,
            createdAt = t.createdAt
        )
    }
}