package com.example.ruben_proyecto.project_51_60


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ruben_proyecto.header_footer.Footer
import com.example.ruben_proyecto.header_footer.Header


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Project_56(navController: NavController) {
    var triangleStr by remember { mutableStateOf("") }
    var inputStr by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    var triangles by remember { mutableStateOf(0) }
    val sidesList = remember { mutableStateListOf<Int>() }
    var counter by remember { mutableStateOf(0) }
    var c by remember { mutableStateOf(0) }
    var cant1 by remember { mutableStateOf(0) }
    var cant2 by remember { mutableStateOf(0) }
    var cant3 by remember { mutableStateOf(0) }
    var triangleInserted by remember { mutableStateOf(false) }
    var isReadOnly1 by remember { mutableStateOf(false) }
    var isReadOnly2 by remember { mutableStateOf(false) }
    var start by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.weight(0.2f)
        ) {
            Header(numberProject = 56)
        }
        Column(
            modifier = Modifier.weight(0.6f),
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = triangleStr,
                onValueChange = {
                    triangleStr = it
                },
                label = {
                    Text(text = "Hoy many triangles will you enter?")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        triangleInserted = !triangleInserted
                        triangles = triangleStr.toInt()
                        isReadOnly1 = true
                    }
                ),
                readOnly = isReadOnly1,
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RoundedCornerShape(10.dp),
                trailingIcon = {
                    IconButton(onClick = {

                    }) {
                        Icon(imageVector = Icons.Default.Clear, contentDescription = "Clear")
                    }
                }
            )
            if (triangleInserted) {
                OutlinedTextField(
                    value = inputStr,
                    onValueChange = {
                        inputStr = it
                    },
                    label = {
                        Text(text = "Insert a height value: ($counter/3)")
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            sidesList.add(inputStr.toInt())
                            counter++
                            if (counter == 3) {
                                counter = 0
                                c++
                                if (c == triangles) {
                                    isReadOnly2 = true
                                    for (i in 0.. sidesList.size step 3) {
                                        if (i < sidesList.size -2) {
                                            if (sidesList[i] == sidesList[i + 1] && sidesList[i] == sidesList[i + 2]) {
                                                cant1++
                                            } else {
                                                if (sidesList[i] == sidesList[i + 1] || sidesList[i] == sidesList[i + 2] || sidesList[i + 1] == sidesList[i + 2]) {
                                                    cant2++
                                                } else {
                                                    cant3++
                                                }
                                            }
                                        }

                                    }
                                    result = "Equilateral: $cant1\n Isosceles: $cant2\n Scalene: $cant3"
                                }
                            }
                            inputStr = ""
                        }
                    ),
                    readOnly = isReadOnly2,
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    shape = RoundedCornerShape(10.dp)
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row() {
                Spacer(modifier = Modifier.weight(0.3f))
                Text(
                    text = result,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.weight(0.3f))
            }

        }
        Column(
            modifier = Modifier.weight(0.2f),
            verticalArrangement = Arrangement.Bottom
        ) {
            Footer(navController, numberProject = 56)
        }
    }
}