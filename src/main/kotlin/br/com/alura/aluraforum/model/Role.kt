package br.com.alura.aluraforum.model

import org.springframework.security.core.GrantedAuthority
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Role(
        @Id
        private val name: String
): GrantedAuthority {
    override fun getAuthority() = name
}