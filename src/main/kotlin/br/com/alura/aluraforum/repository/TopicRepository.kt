package br.com.alura.aluraforum.repository

import br.com.alura.aluraforum.model.Topic
import org.springframework.data.jpa.repository.JpaRepository

interface TopicRepository: JpaRepository<Topic, Long> {
}