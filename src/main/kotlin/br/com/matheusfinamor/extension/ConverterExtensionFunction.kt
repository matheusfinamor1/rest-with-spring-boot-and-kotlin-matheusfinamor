package br.com.matheusfinamor.extension

import br.com.matheusfinamor.data.vo.v1.BookVO
import br.com.matheusfinamor.model.Book

fun Book.toBookVO(): BookVO {
    return BookVO(
        key = this.id,
        title = this.title,
        price = this.price,
        author = this.author,
        launchDate = this.launchDate
    )
}

fun BookVO.toBookEntity(): Book {
    return Book(
        title = this.title,
        price = this.price,
        author = this.author,
        launchDate = this.launchDate
    )
}