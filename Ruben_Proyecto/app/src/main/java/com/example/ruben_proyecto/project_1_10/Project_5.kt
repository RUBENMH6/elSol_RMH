package com.example.ruben_proyecto.project_1_10

import androidx.compose.foundation.Image
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ruben_proyecto.R
import com.example.ruben_proyecto.header_footer.Footer
import com.example.ruben_proyecto.header_footer.Header
import com.example.ruben_proyecto.ui.theme.Purple40


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Project_5(navController: NavController) {
    var number1 by remember { mutableStateOf("") }
    var number2 by remember { mutableStateOf("") }
    var resultSum by remember { mutableStateOf("") }
    var resultSub by remember { mutableStateOf("") }
    var resultMul by remember { mutableStateOf("") }
    var resultDiv by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        ) {
        Column(
            modifier = Modifier.weight(0.2f)
        ) {
            Header(5)
        }

        Column(
            modifier = Modifier.weight(0.6f),
            verticalArrangement = Arrangement.Center
        ) {

            OutlinedTextField(
                value = number1,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { newValue -> number1 = newValue },
                label = { Text("Insert a number") }
            )

            OutlinedTextField(
                value = number2,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { newValue -> number2 = newValue },
                label = { Text("Insert a number") }
            )
            Row(
                modifier = Modifier.padding(16.dp),

                ) {
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = {
                        val num1 = number1.toIntOrNull() ?: 0
                        val num2 = number2.toIntOrNull() ?: 0
                        val sum = num1 + num2
                        val substract = num1 - num2
                        val multiplication = num1 * num2
                        val division: Int
                        if (num2 != 0) {
                            division = num1 / num2
                        } else {
                            division = 0
                        }
                        resultSum = sum.toString()
                        resultSub = substract.toString()
                        resultMul = multiplication.toString()
                        resultDiv = division.toString() + "(" + num1 % num2 + ")"

                    },
                    modifier = Modifier
                        .width(200.dp)
                        .height(40.dp)
                        .weight(3f)
                        .background(color = Purple40, shape = RoundedCornerShape(10.dp)),

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Purple40
                    )
                ) {
                    Text(text = "Calculate")
                }
                Spacer(modifier = Modifier.weight(1f))
            }


            Row() {

                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(2f)
                ) {
                    Row(

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.sum),
                            contentDescription = "sum",
                            modifier = Modifier.size(30.dp)
                        )
                        Spacer(modifier = Modifier.size(130.dp, 50.dp))

                        Text(
                            text = "$resultSum",
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )


                    }
                    Row() {
                        Image(
                            painter = painterResource(id = R.drawable.rest),
                            contentDescription = "rest",
                            modifier = Modifier.size(30.dp)
                        )
                        Spacer(modifier = Modifier.size(130.dp, 50.dp))

                        Text(
                            text = "$resultSub",
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                    }

                    Row() {
                        Image(
                            painter = painterResource(id = R.drawable.mult),
                            contentDescription = "mult",
                            modifier = Modifier.size(30.dp)
                        )
                        Spacer(modifier = Modifier.size(130.dp, 50.dp))
                        Text(
                            text = "$resultMul",
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )

                    }

                    Row() {
                        Image(
                            painter = painterResource(id = R.drawable.div),
                            contentDescription = "div",
                            modifier = Modifier.size(30.dp)
                        )
                        Spacer(modifier = Modifier.size(130.dp, 50.dp))
                        Text(
                            text = "$resultDiv",
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                    }
                }


            }

        }
        Column(
            modifier = Modifier.weight(0.2f),
            verticalArrangement = Arrangement.Bottom
        ) {
            Footer(navController, 5)
        }

    }


}

