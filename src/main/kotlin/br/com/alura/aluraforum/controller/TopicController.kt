package br.com.alura.aluraforum.controller

import br.com.alura.aluraforum.dto.TopicInputDTO
import br.com.alura.aluraforum.dto.TopicResponseDTO
import br.com.alura.aluraforum.service.TopicService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {
    @GetMapping
    fun list(): List<TopicResponseDTO> {
        return service.list()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): TopicResponseDTO {
        return service.getById(id)
    }

    @PostMapping
    fun create(@RequestBody dto: TopicInputDTO) {
        return service.create(dto)
    }
}