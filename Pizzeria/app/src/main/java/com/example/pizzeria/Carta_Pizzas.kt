package com.example.pizzeria

import android.util.Log
import android.app.Application
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pizzeria.database.PizzaDatabaseManager
import com.example.pizzeria.ui.theme.*

@Composable
fun Carta_Pizzas(navController: NavController, viewModel: PizzasViewModel) {
    var pedido_pizzas = remember { mutableListOf<PizzaInfo>() }
    val pizzaDatabaseManager: PizzaDatabaseManager
    val context = LocalContext.current

    Column(modifier = Modifier
        .fillMaxWidth()
        .background(Palette_1_4)) {
        Spacer(modifier = Modifier.height(40.dp))
        LazyColumn(modifier = Modifier.padding(10.dp)) {
            items(getPizzaInfo()) {
                Spacer(modifier = Modifier.weight(0.05f))
                MyCardCarta(it, pedido_pizzas)
                Spacer(modifier = Modifier.weight(0.05f))
            }
        }

    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
    ) {

        FloatingActionButton(
            onClick = {
                if (pedido_pizzas.isEmpty()) {
                    Toast.makeText(context, "No has seleccionado ninguna pizza", Toast.LENGTH_LONG).show()
                } else {
                    viewModel.selectEstablishment(pedido_pizzas)
                    navController.navigate("Pedido_Pizzas")
                }

            },
            shape = RoundedCornerShape(30.dp),
            containerColor = Palette_1_9,
            modifier = Modifier.align(Alignment.BottomEnd)
        ) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Back",
                tint = Color.White
            )
        }
    }
}

@Composable
fun MyCardCarta(
    pizzaInfo: PizzaInfo,
    pedido_pizzas: MutableList<PizzaInfo>
) {
    var add_pedido by remember { mutableStateOf(false) }
    var ingredients by remember { mutableStateOf("")}
    var counter by remember { mutableStateOf(0)}
    ingredients = getIngredientsFromPizza(pizzaInfo)
    Spacer(modifier = Modifier.height(20.dp))
    Card(
        colors = CardDefaults.cardColors(Palette_1_8),
        elevation = CardDefaults.cardElevation(6.dp),

    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(pizzaInfo.imageId),
                contentDescription = pizzaInfo.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .weight(0.4f)
                    .size(200.dp)
            )
            Column(
                modifier = Modifier
                    .weight(0.6f)
                    .fillMaxHeight()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "Pizza ${pizzaInfo.name}",
                        fontSize = 18.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .weight(0.8f)
                            .padding(start = 12.dp)
                    )

                            IconButton(
                                onClick = {
                                    if (!pedido_pizzas.contains(pizzaInfo)) {
                                        pedido_pizzas.add(pizzaInfo)
                                    } else {
                                        pedido_pizzas.remove(pizzaInfo)
                                    }
                                    add_pedido = !add_pedido

                                },
                                modifier = Modifier
                                    .background(
                                        if (add_pedido) {
                                            Palette_1_9
                                        } else {
                                            Color.Transparent
                                        }
                                    )

                            ) {
                                Icon(
                                    imageVector = ImageVector.Companion.vectorResource(R.drawable.baseline_add_24),
                                    contentDescription = null,
                                    tint = Color.White
                                )
                            }




                }
                Spacer(modifier = Modifier.width(12.dp))
                Divider(color = Color.White)
                Spacer(modifier = Modifier.width(12.dp))
                Row(
                    modifier = Modifier
                        .height(100.dp)
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = ingredients,
                        textAlign = TextAlign.Center,
                        letterSpacing = 2.sp,
                        lineHeight = 16.sp,
                        color = Color.White)
                }
                Divider(color = Color.White)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text( text = "${pizzaInfo.price} €", fontWeight = FontWeight.Bold, color = Color.White)
                }
            }

        }


    }
}

fun getIngredientsFromPizza(pizza: PizzaInfo): String {
    var ingredientes = ""
    for (i in 0 .. pizza.ingredients.size-1) {
        if (i == pizza.ingredients.size-1) {
            ingredientes += "y ${pizza.ingredients[i]}"
        } else {
            if (i + 1 == pizza.ingredients.size -1) {
                ingredientes += "${pizza.ingredients[i]} "
            } else {
                ingredientes += "${pizza.ingredients[i]}, "
            }
        }
    }
    return ingredientes
}



