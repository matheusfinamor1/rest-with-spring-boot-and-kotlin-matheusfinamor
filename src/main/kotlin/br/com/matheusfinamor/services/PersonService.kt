package br.com.matheusfinamor.services

import br.com.matheusfinamor.data.vo.v1.PersonVO
import br.com.matheusfinamor.exceptions.ResourceNotFoundException
import br.com.matheusfinamor.mapper.ModelMapperObject
import br.com.matheusfinamor.mapper.custom.PersonMapper
import br.com.matheusfinamor.model.Person
import br.com.matheusfinamor.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
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

        val people = repository.findAll()
        return ModelMapperObject.parseListObject(people, PersonVO::class.java)
    }

    fun findById(id: Long): PersonVO {
        logger.info("Finding one person")
        val person = repository.findById(id).orElseThrow { ResourceNotFoundException("No records found for this ID") }
        return ModelMapperObject.parseObject(person, PersonVO::class.java)
    }

    fun create(person: PersonVO): PersonVO {
        logger.info("Creating one person with name ${person.firstName}")
        val entity: Person = ModelMapperObject.parseObject(person, Person::class.java)
        return ModelMapperObject.parseObject(repository.save(entity), PersonVO::class.java)
    }

    fun createV2(person: PersonVOV2): PersonVOV2 {
        logger.info("Creating one person with name ${person.firstName}")
        val entity: Person = mapper.mapVOToEntity(person)
        return mapper.mapEntitytoVo(repository.save(entity))
    }

    fun update(person: PersonVO): PersonVO {
        logger.info("Updating one person with id ${person.id}")

        val entity = repository.findById(person.id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID") }

        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender

        return ModelMapperObject.parseObject(repository.save(entity), PersonVO::class.java)

    }

    fun delete(id: Long) {
        logger.info("Deleting one person with id $id")

        val entity = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID") }
        repository.delete(entity)
    }

}