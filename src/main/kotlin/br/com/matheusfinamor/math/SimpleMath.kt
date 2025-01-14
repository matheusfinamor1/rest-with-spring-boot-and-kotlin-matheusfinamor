package br.com.matheusfinamor.math

import org.springframework.stereotype.Component

@Component
class SimpleMath {
    fun sum(numberOne: Double, numberTwo: Double) = numberOne + numberTwo
    fun sub(numberOne: Double, numberTwo: Double) = numberOne - numberTwo
    fun mult(numberOne: Double, numberTwo: Double) = (numberOne * numberTwo)
    fun div(numberOne: Double, numberTwo: Double) = (numberOne / numberTwo)
    fun med(numberOne: Double, numberTwo: Double) = (numberOne + numberTwo)/2
}