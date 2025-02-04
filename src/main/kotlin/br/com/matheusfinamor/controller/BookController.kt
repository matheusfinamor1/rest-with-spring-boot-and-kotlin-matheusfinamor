package br.com.matheusfinamor.controller

import br.com.matheusfinamor.data.vo.v1.BookVO
import br.com.matheusfinamor.service.BookService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/book")
@Tag(name = "Book", description = "Endpoints for Meaning Book")
class BookController {

    @Autowired
    private lateinit var service: BookService

    @GetMapping(
        value = ["/v1"],
        produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE]
    )
    @Operation(
        summary = "Finds all book", description = "Finds all book",
        tags = ["Book"],
        responses = [
            ApiResponse(
                description = "Success",
                responseCode = "200",
                content = [
                    Content(array = ArraySchema(schema = Schema(implementation = BookVO::class)))
                ]
            ),
            ApiResponse(
                description = "No Content",
                responseCode = "204",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
            ApiResponse(
                description = "Bad Request",
                responseCode = "400",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
            ApiResponse(
                description = "Unauthorized",
                responseCode = "401",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
            ApiResponse(
                description = "Not Found",
                responseCode = "404",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
            ApiResponse(
                description = "Internal Error",
                responseCode = "500",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
        ]
    )
    fun findAll(): List<BookVO> {
        return service.findAll()
    }

    @GetMapping(
        value = ["/v1/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE]
    )
    @Operation(
        summary = "Finds a book", description = "Finds a book",
        tags = ["Book"],
        responses = [
            ApiResponse(
                description = "Success",
                responseCode = "200",
                content = [
                    Content(schema = Schema(implementation = BookVO::class))
                ]
            ),
            ApiResponse(
                description = "No Content",
                responseCode = "204",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
            ApiResponse(
                description = "Bad Request",
                responseCode = "400",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
            ApiResponse(
                description = "Unauthorized",
                responseCode = "401",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
            ApiResponse(
                description = "Not Found",
                responseCode = "404",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
            ApiResponse(
                description = "Internal Error",
                responseCode = "500",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
        ]
    )
    fun findById(
        @PathVariable(value = "id") id: Long
    ): BookVO {
        return service.findById(id)
    }

    @PostMapping(
        value = ["/v1"],
        produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE]
    )
    @Operation(
        summary = "Adds a new book", description = "Adds a new book",
        tags = ["Book"],
        responses = [
            ApiResponse(
                description = "Success",
                responseCode = "200",
                content = [
                    Content(schema = Schema(implementation = BookVO::class))
                ]
            ),
            ApiResponse(
                description = "Bad Request",
                responseCode = "400",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
            ApiResponse(
                description = "Unauthorized",
                responseCode = "401",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
            ApiResponse(
                description = "Internal Error",
                responseCode = "500",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
        ]
    )
    fun create(
        @RequestBody book: BookVO
    ): BookVO {
        return service.create(book)
    }

    @PutMapping(
        value = ["/v1"],
        produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE]
    )
    @Operation(
        summary = "Updates a book's information", description = "Updates a book's information",
        tags = ["Book"],
        responses = [
            ApiResponse(
                description = "Success",
                responseCode = "200",
                content = [
                    Content(schema = Schema(implementation = BookVO::class))
                ]
            ),
            ApiResponse(
                description = "No Content",
                responseCode = "204",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
            ApiResponse(
                description = "Bad Request",
                responseCode = "400",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
            ApiResponse(
                description = "Unauthorized",
                responseCode = "401",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
            ApiResponse(
                description = "Not Found",
                responseCode = "404",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
            ApiResponse(
                description = "Internal Error",
                responseCode = "500",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
        ]
    )
    fun update(
        @RequestBody book: BookVO
    ): BookVO {
        return service.update(book)
    }

    @DeleteMapping(
        value = ["/v1/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE]
    )
    @Operation(
        summary = "Deletes a book", description = "Deletes a book",
        tags = ["Book"],
        responses = [
            ApiResponse(
                description = "No Content",
                responseCode = "204",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
            ApiResponse(
                description = "Bad Request",
                responseCode = "400",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
            ApiResponse(
                description = "Unauthorized",
                responseCode = "401",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
            ApiResponse(
                description = "Not Found",
                responseCode = "404",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
            ApiResponse(
                description = "Internal Error",
                responseCode = "500",
                content = [
                    Content(schema = Schema(implementation = Unit::class))
                ]
            ),
        ]
    )
    fun delete(
        @PathVariable(value = "id") id: Long
    ): ResponseEntity<*> {
        service.delete(id)
        return ResponseEntity.noContent().build<Any>()
    }

}