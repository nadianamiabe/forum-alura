package br.com.alura.aluraforum.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class AppUser(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val name: String,
        val email: String,
        val password: String,
        @JsonIgnore
        @ManyToMany(fetch = FetchType.EAGER)
        @JoinColumn(name = "app_user_roles")
        val roles: List<Role> = mutableListOf()
)
