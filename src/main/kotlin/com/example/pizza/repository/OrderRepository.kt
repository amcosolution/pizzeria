package com.example.pizza.repository

import com.example.pizza.entity.ToppingOrder
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : JpaRepository<ToppingOrder, Long> {

    fun findByEmail(email: String): ToppingOrder?
}