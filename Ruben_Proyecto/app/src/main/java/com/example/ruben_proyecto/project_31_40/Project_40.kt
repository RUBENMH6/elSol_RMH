package com.example.ruben_proyecto.project_31_40

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
fun Project_40(navController: NavController) {
    val valuesStr1 = remember { mutableStateListOf<String>() }
    val valuesStr2 = remember { mutableStateListOf<String>() }
    val valuesInt1 = remember { mutableStateListOf<Int>()}
    val valuesInt2 = remember { mutableStateListOf<Int>()}
    var inputValue1 by remember { mutableStateOf("") }
    var inputValue2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    var pressed by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.weight(0.2f)
        ) {
            Header(numberProject = 40)
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
                    value = inputValue1,
                    onValueChange = {
                        if (valuesStr1.size < 5) {
                            inputValue1 = it
                        } else {
                            inputValue1 = "You have already written 5 numbers"
                        }
                    },
                    label = { Text(text = "Insert a 5 numbers: (${valuesStr1.size}/5)",)
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            if (valuesStr1.size < 5) {
                                val number = inputValue1.toInt()
                                valuesStr1.add(inputValue1)
                                valuesInt1.add(number)
                                inputValue1 = ""
                            }
                        }
                    ),
                    singleLine = true,
                    modifier = Modifier
                        .weight(0.8f)
                        .height(60.dp),
                    shape = RoundedCornerShape(10.dp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                OutlinedTextField(
                    value = inputValue2,
                    onValueChange = {
                        if (valuesStr2.size < 5) {
                            inputValue2 = it
                        } else {
                            inputValue2 = "You have already written 5 numbers"
                        }
                    },
                    label = { Text(text = "Insert a 5 numbers: (${valuesStr2.size}/5)",)
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            if (valuesStr2.size < 5) {
                                val number = inputValue2.toInt()
                                valuesStr2.add(inputValue2)
                                valuesInt2.add(number)
                                inputValue2 = ""
                            }
                        }
                    ),
                    singleLine = true,
                    modifier = Modifier
                        .weight(0.8f)
                        .height(60.dp),
                    shape = RoundedCornerShape(10.dp)
                )
            }
            Row() {
                if (valuesInt1.size == 5 && valuesInt2.size == 5) {
                    Button(
                        onClick = {
                            var numberMaxList1 = valuesInt1.max()
                            var numberMaxList2 = valuesInt2.max()
                            if (!pressed) {
                                if (numberMaxList1 > numberMaxList2) {
                                    result = "List 1 have a biggest number"
                                } else {
                                    if (numberMaxList1 == numberMaxList2) {
                                        result = "List 1 and List 2 are equal"
                                    } else {
                                        result = "List 2 have a biggest number"
                                    }
                                }
                            } else {
                                result = ""
                                inputValue1 = ""
                                inputValue2 = ""
                                valuesInt1.clear()
                                valuesInt2.clear()
                                valuesStr1.clear()
                                valuesStr2.clear()
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
            Footer(navController, numberProject = 40 )
        }


    }

}