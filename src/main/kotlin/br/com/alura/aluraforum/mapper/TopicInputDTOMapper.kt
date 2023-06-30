package br.com.alura.aluraforum.mapper

import br.com.alura.aluraforum.dto.TopicInputDTO
import br.com.alura.aluraforum.model.Topic
import br.com.alura.aluraforum.service.CourseService
import br.com.alura.aluraforum.service.UserService
import org.springframework.stereotype.Component

@Component
class TopicInputDTOMapper(
    private val courseService: CourseService,
    private val userService: UserService
): Mapper<TopicInputDTO, Topic> {
    override fun map(t: TopicInputDTO): Topic {
       return Topic(
           title = t.title,
           message = t.message,
           course = courseService.getById(t.courseId),
           author = userService.getById(t.authorId)
       )
    }
}