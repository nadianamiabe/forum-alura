package br.com.alura.aluraforum.controller

import br.com.alura.aluraforum.dto.TopicInputDTO
import br.com.alura.aluraforum.dto.TopicResponseDTO
import br.com.alura.aluraforum.dto.TopicUpdateInputDTO
import br.com.alura.aluraforum.service.TopicService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import java.util.*
import javax.transaction.Transactional
import javax.validation.Valid

@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {
    @GetMapping
    fun list(@RequestParam(required = false) courseName: String?): List<TopicResponseDTO> {
        return service.list(courseName)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): TopicResponseDTO {
        return service.getById(id)
    }

    @PostMapping
    @Transactional
    fun create(
        @RequestBody @Valid dto: TopicInputDTO,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicResponseDTO> {
        val topic = service.create(dto)
        val uri = uriBuilder.path("/topics/${topic.id}").build().toUri()
        return ResponseEntity.created(uri).body(topic)
    }

    @PutMapping
    @Transactional
    fun update(@RequestBody @Valid dto: TopicUpdateInputDTO): ResponseEntity<TopicResponseDTO> {
        val topic = service.update(dto)
        return ResponseEntity.ok(topic)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun delete(@PathVariable id: Long) {
        service.delete(id)
    }
}