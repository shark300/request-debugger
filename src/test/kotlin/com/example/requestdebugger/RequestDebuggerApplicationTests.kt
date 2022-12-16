package com.example.requestdebugger

import io.restassured.RestAssured
import io.restassured.http.ContentType.JSON
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.hamcrest.CoreMatchers.equalTo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.http.HttpStatus.OK

@SpringBootTest(webEnvironment = RANDOM_PORT)
class RequestDebuggerApplicationTests(@LocalServerPort var port: Int) {

    @BeforeEach
    internal fun setUp() {
        RestAssured.port = port
        RestAssured.basePath = "/echoAPI"
    }

    @Test
    fun `calling debugger endpoint should print request`() {
        Given {
            contentType(JSON)
            body("""
                {
                    "greeting": "Hello World",
                    "other" :"thing"
                } """)
            log().ifValidationFails()
        } When {
            get("/echo")
        } Then {
            statusCode(OK.value())
            body("greeting", equalTo("Hello World"))
            body("other", equalTo("thing"))
            log().ifValidationFails()
        }
    }

}
