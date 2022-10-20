package com.example.pizza.dto

import javax.validation.constraints.Email

class ToppingOrderDto (
    @field:Email
    val email: String,
    val toppings: Set<String>
    )