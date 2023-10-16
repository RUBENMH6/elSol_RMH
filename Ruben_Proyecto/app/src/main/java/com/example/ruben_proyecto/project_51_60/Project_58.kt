package com.example.ruben_proyecto.project_51_60

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ruben_proyecto.header_footer.Footer
import com.example.ruben_proyecto.header_footer.Header
import com.example.ruben_proyecto.items.Item_Result_Middle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Project_58(navController: NavController) {
    var numberStr by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    var positive by remember { mutableStateOf(0) }
    var negative by remember { mutableStateOf(0) }
    var mult15 by remember { mutableStateOf(0) }
    var mult2 by remember { mutableStateOf(0) }
    var isOnlyRead by remember { mutableStateOf(false) }
    var numberList = remember { mutableStateListOf<Int>() }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.weight(0.2f)
        ) {
            Header(numberProject = 58)
        }
        Column(
            modifier = Modifier.weight(0.6f),
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = numberStr,
                onValueChange = {
                    numberStr = it
                },
                label = {
                    Text(text = "Insert a number (${numberList.size}/10)")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        if (numberList.size < 10) {
                            val number = numberStr.toInt()
                            numberList.add(number)
                            numberStr = ""
                            if (numberList.size == 10) {
                                for (i in 0 .. numberList.size - 1) {
                                    if (numberList[i] >= 0) {
                                        positive++
                                    } else {
                                        negative++
                                    }
                                    if (numberList[i] % 15 == 0) {
                                        mult15++
                                    }
                                    if (numberList[i] % 2 == 0) {
                                        mult2++
                                    }
                                }
                                isOnlyRead = true
                                result = "Positive: $positive\nNegative: $negative\nMultiples of 15: $mult15\nMultiples of 2: $mult2"
                            }
                        }

                    }
                ),
                readOnly = isOnlyRead,
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RoundedCornerShape(10.dp),
                trailingIcon = {
                    IconButton(onClick = {
                        positive = 0
                        negative = 0
                        mult15 = 0
                        mult2 = 0
                        result = ""
                        numberList.clear()
                        isOnlyRead = false
                    }) {
                        Icon(
                            imageVector =
                            if (numberList.size == 10) {
                                Icons.Default.Refresh
                            } else {
                                Icons.Default.Clear
                            },
                            contentDescription = "Clear")
                    }
                }
            )
            Item_Result_Middle(result)
        }
        Column(
            modifier = Modifier.weight(0.2f),
            verticalArrangement = Arrangement.Bottom
        ) {
            Footer(navController, numberProject = 58 )
        }
    }
}