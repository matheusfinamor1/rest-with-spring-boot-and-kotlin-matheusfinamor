package br.com.matheusfinamor.services

import br.com.matheusfinamor.model.Person
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {

    private val counter: AtomicLong = AtomicLong()
    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findByAll(): List<Person> {
        logger.info("Finding all people")

        val persons: MutableList<Person> = ArrayList()
        for (i in 0..7) {
            val person = mockPerson(i)
            persons.add(person)
        }
        return persons
    }

    fun findById(id: Long): Person {
        logger.info("Finding one person")

        val person = Person(
            id = counter.incrementAndGet(),
            firstName = "Matheus",
            lastName = "Finamor",
            address = "Santiago - RS",
            gender = "Male"
        )
        return person
    }

    fun create(person: Person) = person

    fun update(person: Person) = person

    fun delete(id: Long) {}


    private fun mockPerson(i: Int): Person {
        val person = Person(
            id = counter.incrementAndGet(),
            firstName = "Matheus $i",
            lastName = "Finamor $i",
            address = "Santiago - RS",
            gender = "Male"
        )
        return person
    }

}