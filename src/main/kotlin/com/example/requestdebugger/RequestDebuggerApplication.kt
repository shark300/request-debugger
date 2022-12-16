package com.example.requestdebugger

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RequestDebuggerApplication

fun main(args: Array<String>) {
	runApplication<RequestDebuggerApplication>(*args)
}
