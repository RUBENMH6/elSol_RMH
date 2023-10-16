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
fun Project_65(navController: NavController) {
    var triangleStr by remember { mutableStateOf("") }
    var sidesStr by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    var triangles by remember { mutableStateOf(0) }
    val sidesList = remember { mutableStateListOf<Int>() }
    var counter by remember { mutableStateOf(0) }
    var cant1 by remember { mutableStateOf(0) }
    var cant2 by remember { mutableStateOf(0) }
    var cant3 by remember { mutableStateOf(0) }
    var triangleInserted by remember { mutableStateOf(false) }
    var isReadOnly1 by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.weight(0.2f)
        ) {
            Header(numberProject = 65)
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
                    value = sidesStr,
                    onValueChange = {
                        sidesStr = it
                    },
                    label =  {
                        when (sidesList.size) {
                            0 -> Text(text = "Insert a first side:")
                            1 -> Text(text = "Insert a second side:")
                            2 -> Text(text = "Insert a third side:")
                        }
                    } ,
                    placeholder = {
                        if(counter != triangles) {
                            (Text(text = "($counter/$triangles)"))
                        } else {
                            (Text(text = "Done ($counter/$triangles)"))
                        }
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            if (counter < triangles){
                                if (sidesList.size < 3) {
                                    sidesList.add(sidesStr.toInt())
                                    sidesStr = ""
                                    result = ""
                                    if (sidesList.size == 3) {
                                        when  {
                                            sidesList[0] == sidesList[1] && sidesList[0] == sidesList[2] -> cant1++
                                            sidesList[0] == sidesList[1] || sidesList[0] == sidesList[2] || sidesList[1] == sidesList[2] -> cant2++
                                            else -> cant3++
                                        }
                                        sidesList.clear()
                                        counter++
                                    }
                                }

                                if (counter == triangles) {
                                    result = "Equilateral: $cant1\nIsosceles: $cant2\nScalene: $cant3"
                                }
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
                            sidesStr = ""
                            counter = 0
                            cant1 = 0
                            cant2 = 0
                            cant3 = 0
                            sidesList.clear()
                        }) {
                            Icon(
                                imageVector =
                                if (counter == triangles) {
                                    Icons.Default.Refresh
                                } else {
                                    Icons.Default.Clear
                                },
                                contentDescription = "Clear"
                            )
                        }
                    }
                )
            }

            Item_Result_Middle(result)
        }
        Column(
            modifier = Modifier.weight(0.2f),
            verticalArrangement = Arrangement.Bottom
        ) {
            Footer(navController, numberProject = 65 )
        }
    }
}