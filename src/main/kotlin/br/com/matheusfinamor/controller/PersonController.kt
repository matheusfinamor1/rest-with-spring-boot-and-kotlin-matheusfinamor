package br.com.matheusfinamor.controller

import br.com.matheusfinamor.model.Person
import br.com.matheusfinamor.services.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/person")
class PersonController() {

    /** @Autowired Injeta a instancia quando for necessario */
    @Autowired
    private lateinit var service: PersonService

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findAll(): List<Person> {
        return service.findByAll()
    }

    @GetMapping(
        value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
            /** @PathVariable recupera dados da URL */
    fun findById(
        @PathVariable(value = "id") id: Long
    ): Person {
        return service.findById(id)
    }

    @PostMapping(
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
            /** @RequestBody recupera dados do Body */
    fun create(
        @RequestBody person: Person
    ): Person {
        return service.create(person)
    }

    @PutMapping(
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
            /** @RequestBody recupera dados do Body */
    fun update(
        @RequestBody person: Person
    ): Person {
        return service.update(person)
    }

    @DeleteMapping(
        value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
            /** @PathVariable recupera dados da URL */
    fun delete(@PathVariable(value = "id") id: Long): ResponseEntity<*> {
        service.delete(id)
        return ResponseEntity.noContent().build<Any>()
    }
}