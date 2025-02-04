package br.com.matheusfinamor.data.vo.v1

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.github.dozermapper.core.Mapping
import org.springframework.hateoas.RepresentationModel

/** coloca os dados do objeto JSON na ordem desejada */
@JsonPropertyOrder("id","address","first_name", "last_name", "gender")
data class PersonVO(
    @Mapping("id")
    @field:JsonProperty("id")
    var key: Long = 0,
    /** altera o nome do atributo do objeto JSON */
    @field:JsonProperty("first_name")
    var firstName: String = "",
    @field:JsonProperty("last_name")
    var lastName: String = "",
    var address: String = "",
    var gender: String = ""
): RepresentationModel<PersonVO>()