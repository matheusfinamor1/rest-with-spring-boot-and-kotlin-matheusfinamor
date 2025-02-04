package br.com.matheusfinamor.repository

import br.com.matheusfinamor.model.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository: JpaRepository<Book, Int?> {
}