package com.example.pizzeria

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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.PointerId
import androidx.compose.ui.input.pointer.PointerInputChange
import androidx.compose.ui.input.pointer.PointerInputScope
import androidx.compose.ui.input.pointer.isSecondaryPressed
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pizzeria.ui.theme.Palette_1_4
import com.example.pizzeria.ui.theme.Palette_1_8
import com.example.pizzeria.ui.theme.Palette_1_9
import com.example.pizzeria.ui.theme.Pink80
import com.example.pizzeria.ui.theme.Purple80

@Composable
fun Pedido_Pizzas(navController: NavController, viewModel: PizzasViewModel) {
    var total_price by remember { mutableStateOf(0.0)}
    total_price = getInitialPrice(viewModel)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Palette_1_4)
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        LazyColumn(modifier = Modifier.padding(10.dp)) {
            items(getPizzaPedido(viewModel)) {
                Spacer(modifier = Modifier.weight(0.05f))
                MyCardPedido(it, total_price, {total_price = it})
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
                navController.navigate("Carta_Pizzas")
            },
            shape = RoundedCornerShape(30.dp),
            containerColor = Palette_1_9,
            modifier = Modifier.align(Alignment.BottomStart)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color.White
            )
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        contentAlignment = Alignment.BottomCenter
    ) {

        Card(
            elevation = CardDefaults.cardElevation(6.dp),
            colors = CardDefaults.cardColors(Palette_1_9)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.height(40.dp).width(20.dp))
                Text(
                    text = "Precio total: $total_price €",
                    color = Color.White,
                    textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(40.dp).width(20.dp))

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

            },
            shape = RoundedCornerShape(30.dp),
            containerColor = Palette_1_9,
            modifier = Modifier.align(Alignment.BottomEnd)
        ) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Buy",
                tint = Color.White
            )
        }
    }
}

@Composable
fun MyCardPedido(
    pizzaInfo: PizzaInfo,
    total_price: Double,
    onTotalPriceChange: (Double) -> Unit
) {
    var ingredients by remember { mutableStateOf("") }
    var counterPizza by remember { mutableStateOf(1) }

    var totalPrice = counterPizza * pizzaInfo.price

    ingredients = getIngredientsFromPizza(pizzaInfo)
    Spacer(modifier = Modifier.height(20.dp))
    Card(
        colors = CardDefaults.cardColors(Palette_1_8),
        elevation = CardDefaults.cardElevation(6.dp)
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
                        text = pizzaInfo.name,
                        fontSize = 18.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .weight(0.8f)
                            .padding(start = 12.dp)
                    )
                    Column() {
                        Row(
                            modifier = Modifier.background(Palette_1_9),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            IconButton(
                                onClick = {
                                    if (counterPizza > 0) {
                                        counterPizza--
                                        onTotalPriceChange(total_price - pizzaInfo.price)
                                    } },
                                modifier = Modifier.background(Palette_1_9)
                            ) {
                                Icon(
                                    imageVector = ImageVector.Companion.vectorResource(R.drawable.baseline_remove_24),
                                    contentDescription = null,
                                    tint = Color.White
                                )
                            }
                            Text(
                                text = "$counterPizza",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .background(Palette_1_9)
                                    .fillMaxHeight()
                            )
                            IconButton(
                                onClick = { counterPizza++
                                    onTotalPriceChange(total_price + pizzaInfo.price)},
                                modifier = Modifier.background(Palette_1_9)
                            ) {
                                Icon(
                                    imageVector = ImageVector.Companion.vectorResource(R.drawable.baseline_add_24),
                                    contentDescription = null,
                                    tint = Color.White
                                )
                            }
                        }
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
                        color = Color.White
                    )
                }
                Divider(color = Color.White)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text =
                            if (counterPizza == 1) {
                            "${pizzaInfo.price} €"
                        }  else {
                            "(${totalPrice} €) ${pizzaInfo.price} €"
                            }
                               
                               ,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }

        }


    }

}

fun getInitialPrice(viewModel: PizzasViewModel): Double {
    val selectedEstablishment = viewModel.selectedEstablishment
    var initial_price = 0.0
    for (i in 0 .. selectedEstablishment.size-1) {
        initial_price += selectedEstablishment[i].price
    }
    return initial_price
}

fun getPizzaPedido(viewModel: PizzasViewModel): MutableList<PizzaInfo> {
    val selectedEstablishment = viewModel.selectedEstablishment
    return selectedEstablishment
}