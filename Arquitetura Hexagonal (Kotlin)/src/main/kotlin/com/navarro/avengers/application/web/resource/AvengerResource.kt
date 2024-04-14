package com.navarro.avengers.application.web.resource

import com.navarro.avengers.application.web.resource.request.AvengerRequest
import com.navarro.avengers.application.web.resource.response.AvengerResponse
import com.navarro.avengers.domain.avenger.AvengerRepository
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

private const val API_PATH: String = "v1/api/avenger"

@RestController
@RequestMapping(value = [API_PATH])
class AvengerResource(
        @Autowired private val repository: AvengerRepository
) {

    @GetMapping
    fun getHeroes(): ResponseEntity<List<AvengerResponse>> =
        repository.getHeroes()
        .map { AvengerResponse.from(it) }
        .let { ResponseEntity.ok().body(it) }

    @GetMapping("{id}/details")
    fun getHeroById(@PathVariable("id") id: Long): ResponseEntity<AvengerResponse> =
        repository.getHero(id)?.let {
            ResponseEntity.ok().body(AvengerResponse.from(it))
        } ?: ResponseEntity.notFound().build()

    @PostMapping
    fun createHero(@Valid @RequestBody body: AvengerRequest): ResponseEntity<AvengerResponse> =
       body.toAvenger().run {
           repository.createHero(this)
       }.let {
           ResponseEntity.created(URI("$API_PATH/${it.id}"))
                   .body(AvengerResponse.from(it))
       }

    @PutMapping("{id}")
    fun updateHero(@PathVariable("id") id: Long, @Valid @RequestBody body: AvengerRequest): ResponseEntity<AvengerResponse> =
        repository.getHero(id)?.let {
            AvengerRequest.to(it.id, body).apply {
                repository.updateHero(this)
            }.let { hero ->
                ResponseEntity.accepted().body(AvengerResponse.from(hero))
            }
        } ?: ResponseEntity.notFound().build()

    @DeleteMapping("{id}")
    fun deleteHero(@PathVariable("id") id: Long): ResponseEntity<Void> =
        repository.deleteHero(id).let { ResponseEntity.accepted().build<Void>() }
}