package br.com.alura.aluraforum.controller

import br.com.alura.aluraforum.config.JWTUtil
import br.com.alura.aluraforum.dto.CredentialsDTO
import br.com.alura.aluraforum.service.AppUserDetails
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController(
        @Autowired
        private val authenticationManager: AuthenticationManager,
        @Autowired
        private val jwtUtil: JWTUtil
) {
    @PostMapping("/login")
    fun login(@RequestBody credentials: CredentialsDTO): String? {
        val usernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken(
                credentials.email, credentials.password
        )
        val authenticate = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken)
        val user = authenticate.principal as AppUserDetails
        val authorities = user.authorities.map { it.authority }
        return jwtUtil.generateToken(user, authorities)
    }
}