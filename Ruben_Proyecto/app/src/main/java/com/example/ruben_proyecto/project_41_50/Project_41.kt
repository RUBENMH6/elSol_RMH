package com.example.ruben_proyecto.project_41_50

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
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ruben_proyecto.header_footer.Footer
import com.example.ruben_proyecto.header_footer.Header
import com.example.ruben_proyecto.ui.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Project_41(navController: NavController) {
    var inputValue by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    var counter by remember { mutableStateOf(0) }
    var par by remember { mutableStateOf(0) }
    var impar by remember { mutableStateOf(0) }
    var numberStr by remember { mutableStateOf("") }
    var salary by remember { mutableStateOf(0) }
    var totalSalary by remember { mutableStateOf(0) }
    var number by remember { mutableStateOf(1) }
    var pressed by remember { mutableStateOf(false) }
    var numberInserted by remember { mutableStateOf(false) }
    var isReadOnly1 by remember { mutableStateOf(false) }
    var isReadOnly2 by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.weight(0.2f)
        ) {
            Header(numberProject = 41)
        }
        Column(
            modifier = Modifier.weight(0.6f),
            verticalArrangement = Arrangement.Center
        ) {

            Spacer(modifier = Modifier.size(100.dp, 20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = numberStr,
                    onValueChange = {
                        numberStr = it
                    },
                    label = {
                        Text(text = "Hoy many numbers will you enter?")
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            numberInserted = !numberInserted
                            number = numberStr.toInt()
                            isReadOnly1 = true
                        }
                    ),
                    readOnly = isReadOnly1,
                    singleLine = true,
                    modifier = Modifier
                        .weight(0.8f)
                        .height(60.dp),
                    shape = RoundedCornerShape(10.dp),
                    trailingIcon = {
                        IconButton(onClick = {
                            numberInserted = !numberInserted
                            numberStr = ""
                            counter = 0
                            par = 0
                            impar = 0
                            number = 1
                            salary = 0
                            result = ""
                            isReadOnly1 = false
                        }) {
                            Icon(imageVector = Icons.Default.Clear, contentDescription = "Clear")

                        }
                    }
                )

            }
            Row() {
                if (numberInserted) {
                    OutlinedTextField(
                        value = inputValue,
                        onValueChange = {
                            inputValue = it
                        },
                        label = {
                            Text(text = "Insert a number")
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                var num = inputValue.toInt()
                                if (counter < number) {
                                    if (num % 2 == 0) {
                                        par++
                                    } else {
                                        impar++
                                    }
                                    counter++
                                    inputValue = ""
                                } else {
                                    inputValue = "You have already insert $number numbers"
                                    isReadOnly2 = true

                                }

                            }
                        ),
                        readOnly = isReadOnly2,
                        singleLine = true,
                        modifier = Modifier
                            .weight(0.8f)
                            .height(60.dp),
                        shape = RoundedCornerShape(10.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.size(10.dp))
            Row() {
                if (counter == number) {
                    Spacer(modifier = Modifier.size(10.dp))
                    Button(
                        onClick = {
                            if (!pressed) {
                                result = "Par: $par\nImpar: $impar"
                            } else {
                                result = ""
                                counter = 0
                                par = 0
                                impar = 0
                                numberStr = ""
                                numberInserted = !numberInserted
                                isReadOnly1 = false
                            }
                            pressed = !pressed
                        },
                        modifier = Modifier
                            .width(100.dp)
                            .height(40.dp)
                            .weight(0.2f),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Purple40
                        )
                    ) {
                        Icon(
                            imageVector = if (!pressed) Icons.Default.Check else Icons.Default.Refresh,
                            contentDescription = if (!pressed) "Check" else "Close",
                            tint = Color.White
                        )
                    }
                }
            }
            Row() {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Spacer(modifier = Modifier.size(0.dp, 60.dp))
                    Text(
                        text = result,
                        color =
                        when {
                            result.contains("Please") -> Color.Red
                            else -> Color.Black
                        },
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Row() {
                Spacer(modifier = Modifier
                    .weight(0.3f)
                    .size(0.dp, 100.dp))

                Spacer(modifier = Modifier.weight(0.3f))
            }
        }
        Column(
            modifier = Modifier.weight(0.2f),
            verticalArrangement = Arrangement.Bottom
        ) {
            Footer(navController, numberProject = 41)
        }
    }
}