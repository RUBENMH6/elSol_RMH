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
fun Project_57(navController: NavController) {
    var pointsStr by remember { mutableStateOf("") }
    var points by remember { mutableStateOf(0) }
    var counter1 by remember { mutableStateOf(0) }
    var counter2 by remember { mutableStateOf(0) }
    var counter3 by remember { mutableStateOf(0) }
    var counter4 by remember { mutableStateOf(0) }
    var xCounter by remember { mutableStateOf(0) }
    var yCounter by remember { mutableStateOf(0) }
    var xyList = remember { mutableStateListOf<Int>() }
    var xyStr by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    var isReadOnly1 by remember { mutableStateOf(false) }
    var isReadOnly2 by remember { mutableStateOf(false) }
    var pointsInserted by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.weight(0.2f)
        ) {
            Header(numberProject = 57)
        }
        Column(
            modifier = Modifier.weight(0.6f),
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = pointsStr,
                onValueChange = {
                    pointsStr = it
                },
                label = {
                    Text(text = "Hoy many points will you enter?")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        pointsInserted = !pointsInserted
                        points = pointsStr.toInt()
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


            if (pointsInserted) {
                OutlinedTextField(
                    value = xyStr,
                    onValueChange = {
                        xyStr = it
                    },
                    label = {
                        if (xyList.size % 2 != 0) {
                            Text(text = "Insert a x value: ($xCounter/$points)")
                        } else {
                            Text(text = "Insert a y value: ($yCounter/$points)")
                        }

                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            val p = points * 2
                            if (xyList.size % 2 == 0) {
                                xCounter++
                            } else {
                                yCounter++
                            }
                            xyList.add(xyStr.toInt())
                            if (xyList.size == p) {
                                for (i in 1 until xyList.size step 2) {
                                    if (xyList[i - 1] > 0 && xyList[i] > 0) {
                                        counter1++
                                    } else if (xyList[i - 1] < 0 && xyList[i] > 0) {
                                        counter2++
                                    } else if (xyList[i - 1] < 0 && xyList[i] < 0) {
                                        counter3++
                                    } else if (xyList[i - 1] > 0 && xyList[i] < 0) {
                                        counter4++
                                    }
                                }
                                result += "First quadrant: $counter1\nSecond quadrant: $counter2\nThird quadrant: $counter3\nFourth quadrant: $counter4"
                            }
                            xyStr = ""
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
            Footer(navController, numberProject = 57)
        }
    }
}




