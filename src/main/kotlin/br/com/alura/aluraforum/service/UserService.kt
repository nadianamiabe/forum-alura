package br.com.alura.aluraforum.service

import br.com.alura.aluraforum.model.AppUser
import br.com.alura.aluraforum.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val repository: UserRepository
) {
    fun getById(id: Long): AppUser {
        return repository.getReferenceById(id)
    }
}
