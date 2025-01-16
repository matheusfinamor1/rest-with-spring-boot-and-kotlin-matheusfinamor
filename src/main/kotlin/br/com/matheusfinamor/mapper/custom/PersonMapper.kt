package br.com.matheusfinamor.mapper.custom

import br.com.matheusfinamor.data.vo.v2.PersonVO
import br.com.matheusfinamor.model.Person
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonMapper {

    fun mapEntitytoVo(person: Person): PersonVO {
        val vo = PersonVO()
        vo.id = person.id
        vo.firstName = person.firstName
        vo.lastName = person.lastName
        vo.address = person.address
        vo.gender = person.gender
        vo.birthDay = Date()
        return vo
    }

    fun mapVOToEntity(person: PersonVO): Person {
        val entity = Person()
        entity.id = person.id
        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender
        return entity
    }
}