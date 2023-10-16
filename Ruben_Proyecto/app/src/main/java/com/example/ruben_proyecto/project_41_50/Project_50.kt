package com.example.ruben_proyecto.project_41_50


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ruben_proyecto.header_footer.Footer
import com.example.ruben_proyecto.header_footer.Header
import com.example.ruben_proyecto.ui.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Project_50(navController: NavController) {
    var result by remember { mutableStateOf("") }
    var mult3 by remember { mutableStateOf(0) }
    var mult5 by remember { mutableStateOf(0) }
    var mult9 by remember { mutableStateOf(0) }
    var pressed by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.weight(0.2f)
        ) {
            Header(numberProject = 50)
        }
        Column(
            modifier = Modifier.weight(0.6f),
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.size(100.dp, 20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.weight(1f))
                if (!pressed) {
                    Button(
                        onClick = {
                            pressed = !pressed
                            for (i in 1 .. 10000) {
                                if (i % 3 == 0) {
                                    mult3++
                                    if (i % 9 == 0) {
                                        mult9++
                                    }
                                }

                                if (i % 5 == 0) {
                                    mult5++
                                }
                            }
                            result = "Multiples of 3: $mult3\nMultiples of 5: $mult5\nMultiples of 9: $mult9 "
                        },
                        modifier = Modifier
                            .width(200.dp)
                            .height(40.dp)
                            .weight(3f)
                            .background(color = Purple40, shape = RoundedCornerShape(10.dp)),

                        colors = ButtonDefaults.buttonColors(
                            containerColor = Purple40
                        )
                    )
                    {
                        Text("Show multiples")

                    }

                }

                Spacer(modifier = Modifier.weight(1f))

            }
            Spacer(modifier = Modifier.size(100.dp, 20.dp))
            Row() {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = result,
                        fontWeight = FontWeight.Bold
                    )
                }


            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.weight(1f))
                if (pressed) {
                    Button(
                        onClick = {
                            pressed = !pressed
                            result = ""
                            mult3 = 0
                            mult5 = 0
                            mult9 = 0
                        },
                        modifier = Modifier
                            .width(200.dp)
                            .height(40.dp)
                            .weight(1f)
                            .background(color = Purple40, shape = RoundedCornerShape(10.dp)),

                        colors = ButtonDefaults.buttonColors(
                            containerColor = Purple40
                        )
                    ) {
                        Text(text = "Try again")
                    }

                }
                Spacer(modifier = Modifier.weight(1f))
            }
        }
        Column(
            modifier = Modifier.weight(0.2f),
            verticalArrangement = Arrangement.Bottom
        ) {
            Footer(navController, numberProject = 50 )
        }


    }
}