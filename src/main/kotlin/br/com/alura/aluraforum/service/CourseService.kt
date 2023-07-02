package br.com.alura.aluraforum.service

import br.com.alura.aluraforum.model.Course
import br.com.alura.aluraforum.repository.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(
    private val repository: CourseRepository
) {

    fun getById(id: Long): Course {
        return repository.getReferenceById(id)
    }
}
