package br.com.matheusfinamor.service

import br.com.matheusfinamor.controller.BookController
import br.com.matheusfinamor.data.vo.v1.BookVO
import br.com.matheusfinamor.exceptions.ResourceNotFoundException
import br.com.matheusfinamor.extension.toBookEntity
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
        for (book in books) {
            val withSelfRell = linkTo(BookController::class.java).slash(book.key).withSelfRel()
            book.add(withSelfRell)
        }
        return books
    }

    fun findById(id: Long): BookVO {
        val book = repository.findById(id.toInt()).map { it.toBookVO() }
            .orElseThrow { ResourceNotFoundException("No records found for this ID") }
        val withSelfRell = linkTo(BookController::class.java).slash(book.key).withSelfRel()
        return book.add(withSelfRell)
    }

    fun create(book: BookVO): BookVO {
        val entity = repository.save(book.toBookEntity())
        val bookVO = entity.toBookVO()

        val withSelfRell = linkTo(BookController::class.java).slash(bookVO.key).withSelfRel()
        bookVO.add(withSelfRell)
        return bookVO
    }

    fun update(book: BookVO): BookVO {
        val bookEntity = repository.findById(book.key.toInt())
            .orElseThrow { ResourceNotFoundException("No records found for this ID") }

        bookEntity.author = book.author
        bookEntity.title = book.title
        bookEntity.price = book.price
        bookEntity.launchDate = book.launchDate

        val bookVO = repository.save(bookEntity).toBookVO()

        val withSelfRell = linkTo(BookController::class.java).slash(bookVO.key).withSelfRel()
        bookVO.add(withSelfRell)
        return bookVO
    }

    fun delete(id: Long) {
        val entity =
            repository.findById(id.toInt()).orElseThrow { ResourceNotFoundException("No records found for this ID") }
        repository.delete(entity)
    }
}