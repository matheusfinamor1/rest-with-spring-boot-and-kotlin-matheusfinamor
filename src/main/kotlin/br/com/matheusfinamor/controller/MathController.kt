package br.com.matheusfinamor.controller

import br.com.matheusfinamor.converters.NumberConverter.convertToDouble
import br.com.matheusfinamor.converters.NumberConverter.isNumeric
import br.com.matheusfinamor.math.SimpleMath
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MathController(
    private val math: SimpleMath
) {

    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
            /** @PathVariable recupera dados da URL */
    fun sum(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedOperationException("Please set a numeric value")
        return math.sum(convertToDouble(numberOne), convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["/sub/{numberOne}/{numberTwo}"])
            /** @PathVariable recupera dados da URL */
    fun sub(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedOperationException("Please set a numeric value")
        return math.sub(convertToDouble(numberOne), convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["/mult/{numberOne}/{numberTwo}"])
            /** @PathVariable recupera dados da URL */
    fun mult(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedOperationException("Please set a numeric value")
        return math.mult(convertToDouble(numberOne), convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["/div/{numberOne}/{numberTwo}"])
            /** @PathVariable recupera dados da URL */
    fun div(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedOperationException("Please set a numeric value")
        return math.div(convertToDouble(numberOne), convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["/med/{numberOne}/{numberTwo}"])
            /** @PathVariable recupera dados da URL */
    fun med(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedOperationException("Please set a numeric value")
        return math.med(convertToDouble(numberOne), convertToDouble(numberTwo))
    }
}