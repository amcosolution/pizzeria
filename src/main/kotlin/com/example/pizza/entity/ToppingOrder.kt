package com.example.pizza.entity

import javax.persistence.*

@Entity
class ToppingOrder(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,
    val email: String,
    @ElementCollection
    @Column(name = "topping")
    val toppings: Set<String>
)