package br.com.alura.aluraforum

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class AluraForumApplication

fun main(args: Array<String>) {
	runApplication<AluraForumApplication>(*args)
}
