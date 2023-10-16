package com.example.ruben_proyecto.project_31_40

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
fun Project_37(navController: NavController) {
    var inputValue by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    var counter by remember { mutableStateOf(0) }
    var counter101 by remember { mutableStateOf(0) }
    var counter301 by remember { mutableStateOf(0) }
    var peopleStr by remember { mutableStateOf("") }
    var salary by remember { mutableStateOf(0) }
    var totalSalary by remember { mutableStateOf(0) }
    var people by remember { mutableStateOf(1) }
    var pressed by remember { mutableStateOf(false) }
    var peopleInserted by remember { mutableStateOf(false) }
    var isReadOnly by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.weight(0.2f)
        ) {
            Header(numberProject = 37)
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
                    value = peopleStr,
                    onValueChange = {
                        peopleStr = it
                    },
                    label = {
                        Text(text = "Hoy many people works in company?")
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            peopleInserted = !peopleInserted
                            people = peopleStr.toInt()
                            isReadOnly = true
                        }
                    ),
                    readOnly = isReadOnly,
                    singleLine = true,
                    modifier = Modifier
                        .weight(0.8f)
                        .height(60.dp),
                    shape = RoundedCornerShape(10.dp),
                    trailingIcon = {
                        IconButton(onClick = {
                            peopleInserted = !peopleInserted
                            peopleStr = ""
                            counter = 0
                            people = 1
                            salary = 0
                            result = ""
                            isReadOnly = false
                        }) {
                            Icon(imageVector = Icons.Default.Clear, contentDescription = "Clear")

                        }
                    }
                )
                if (counter == people) {
                    Spacer(modifier = Modifier.size(10.dp))
                    Button(
                        onClick = {
                            if (!pressed) {
                                var average = totalSalary / counter
                                result = "Number of workers: $people\nSalary average: $average $\nTotal expenses: $totalSalary $"
                            } else {
                                result = ""
                                counter = 0
                                peopleStr = ""
                                peopleInserted = !peopleInserted
                                isReadOnly = false
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
                if (peopleInserted) {
                    OutlinedTextField(
                        value = inputValue,
                        onValueChange = {
                            inputValue = it
                        },
                        label = {
                            Text(text = "Insert a salary ($)")
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                salary = inputValue.toInt()
                                if (salary >= 100 && salary <= 500) {
                                    if (counter < people) {
                                        if (salary <= 300) {
                                            counter101++
                                        } else {
                                            counter301++
                                        }
                                        totalSalary += salary
                                        counter++
                                        inputValue = ""
                                    } else {
                                        inputValue = "You have already insert $people salaries"
                                    }
                                } else {
                                    result = "Please. Enter a salary in range."
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
                Spacer(modifier = Modifier.weight(0.3f).size(0.dp, 100.dp))

                Spacer(modifier = Modifier.weight(0.3f))
            }
        }
        Column(
            modifier = Modifier.weight(0.2f),
            verticalArrangement = Arrangement.Bottom
        ) {
            Footer(navController, numberProject = 37 )
        }
    }
}