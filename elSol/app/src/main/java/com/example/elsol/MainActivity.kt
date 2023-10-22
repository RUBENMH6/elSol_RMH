package com.example.elsol

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.elsol.ui.theme.ElSolTheme
import com.example.elsol.ui.theme.Oscuro
import com.example.elsol.ui.theme.Purple80
import elSol

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ElSolTheme {
                val snackbarHostState = remember { SnackbarHostState() }
                val drawerState = rememberDrawerState(DrawerValue.Closed)
                Scaffold(
                    snackbarHost =  { SnackbarHost (hostState = snackbarHostState)
                    } ,
                    bottomBar = { MyBottomAppBar(drawerState)},

                ) {
                    ModalNavigationDrawer(
                        drawerContent = {
                            ModalDrawerSheet {
                                NavigationDrawerItem(
                                    label = { Text(text = "Drawer Item") },
                                    selected = false,
                                    onClick = { /*TODO*/ }
                                )

                            }
                        },
                        drawerState = drawerState
                    ) {

                    }
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(bottom = it.calculateBottomPadding())
                    ) {
                        val navController = rememberNavController()
                        NavHost(
                            navController = navController, startDestination = Routes.elSol.route
                        ) {
                            composable(Routes.elSol.route) { elSol(snackbarHostState) }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBottomAppBar(drawerState: DrawerState) {
    var click by remember { mutableStateOf(0)}

    BottomAppBar(
        containerColor = Color.Red
    ) {
        IconButton(onClick = {
            //drawerState.open()
        }) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "ArrowBack",
                tint = Color.White
            )
        }

        IconButton(
            onClick = { click++ },
        ) {
            BadgedBox(
                badge = {
                    Text(
                        text = click.toString(),
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .size(20.dp)
                            .background(Oscuro, RoundedCornerShape(30.dp))
                    )
                }) {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "Favorite",
                    tint = Color.White)
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {

                },
                modifier = Modifier
                    .size(40.dp)
                    .background(Purple80, RoundedCornerShape(16.dp))
            ) {
                Icon(
                    painter = painterResource(R.drawable.baseline_add_24),
                    contentDescription = "Add"
                )
            }
        }
    }



}
