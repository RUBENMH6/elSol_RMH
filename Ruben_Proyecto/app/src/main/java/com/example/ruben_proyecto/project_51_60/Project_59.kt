package com.example.ruben_proyecto.project_51_60

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
fun Project_59(navController: NavController) {
    var pointStr by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    var pList = remember { mutableStateListOf<Int>() }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.weight(0.2f)
        ) {
            Header(numberProject = 59)
        }
        Column(
            modifier = Modifier.weight(0.6f),
            verticalArrangement = Arrangement.Center
        ) {

            OutlinedTextField(
                value = pointStr,
                onValueChange = {
                    pointStr = it
                },
                label = {
                    if (pList.size % 2 == 0) {
                        Text(text = "Insert a x:")
                    } else {
                        Text(text = "Insert a y:")
                    }

                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        if (pList.size < 2) {
                            pList.add(pointStr.toInt())
                            pointStr = ""
                            result = ""
                            if (pList.size == 2) {
                                when {
                                    pList[0] > 0 && pList[1] > 0 -> result = "First quadrant"
                                    pList[0] < 0 && pList[1] > 0 -> result = "Second quadrant"
                                    pList[0] < 0 && pList[1] < 0 -> result = "Third quadrant"
                                    pList[0] > 0 && pList[1] < 0 -> result = "Fourth quadrant"
                                    else -> result = "The point is on the axis"
                                }
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
                        pList.clear()
                    }) {
                        Icon(
                            imageVector =
                            if (pList.size == 2) {
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
            Footer(navController, numberProject = 59)
        }
    }
}