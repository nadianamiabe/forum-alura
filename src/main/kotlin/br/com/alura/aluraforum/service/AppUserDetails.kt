package br.com.alura.aluraforum.service

import br.com.alura.aluraforum.model.AppUser
import org.springframework.security.core.userdetails.UserDetails

class AppUserDetails(private val user: AppUser): UserDetails {
    override fun getAuthorities() = user.roles

    override fun getPassword() = user.password

    override fun getUsername() = user.email

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled(): Boolean = true
}