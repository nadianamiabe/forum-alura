package br.com.alura.aluraforum.service

import br.com.alura.aluraforum.model.AppUser
import br.com.alura.aluraforum.model.Course
import org.springframework.stereotype.Service

@Service
class UserService(
    private var users: List<AppUser>
) {
    init {
        val user = AppUser(
            id = 1,
            name = "Ana da Silva",
            email = "ana@gmail.com"
        )
        users = listOf(user)
    }

    fun getById(id: Long): AppUser {
        return users.stream().filter { it -> it.id == id }.findFirst().get()
    }
}
