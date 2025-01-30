package br.com.matheusfinamor.mockito.services

import br.com.matheusfinamor.mocks.MockBook
import br.com.matheusfinamor.repository.BookRepository
import br.com.matheusfinamor.service.BookService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.jupiter.MockitoExtension
import java.math.BigDecimal
import java.util.*

@ExtendWith(MockitoExtension::class)
class BookServiceTest {

    private lateinit var inputObject: MockBook

    @InjectMocks
    private lateinit var service: BookService

    @Mock
    private lateinit var repository: BookRepository

    @BeforeEach
    fun setUp() {
        inputObject = MockBook()
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun findAll() {
        val list = inputObject.mockBookEntityList()

        `when`(repository.findAll()).thenReturn(list)

        val books = service.findAll()

        assertNotNull(books)
        assertEquals(14, books.size)

        val bookOne = books[1]
        assertNotNull(bookOne)
        assertNotNull(bookOne.key)
        assertNotNull(bookOne.links)
        assertTrue(bookOne.links.toString().contains("</book/1>;rel=\"self\""))
        assertEquals("Author Test1", bookOne.author)
        assertEquals(BigDecimal.ONE, bookOne.price)
        assertEquals("Title Test1", bookOne.title)
        assertEquals(null, bookOne.launchDate)

        val bookSeven = books[7]
        assertNotNull(bookSeven)
        assertNotNull(bookSeven.key)
        assertNotNull(bookSeven.links)
        assertTrue(bookSeven.links.toString().contains("</book/7>;rel=\"self\""))
        assertEquals("Author Test7", bookSeven.author)
        assertEquals(BigDecimal.ONE, bookSeven.price)
        assertEquals("Title Test7", bookSeven.title)
        assertEquals(null, bookSeven.launchDate)
    }

    @Test
    fun findById() {
        val book = inputObject.mockBookEntity(1)
        book.id = 1

        `when`(repository.findById(1)).thenReturn(Optional.of(book))

        val result = service.findById(1)

        assertNotNull(result)
        assertNotNull(result.key)
        assertNotNull(result.links)
        assertTrue(result.links.toString().contains("</book/1>;rel=\"self\""))
        assertEquals("Author Test1", result.author)
        assertEquals(BigDecimal.ONE, result.price)
        assertEquals("Title Test1", result.title)
        assertEquals(null, result.launchDate)
    }

    @Test
    fun create() {
        val bookEntity = inputObject.mockBookEntity(1)

        val persisted = bookEntity.copy()
        persisted.id = 1

        `when`(repository.save(bookEntity)).thenReturn(persisted)

        val bookVO = inputObject.mockBookVO(1)
        val result = service.create(bookVO)

        assertNotNull(result)
        assertNotNull(result.key)
        assertNotNull(result.links)
        assertTrue(result.links.toString().contains("</book/1>;rel=\"self\""))
        assertEquals("Author Test1", result.author)
        assertEquals(BigDecimal.ONE, result.price)
        assertEquals("Title Test1", result.title)
        assertEquals(null, result.launchDate)
    }

    @Test
    fun update() {
        val bookEntity = inputObject.mockBookEntity(1)

        val persisted = bookEntity.copy()
        persisted.id = 1

        `when`(repository.findById(1)).thenReturn(Optional.of(bookEntity))
        `when`(repository.save(bookEntity)).thenReturn(persisted)

        val bookVO = inputObject.mockBookVO(1)
        val result = service.update(bookVO)

        assertNotNull(result)
        assertNotNull(result.key)
        assertNotNull(result.links)
        assertTrue(result.links.toString().contains("</book/1>;rel=\"self\""))
        assertEquals("Author Test1", result.author)
        assertEquals(BigDecimal.ONE, result.price)
        assertEquals("Title Test1", result.title)
        assertEquals(null, result.launchDate)
    }

    @Test
    fun delete() {
        val bookEntity = inputObject.mockBookEntity(1)
        `when`(repository.findById(1)).thenReturn(Optional.of(bookEntity))
        service.delete(1)
    }
}