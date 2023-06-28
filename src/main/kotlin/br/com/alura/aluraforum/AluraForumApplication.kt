package br.com.alura.aluraforum

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AluraForumApplication

fun main(args: Array<String>) {
	runApplication<AluraForumApplication>(*args)
}
