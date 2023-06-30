package br.com.alura.aluraforum.service

import br.com.alura.aluraforum.model.Course
import org.springframework.stereotype.Service

@Service
class CourseService(
    var courses: List<Course>
) {

    init {
        val course = Course(
            id = 1,
            name = "Kotlin",
            category = "programming"
        )
        courses = listOf(course)
    }

    fun getById(id: Long): Course {
        return courses.stream().filter { it -> it.id == id }.findFirst().get()
    }
}
