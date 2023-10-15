package com.example.pizzeria

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class PizzasViewModel : ViewModel() {
    var selectedEstablishment = mutableStateListOf<PizzaInfo>()

    fun selectEstablishment(pedido_pizza: MutableList<PizzaInfo>) {
        selectedEstablishment.clear()
        selectedEstablishment.addAll(pedido_pizza)
    }
}