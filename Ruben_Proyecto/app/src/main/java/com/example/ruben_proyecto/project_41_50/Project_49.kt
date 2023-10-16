package com.example.ruben_proyecto.project_41_50

import android.annotation.SuppressLint
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ruben_proyecto.header_footer.Footer
import com.example.ruben_proyecto.header_footer.Header
import com.example.ruben_proyecto.ui.theme.Purple40


@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Project_49(navController: NavController) {

    var inputStr by remember { mutableStateOf("") }
    var input by remember { mutableStateOf(0) }
    var counter by remember { mutableStateOf(0) }
    var counter2 by remember { mutableStateOf(0) }
    var counter3 by remember { mutableStateOf(0) }
    var sumatory by remember { mutableStateOf(0) }
    var average by remember { mutableStateOf(0.0) }
    var result by remember { mutableStateOf("") }
    var stop by remember { mutableStateOf(false) }
    var readOnly by remember { mutableStateOf(false) }
    var pressed by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.weight(0.2f)
        ) {
            Header(numberProject = 49)
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
                    value = inputStr,
                    onValueChange = {
                        inputStr = it
                    },
                    label = {
                        Text(text = "Insert a grade ($counter/10) :")
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {

                            input = inputStr.toInt()
                            if (input < 0 || input > 10) {
                                result = "Error. Insert a grade in 0 - 10."
                            } else {
                                result = ""
                                counter++
                                sumatory += input
                            }
                            if (counter != 10) {
                                inputStr = ""
                            } else {
                                inputStr = "You have already insert 10 grades"
                                readOnly = true
                            }
                        }
                    ),
                    readOnly = readOnly,
                    singleLine = true,
                    modifier = Modifier
                        .weight(0.8f)
                        .height(60.dp),
                    shape = RoundedCornerShape(10.dp),
                    trailingIcon = {
                        IconButton(onClick = {
                            inputStr = ""
                            result = ""
                            readOnly = false
                            counter = 0
                            sumatory = 0
                        }) {
                            Icon(imageVector = Icons.Default.Clear, contentDescription = "Clear")

                        }
                    }

                )
            }
            Row() {
                Spacer(modifier = Modifier.height(20.dp))
            }
            Row() {
                Spacer(modifier = Modifier.weight(0.3f))
                if (counter == 10) {
                    Button(
                        onClick = {
                            if (!pressed) {
                                average = sumatory.toDouble() / counter
                                result =
                                    "Sumatory: $sumatory\nAverage: $average"
                            } else {
                                result = ""
                                counter = 0
                                inputStr = ""
                                readOnly = false
                                sumatory = 0
                            }
                            pressed = !pressed
                        },
                        modifier = Modifier
                            .width(100.dp)
                            .height(40.dp)
                            .weight(0.4f),
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
                Spacer(modifier = Modifier.weight(0.3f))
            }
            Spacer(modifier = Modifier.size(100.dp, 20.dp))
            Row() {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = result,
                        color =
                        if (result.contains("Error")) {
                            Color.Red
                        } else {
                            Color.Black
                        },
                        fontWeight =
                        if (result.contains("Error")) {
                            FontWeight.Normal
                        } else {
                            FontWeight.Bold
                        }
                    )
                }
            }
        }
        Column(
            modifier = Modifier.weight(0.2f),
            verticalArrangement = Arrangement.Bottom
        ) {
            Footer(navController, numberProject = 49)
        }
    }
}

