package br.com.alura.aluraforum.repository

import br.com.alura.aluraforum.dto.TopicPerCategoryDTO
import br.com.alura.aluraforum.model.Topic
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TopicRepository: JpaRepository<Topic, Long> {
    fun findByCourseName(courseName: String, pageable: Pageable): Page<Topic>

    @Query("""
        SELECT new br.com.alura.aluraforum.dto.TopicPerCategoryDTO(course.category, count(t)) 
        FROM Topic t JOIN t.course course 
        GROUP BY course.category
        """)
    fun report(): List<TopicPerCategoryDTO>
}