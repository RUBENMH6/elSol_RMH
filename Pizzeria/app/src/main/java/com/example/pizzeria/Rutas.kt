package com.example.pizzeria


sealed class Routes(val route : String){
    object Carta_Pizzas: Routes("Carta_Pizzas")
    object Pedido_Pizzas: Routes("Pedido_Pizzas") }