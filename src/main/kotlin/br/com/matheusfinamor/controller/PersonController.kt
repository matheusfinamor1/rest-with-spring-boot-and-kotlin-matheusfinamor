package br.com.matheusfinamor.controller

import br.com.matheusfinamor.data.vo.v1.PersonVO
import br.com.matheusfinamor.services.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import br.com.matheusfinamor.data.vo.v2.PersonVO as PersonVOV2

@RestController
@RequestMapping("/person")
class PersonController() {

    /** @Autowired Injeta a instancia quando for necessario */
    @Autowired
    private lateinit var service: PersonService


    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findAll(): List<PersonVO> {
        return service.findAll()
    }

    @GetMapping(
        value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
            /** @PathVariable recupera dados da URL */
    fun findById(
        @PathVariable(value = "id") id: Long
    ): PersonVO {
        return service.findById(id)
    }

    @PostMapping(
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
            /** @RequestBody recupera dados do Body */
    fun create(
        @RequestBody person: PersonVO
    ): PersonVO {
        return service.create(person)
    }

    @PostMapping(
        value = ["/v2"],
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
            /** @RequestBody recupera dados do Body */
    fun createV2(
        @RequestBody person: PersonVOV2
    ): PersonVOV2 {
        return service.createV2(person)
    }

    @PutMapping(
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
            /** @RequestBody recupera dados do Body */
    fun update(
        @RequestBody person: PersonVO
    ): PersonVO {
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