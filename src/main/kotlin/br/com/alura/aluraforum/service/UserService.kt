package br.com.alura.aluraforum.service

import br.com.alura.aluraforum.model.AppUser
import br.com.alura.aluraforum.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserService(
    private val repository: UserRepository
): UserDetailsService {
    fun getById(id: Long): AppUser {
        return repository.getReferenceById(id)
    }

    override fun loadUserByUsername(username: String): UserDetails {
        val user = repository.findByEmail(username) ?: throw RuntimeException()
        return AppUserDetails(user)
    }
}
