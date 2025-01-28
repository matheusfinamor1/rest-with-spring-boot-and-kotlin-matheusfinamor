package br.com.matheusfinamor.repository

import br.com.matheusfinamor.model.Books
import org.springframework.data.jpa.repository.JpaRepository

interface BooksRepository: JpaRepository<Books, Int?> {
}