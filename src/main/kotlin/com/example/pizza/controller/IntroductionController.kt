package com.example.pizza.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.io.File
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths

@RestController
class IntroductionController {

    val filePath = "src/main/resources/README.txt"

    @GetMapping
    fun index() = readFile(filePath, StandardCharsets.UTF_8)

    fun readFile(path: String, encoding: Charset): String {
        val encoded = Files.readAllBytes(Paths.get(path))
        return String(encoded, encoding)
    }
}