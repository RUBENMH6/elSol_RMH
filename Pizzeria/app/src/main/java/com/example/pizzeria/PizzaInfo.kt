package com.example.pizzeria


data class PizzaInfo(val imageId: Int, val name: String, val price: Double, val ingredients: List<String>, var fav: Boolean)

fun getPizzaInfo(): MutableList<PizzaInfo> {
    return mutableListOf(
        PizzaInfo(R.drawable.pizza1, "Margarita", 10.0, listOf("Tomate", "Mozzarella", "Orégano"), false  ),
        PizzaInfo(R.drawable.pizza2, "Proscuito", 10.0, listOf("Tomate", "Mozzarella", "Jamón York"), false  ),
        PizzaInfo(R.drawable.pizza3, "Regina", 10.0, listOf("Tomate", "Mozzarella", "Jamón York", "Champiñones"), false  ),
        PizzaInfo(R.drawable.pizza4, "Provinciale", 10.0, listOf("Tomate", "Mozzarella", "Bacon", "Cebolla"), false  ),
        PizzaInfo(R.drawable.pizza5, "Carbonara", 10.0, listOf("Tomate", "Mozzarella", "Bacon", "Champiñones", "Salsa carbonara"), false  ),
        //PizzaInfo(R.drawable.pizza6, "Margarita", 10.0, listOf("Tomate", "Mozzarella", "Orégano"), false  ),
        PizzaInfo(R.drawable.pizza7, "Calzone", 10.0, listOf("Tomate", "Mozzarella", "Jamón Yor", "Huevo cocido", "Ajo"), false  ),
        PizzaInfo(R.drawable.pizza8, "Margarita", 10.0, listOf("Tomate", "Mozzarella", "Orégano"), false  ),
        PizzaInfo(R.drawable.pizza9, "Margarita", 10.0, listOf("Tomate", "Mozzarella", "Orégano"), false  ),
        PizzaInfo(R.drawable.pizza10, "Margarita", 10.0, listOf("Tomate", "Mozzarella", "Orégano"), false  ),
        PizzaInfo(R.drawable.pizza11, "Margarita", 10.0, listOf("Tomate", "Mozzarella", "Orégano"), false  ),
        PizzaInfo(R.drawable.pizza12, "Margarita", 10.0, listOf("Tomate", "Mozzarella", "Orégano"), false  ),
        PizzaInfo(R.drawable.pizza13, "Margarita", 10.0, listOf("Tomate", "Mozzarella", "Orégano"), false  ),
        PizzaInfo(R.drawable.pizza14, "Margarita", 10.0, listOf("Tomate", "Mozzarella", "Orégano"), false  ),
        PizzaInfo(R.drawable.pizza15, "Margarita", 10.0, listOf("Tomate", "Mozzarella", "Orégano"), false  ),
        PizzaInfo(R.drawable.pizza16, "Margarita", 10.0, listOf("Tomate", "Mozzarella", "Orégano"), false  ),
        PizzaInfo(R.drawable.pizza17, "Margarita", 10.0, listOf("Tomate", "Mozzarella", "Orégano"), false  ),
        //PizzaInfo(R.drawable.pizza18, "Margarita", 10.0, listOf("Tomate", "Mozzarella", "Orégano"), false  ),
        //PizzaInfo(R.drawable.pizza19, "Margarita", 10.0, listOf("Tomate", "Mozzarella", "Orégano"), false  ),
        PizzaInfo(R.drawable.pizza20, "Margarita", 10.0, listOf("Tomate", "Mozzarella", "Orégano"), false  ),
        PizzaInfo(R.drawable.pizza21, "Margarita", 10.0, listOf("Tomate", "Mozzarella", "Orégano"), false  ),
    )
}



