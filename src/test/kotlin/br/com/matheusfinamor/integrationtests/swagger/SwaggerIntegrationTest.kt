package br.com.matheusfinamor.integrationtests.swagger

import br.com.matheusfinamor.integrationtests.TestConfigs
import br.com.matheusfinamor.integrationtests.testcontainers.AbstractIntegrationTest
import io.restassured.RestAssured
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class SwaggerIntegrationTest() : AbstractIntegrationTest() {

    @Test
    fun shouldDisplaySwaggerUiPage() {
        val content = RestAssured.given()
            .basePath("/swagger-ui.html")
            .port(TestConfigs.SERVER_PORT)
            .`when`()
            .get()
            .then()
            .statusCode(200)
            .extract()
            .body()
            .asString()
        assertTrue(content.contains("Swagger UI"))
    }

}