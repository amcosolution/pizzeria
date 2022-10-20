package com.example.pizza.util

import com.example.pizza.dto.ToppingOrderDto
import com.example.pizza.entity.ToppingOrder


fun ToppingOrder.toDto() = ToppingOrderDto(
    email = email,
    toppings = toppings
)

fun ToppingOrderDto.toOrder(id: Long? = null) = ToppingOrder(
    id,
    email = email,
    toppings = toppings
)
