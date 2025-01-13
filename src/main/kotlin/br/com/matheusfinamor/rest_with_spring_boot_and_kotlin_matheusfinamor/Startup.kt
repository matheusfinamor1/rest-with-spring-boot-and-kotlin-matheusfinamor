package br.com.matheusfinamor.rest_with_spring_boot_and_kotlin_matheusfinamor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Startup

fun main(args: Array<String>) {
	runApplication<Startup>(*args)
}
