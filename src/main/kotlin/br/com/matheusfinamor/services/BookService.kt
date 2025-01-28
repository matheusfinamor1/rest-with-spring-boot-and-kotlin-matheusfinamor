package br.com.matheusfinamor.services

import br.com.matheusfinamor.controller.BookController
import br.com.matheusfinamor.data.vo.v1.BookVO
import br.com.matheusfinamor.extension.toBookVO
import br.com.matheusfinamor.repository.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.stereotype.Service

@Service
class BookService {

    @Autowired
    private lateinit var repository: BookRepository

    fun findAll(): List<BookVO> {
        val books = repository.findAll().map { it.toBookVO() }.toList()
        for (book in books){
            val withSelfRell = linkTo(BookController::class.java).slash(book.key).withSelfRel()
            book.add(withSelfRell)
        }
        return books
    }
}