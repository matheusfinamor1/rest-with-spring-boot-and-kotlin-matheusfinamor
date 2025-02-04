package br.com.matheusfinamor.mocks

import br.com.matheusfinamor.data.vo.v1.BookVO
import br.com.matheusfinamor.model.Book
import java.math.BigDecimal

class MockBook {
    fun mockEntity(): Book {
        return mockBookEntity(0)
    }

    fun mockBookVO(): BookVO {
        return mockBookVO(0)
    }

    fun mockBookEntityList(): ArrayList<Book> {
        val books: ArrayList<Book> = ArrayList()
        for (i in 0..13) {
            books.add(mockBookEntity(i))
        }
        return books
    }

    fun mockBookVOList(): ArrayList<BookVO> {
        val books: ArrayList<BookVO> = ArrayList()
        for (i in 0..13) {
            books.add(mockBookVO(i))
        }
        return books
    }

    fun mockBookEntity(number: Int): Book {
        val book = Book()
        book.author = "Author Test${number}"
        book.price = BigDecimal.ONE
        book.title = "Title Test${number}"
        book.launchDate = null
        book.id = number.toLong()
        return book
    }

    fun mockBookVO(number: Int): BookVO {
        val book = BookVO()
        book.author = "Author Test${number}"
        book.price = BigDecimal.ONE
        book.title = "Title Test${number}"
        book.launchDate = null
        book.key = number.toLong()
        return book
    }


}