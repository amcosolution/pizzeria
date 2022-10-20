package com.example.pizza.controller

import com.example.pizza.dto.MessageDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths

@RestController
class IntroductionController {

    val filePath = "src/main/resources/README.txt"

    @GetMapping
    fun index() = ResponseEntity.ok(MessageDto(readFile(filePath)))

    fun readFile(path: String): String {
        val encoded = Files.readAllBytes(Paths.get(path))
        return String(encoded, StandardCharsets.UTF_8)
    }
}