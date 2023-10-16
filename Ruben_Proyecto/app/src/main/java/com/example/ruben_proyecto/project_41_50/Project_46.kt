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
import androidx.compose.material.icons.filled.Clear
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ruben_proyecto.header_footer.Footer
import com.example.ruben_proyecto.header_footer.Header

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Project_46(navController: NavController) {
    var inputStr by remember { mutableStateOf("") }
    var input by remember { mutableStateOf(0) }
    var salary by remember { mutableStateOf(0) }
    var result1 by remember { mutableStateOf("") }
    var result2 by remember { mutableStateOf("") }
    var accStr by remember { mutableStateOf("") }
    var acc by remember { mutableStateOf(1) }
    var accInserted by remember { mutableStateOf(false) }
    var stop by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.weight(0.2f)
        ) {
            Header(numberProject = 46)
        }
        Column(
            modifier = Modifier.weight(0.6f),
            verticalArrangement = Arrangement.Center
        ) {

            Spacer(modifier = Modifier.size(100.dp, 20.dp))
            if (!stop) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        value = accStr,
                        onValueChange = {
                            accStr = it
                        },
                        label = {
                            Text(text = "Insert account number:")
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                if (!accStr.contains("-")) {
                                    acc = accStr.toInt()
                                } else {
                                    result1 = "Salary: $salary €"
                                    if (salary == 0) {
                                        result1  += "\nBalance Account: Null"
                                    } else {
                                        if (salary > 0 ){
                                            result1 += "\nBalance Account: Creditor"
                                        } else {
                                            result1 += "\nBalance Account: Debtor"
                                        }
                                    }
                                    result2 = ""
                                    stop = true
                                }
                                accInserted = !accInserted

                            }
                        ),
                        singleLine = true,
                        modifier = Modifier
                            .weight(0.8f)
                            .height(60.dp),
                        shape = RoundedCornerShape(10.dp),
                        trailingIcon = {
                            IconButton(onClick = {
                                accInserted = !accInserted
                                accStr = ""
                                acc = 1
                                result1 = ""
                                result2 = ""
                            }) {
                                Icon(imageVector = Icons.Default.Clear, contentDescription = "Clear")

                            }
                        }
                    )

                }
                Row() {
                    if (accInserted) {
                        OutlinedTextField(
                            value = inputStr,
                            onValueChange = {
                                inputStr = it
                            },
                            label = {
                                Text(text = "Insert a import (€)")
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number
                            ),
                            keyboardActions = KeyboardActions(
                                onDone = {
                                    input = inputStr.toInt()

                                    salary += input
                                    if (input > 0) {
                                        result2 = "Creditor"
                                    } else {
                                        result2 = "Debtor"
                                        if (input == 0) {
                                            result2 = "Null"
                                        }
                                    }
                                    inputStr = ""
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
            }

            Spacer(modifier = Modifier.size(10.dp))
            Row() {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Spacer(modifier = Modifier.width(60.dp))
                    Text(
                            text = result2,
                    fontWeight = FontWeight.Bold
                    )

                }
            }
            Row() {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Spacer(modifier = Modifier.weight(0.3f))
                    Text(
                        text = result1,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.weight(0.3f))

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
            Footer(navController, numberProject = 46)
        }
    }
}