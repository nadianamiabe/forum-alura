package br.com.alura.aluraforum.repository

import br.com.alura.aluraforum.model.AppUser
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<AppUser, Long> {
    fun findByEmail(email: String): AppUser?
}