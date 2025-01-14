package br.com.matheusfinamor.repository

import br.com.matheusfinamor.model.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository: JpaRepository<Person, Long?> {
}