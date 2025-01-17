package br.com.matheusfinamor.data.vo.v1

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

/** coloca os dados do objeto JSON na ordem desejada */
@JsonPropertyOrder("id","address","first_name", "last_name", "gender")
data class PersonVO(
    var id: Long = 0,
    /** altera o nome do atributo do objeto JSON */
    @field:JsonProperty("first_name")
    var firstName: String = "",
    @field:JsonProperty("last_name")
    var lastName: String = "",
    var address: String = "",
    var gender: String = ""
)