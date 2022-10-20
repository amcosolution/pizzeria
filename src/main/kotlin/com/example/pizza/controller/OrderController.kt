package com.example.pizza.controller

import com.example.pizza.dto.MessageDto
import com.example.pizza.dto.ToppingOrderDto
import com.example.pizza.service.OrderService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/orders")
class OrderController(
    val orderService: OrderService
) {
    @GetMapping
    fun getToppingsList() = ResponseEntity.ok(orderService.getOrders())

    @GetMapping("/best")
    fun getBestToppings(): ResponseEntity<MessageDto> {
        orderService.getBestToppings()?.let {
            return ResponseEntity.ok(MessageDto("Best choice for pizza: ${it.joinToString(", ")}"))
        } ?: let {
            return ResponseEntity.ok(MessageDto("Every choice is great"))
        }
    }

    @PostMapping
    fun createOrder(@Valid @RequestBody dto: ToppingOrderDto): ResponseEntity<Void> {
        orderService.createOrder(dto)
        return ResponseEntity(HttpStatus.CREATED)
    }
}