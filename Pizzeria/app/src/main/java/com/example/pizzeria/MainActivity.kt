package com.example.pizzeria

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pizzeria.database.PizzaDatabaseManager
import com.example.pizzeria.ui.theme.*


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PizzeriaTheme {
                val navController = rememberNavController()
                val viewModel: PizzasViewModel = viewModel()
                Scaffold(
                    topBar = { MyTopAppBar(navController, viewModel) }
                ) {
                    NavHost(
                        navController = navController, startDestination = Routes.Carta_Pizzas.route
                    ) {
                        composable(Routes.Carta_Pizzas.route) { Carta_Pizzas(navController, viewModel) }
                        composable(Routes.Pedido_Pizzas.route) { Pedido_Pizzas(navController, viewModel) }
                    }

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(navController: NavController, viewModel: PizzasViewModel) {
    var expanded by remember { mutableStateOf(false) }
    TopAppBar(
        colors = TopAppBarDefaults.largeTopAppBarColors(Palette_1_11),
        title = {
            Text(text = "Nuestras pizzas", color = Color.White, fontSize = 22.sp , fontWeight = FontWeight(500))
        },
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_menu_24),
                    contentDescription = null,
                    tint = Color.White
                )
            }
        },
        actions = {
            IconButton(onClick = { expanded = true }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_more_vert_24),
                    contentDescription = null,
                    tint = Color.White,
                )
            }
            MyDropDownMenu(expanded, {expanded = it}, navController, viewModel)
        }
    )
}

@Composable
fun MyDropDownMenu(expanded: Boolean, onExpandedChange: (Boolean) -> Unit, navController: NavController, viewModel: PizzasViewModel) {
    var selectedText by remember { mutableStateOf("") }
    val items = listOf<String>("Compartir", "Pedido")
    Spacer(modifier = Modifier.height(65.dp))
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = {
            onExpandedChange(false)
        }
    ) {
        items.forEach {
            DropdownMenuItem(
                leadingIcon = {
                    if (it == "Compartir") {
                        Icon(
                            painter = painterResource(R.drawable.baseline_share_24),
                            contentDescription = null,
                            tint = Color.Black
                        )
                    } else {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_shopping_cart_24),
                            contentDescription = null,
                            tint = Color.Black
                        )
                    }
                },
                text = { Text(text = it, color = Color.Black, fontSize = 16.sp) },
                onClick = {
                    selectedText = it
                }
            )
        }
    }
}




