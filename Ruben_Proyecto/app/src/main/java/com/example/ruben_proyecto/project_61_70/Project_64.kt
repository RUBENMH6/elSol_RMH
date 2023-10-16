package com.example.ruben_proyecto.project_61_70

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
fun Project_64(navController: NavController) {
    var inputStr by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    var sum by remember { mutableStateOf(0) }
    var counter by remember { mutableStateOf(0) }
    var inputList = remember { mutableStateListOf<Int>() }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.weight(0.2f)
        ) {
            Header(numberProject = 64)
        }
        Column(
            modifier = Modifier.weight(0.6f),
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = inputStr,
                onValueChange = {
                    inputStr = it
                },
                label =  { Text(text = "Insert a number(${inputList.size}/3):") } ,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                placeholder = {
                    if(counter != 5) {
                        (Text(text = "($counter/5)"))
                    } else {
                        (Text(text = "Done ($counter/5)"))
                    }
                              },
                keyboardActions = KeyboardActions(
                    onDone = {
                        if (counter < 5) {
                            if (inputList.size < 3) {
                                inputList.add(inputStr.toInt())
                                inputStr = ""
                                if (inputList.size == 3) {
                                    sum += when {
                                        inputList[0] > inputList[1] && inputList[0] > inputList[2] -> inputList[0]
                                        inputList[1] > inputList[2] -> inputList[1]
                                        else -> inputList[2]
                                    }
                                    inputList.clear()
                                    counter++
                                }
                            }
                            if (counter == 5) {
                                result = "The accumulated value is: $sum"
                            }
                        } else {
                            inputStr = "You have already insert 3 number 5 times."
                        }

                    }
                ),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RoundedCornerShape(10.dp),
                trailingIcon = {
                    IconButton(onClick = {
                        result = ""
                        counter = 0
                        inputStr = ""
                        sum = 0
                        inputList.clear()
                    }) {
                        Icon(
                            imageVector =
                            if (counter == 5) {
                                Icons.Default.Refresh
                            } else {
                                Icons.Default.Clear
                            },
                            contentDescription = "Clear"
                        )
                    }
                }
            )
            Item_Result_Middle(result)
        }
        Column(
            modifier = Modifier.weight(0.2f),
            verticalArrangement = Arrangement.Bottom
        ) {
            Footer(navController, numberProject = 64 )
        }
    }
}