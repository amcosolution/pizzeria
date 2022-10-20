package com.example.pizza.service

import com.example.pizza.dto.ToppingOrderDto
import com.example.pizza.entity.ToppingOrder
import com.example.pizza.repository.OrderRepository
import com.example.pizza.util.toOrder
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class OrderService(
    val orderRepository: OrderRepository
) {
    val personalEmail = "a.maiseyenak@gmail.com"
    fun getOrders(): Map<String, Int> {
        val list = orderRepository.findAll()
        val toppingMap = list.stream().flatMap{ obj: ToppingOrder -> obj.toppings.stream()}
            .collect(
                Collectors.toMap(
                    { topping: String -> topping },
                    { _: String -> 1 },
                    { a: Int, b: Int -> Integer.sum(a, b) })
            )
        return toppingMap
    }

    fun getBestToppings(): Set<String>? =
        orderRepository.findByEmail(personalEmail)?.toppings

    fun createOrder(dto: ToppingOrderDto) {
        val order = orderRepository.findByEmail(dto.email)
        orderRepository.save(dto.toOrder(order?.id))
    }
}
