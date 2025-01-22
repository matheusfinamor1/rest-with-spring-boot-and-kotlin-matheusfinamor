package br.com.matheusfinamor.services

import br.com.matheusfinamor.controller.PersonController
import br.com.matheusfinamor.data.vo.v1.PersonVO
import br.com.matheusfinamor.exceptions.ResourceNotFoundException
import br.com.matheusfinamor.mapper.DozerMapper
import br.com.matheusfinamor.mapper.custom.PersonMapper
import br.com.matheusfinamor.model.Person
import br.com.matheusfinamor.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.stereotype.Service
import java.util.logging.Logger
import br.com.matheusfinamor.data.vo.v2.PersonVO as PersonVOV2

@Service
class PersonService {

    @Autowired
    private lateinit var repository: PersonRepository

    @Autowired
    private lateinit var mapper: PersonMapper

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<PersonVO> {
        logger.info("Finding all people")

        val persons = repository.findAll()
        val vos = DozerMapper.parseListObject(persons, PersonVO::class.java)
        for (person in vos){
            val withSelfRell = linkTo(PersonController::class.java).slash(person.key).withSelfRel()
            person.add(withSelfRell)
        }
        return vos
    }

    fun findById(id: Long): PersonVO {
        logger.info("Finding one person with ID $id")
        val person = repository.findById(id).orElseThrow { ResourceNotFoundException("No records found for this ID") }
        val personVO: PersonVO = DozerMapper.parseObject(person, PersonVO::class.java)

        val withSelfRell = linkTo(PersonController::class.java).slash(personVO.key).withSelfRel()
        personVO.add(withSelfRell)
        return personVO
    }

    fun create(person: PersonVO): PersonVO {
        logger.info("Creating one person with name ${person.firstName}")
        val entity: Person = DozerMapper.parseObject(person, Person::class.java)
        val personVO: PersonVO =  DozerMapper.parseObject(repository.save(entity), PersonVO::class.java)

        val withSelfRell = linkTo(PersonController::class.java).slash(personVO.key).withSelfRel()
        personVO.add(withSelfRell)
        return personVO
    }

    fun createV2(person: PersonVOV2): PersonVOV2 {
        logger.info("Creating one person with name ${person.firstName}")
        val entity: Person = mapper.mapVOToEntity(person)
        return mapper.mapEntitytoVo(repository.save(entity))
    }

    fun update(person: PersonVO): PersonVO {
        logger.info("Updating one person with id ${person.key}")

        val entity = repository.findById(person.key)
            .orElseThrow { ResourceNotFoundException("No records found for this ID") }

        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender

        val personVO: PersonVO = DozerMapper.parseObject(repository.save(entity), PersonVO::class.java)

        val withSelfRell = linkTo(PersonController::class.java).slash(personVO.key).withSelfRel()
        personVO.add(withSelfRell)
        return personVO

    }

    fun delete(id: Long) {
        logger.info("Deleting one person with id $id")

        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID") }
        repository.delete(entity)
    }

}