package br.com.alura.aluraforum.repository

import br.com.alura.aluraforum.model.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository: JpaRepository<Course, Long> {
}