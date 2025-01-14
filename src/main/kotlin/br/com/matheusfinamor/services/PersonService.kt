package br.com.matheusfinamor.services

import br.com.matheusfinamor.model.Person
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {

    private val counter: AtomicLong = AtomicLong()
    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findById(id: Long): Person{
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

}