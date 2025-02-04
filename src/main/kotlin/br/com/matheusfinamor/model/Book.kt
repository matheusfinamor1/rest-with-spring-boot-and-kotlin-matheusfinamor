package br.com.matheusfinamor.model

import jakarta.persistence.*
import java.math.BigDecimal
import java.util.Date

@Entity
@Table(name = "books")
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    @Column(length = 50)
    var author: String = "",
    @Column(name = "launch_date", nullable = true)
    var launchDate: Date? = null,
    @Column
    var price: BigDecimal = BigDecimal.ZERO,
    @Column(length = 80)
    var title: String = ""
)