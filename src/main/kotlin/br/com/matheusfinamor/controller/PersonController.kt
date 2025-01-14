package br.com.matheusfinamor.controller

import br.com.matheusfinamor.model.Person
import br.com.matheusfinamor.services.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/person")
class PersonController() {

    /** @Autowired Injeta a instancia quando for necessario */
    @Autowired
    private lateinit var service: PersonService

    @RequestMapping(
        value = ["/{id}"],
        method = [RequestMethod.GET],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
            /** @PathVariable recupera dados da URL */
    fun findById(
        @PathVariable(value = "id") id: Long
    ): Person {
        return service.findById(id)
    }

    @RequestMapping(
        method = [RequestMethod.GET],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun findAll(): List<Person> {
        return service.findByAll()
    }

}