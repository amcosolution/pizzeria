package com.example.pizza.controller

import com.example.pizza.dto.ToppingOrderDto
import com.example.pizza.service.OrderService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/orders")
class OrderController(
    val orderService: OrderService
) {
    @GetMapping
    fun getToppingsList() = orderService.getOrders()

    @GetMapping("/best")
    fun getBestToppings() : String {
        orderService.getBestToppings()?.let {
            return "Best choice for pizza: ${it.joinToString ( ", " )}"
        } ?: let {
            return "Every choice is great"
        }
    }

    @PostMapping
    fun createOrder(@Valid @RequestBody dto: ToppingOrderDto) {
        orderService.createOrder(dto)
    }
}