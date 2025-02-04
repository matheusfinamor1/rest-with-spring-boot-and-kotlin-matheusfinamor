package br.com.matheusfinamor.data.vo.v1

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.dozermapper.core.Mapping
import org.springframework.hateoas.RepresentationModel
import java.math.BigDecimal
import java.util.*

data class BookVO(
    @Mapping("id")
    @field:JsonProperty("id")
    var key: Long = 0,
    var author: String = "",
    @field:JsonProperty("launch_date")
    var launchDate: Date? = null,
    var price: BigDecimal = BigDecimal.ZERO,
    var title: String = ""
): RepresentationModel<BookVO>()