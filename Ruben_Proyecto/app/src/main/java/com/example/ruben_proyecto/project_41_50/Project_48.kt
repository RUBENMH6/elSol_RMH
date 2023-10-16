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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ruben_proyecto.header_footer.Footer
import com.example.ruben_proyecto.header_footer.Header
import com.example.ruben_proyecto.ui.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Project_48(navController: NavController) {
    val valuesStr = remember { mutableStateListOf<String>() }
    val valuesInt = remember { mutableStateListOf<Int>().apply { repeat(10) { add(0) } } }
    var inputValue by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    var addition by remember { mutableStateOf(0) }
    var average by remember { mutableStateOf(0.0) }
    var pressed by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.weight(0.2f)
        ) {
            Header(numberProject = 48)
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
                OutlinedTextField(
                    value = inputValue,
                    onValueChange = {
                        if (valuesStr.size < 10) {
                            inputValue = it
                        } else {
                            inputValue = "You have already written 10 numbers"
                        }
                    },
                    label = { Text(text = "Insert a 10 numbers: (${valuesStr.size}/10)",)
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            if (valuesStr.size < 10) {
                                val number = inputValue.toInt()
                                valuesStr.add(inputValue)
                                valuesInt.add(number)
                                inputValue = ""
                            }
                        }
                    ),
                    singleLine = true,
                    modifier = Modifier
                        .weight(0.8f)
                        .height(60.dp),
                    shape = RoundedCornerShape(10.dp)
                )


                Spacer(modifier = Modifier.size(5.dp))
                Button(
                    onClick = {
                        if (!pressed) {
                            for (i in 0..valuesInt.size - 1) {
                                val number = valuesInt[i]
                                addition += number
                            }
                            var additionDouble = addition.toDouble()
                            average = additionDouble / 10
                            val additionStr = "Sumatory: $addition"
                            val averageStr = " Average: $average"
                            if (valuesStr.isNotEmpty()){
                                if (valuesStr.size == 10) {
                                    result = "$additionStr\n$averageStr"
                                } else {
                                    pressed = !pressed
                                    result = "Please. Enter a 10 numbers."
                                }

                            } else {
                                pressed = !pressed
                                result = "Please. Enter a 10 numbers."
                            }

                        } else {
                            result = ""
                            addition = 0
                            average = 0.0
                            valuesInt.clear()
                            valuesStr.clear()
                        }
                        if (inputValue.isNotEmpty()) {
                            inputValue = ""
                        }
                        pressed = !pressed


                    },
                    modifier = Modifier
                        .width(200.dp)
                        .height(60.dp)
                        .weight(0.2f)
                        .padding(top = 10.dp)
                        .background(color = Purple40, shape = RoundedCornerShape(10.dp)),

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Purple40
                    )
                ) {
                    Icon(
                        imageVector = if (!pressed) Icons.Default.Check else Icons.Default.Close,
                        contentDescription = if (!pressed) "Check" else "Close",
                        tint = Color.White
                    )
                }


            }
            Spacer(modifier = Modifier.size(100.dp, 20.dp))
            Row() {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Spacer(modifier = Modifier.weight(0.2f))
                    Text(
                        text = "$result",
                        color = if (result.contains("Please")) {
                            Color.Red
                        } else {
                            Color.Black
                        }

                    )
                }


            }
        }


        Column(
            modifier = Modifier.weight(0.2f),
            verticalArrangement = Arrangement.Bottom
        ) {
            Footer(navController, numberProject = 48 )
        }


    }

}