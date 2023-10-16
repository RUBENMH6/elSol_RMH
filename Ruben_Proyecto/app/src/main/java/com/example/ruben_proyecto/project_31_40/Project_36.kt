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
fun Project_36 (navController: NavController) {
    var inputValue by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    var counter by remember { mutableStateOf(0) }
    var sizesStr by remember { mutableStateOf("") }
    var sizes by remember { mutableStateOf(1) }
    var totalHeight by remember { mutableStateOf(0.0) }
    var pressed by remember { mutableStateOf(false) }
    var sizeInserted by remember { mutableStateOf(false) }
    var isReadOnly by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.weight(0.2f)
        ) {
            Header(numberProject = 36)
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
                    value = sizesStr,
                    onValueChange = {
                        sizesStr = it
                    },
                    label = {
                        Text(text = "How many people? ")
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            sizeInserted = !sizeInserted
                            sizes = sizesStr.toInt()
                            isReadOnly = true
                        }
                    ),
                    readOnly = isReadOnly,
                    singleLine = true,
                    modifier = Modifier
                        .weight(1f)
                        .height(60.dp),
                    shape = RoundedCornerShape(10.dp),
                    trailingIcon = {
                        IconButton(onClick = {
                            sizeInserted = !sizeInserted
                            sizesStr = ""
                            counter = 0
                            sizes = 1
                            result = ""
                            isReadOnly = false
                        }) {
                            Icon(imageVector = Icons.Default.Clear, contentDescription = "Clear")

                        }
                    }
                )
            }
            Row() {
                if (sizeInserted) {
                    OutlinedTextField(
                        value = inputValue,
                        onValueChange = {
                            inputValue = it
                        },
                        label = {
                            Text(text = "Insert a height ($counter/$sizes)")
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                var height = inputValue.toDouble()
                                if (height > 0) {
                                    if (counter < sizes) {

                                        totalHeight += height
                                        counter++
                                        inputValue = ""
                                    } else {
                                        inputValue = "You have already insert $sizes height"
                                    }
                                } else {
                                    result = "Please. Enter a positive height."
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
                Spacer(modifier = Modifier.weight(0.3f))
                if (counter == sizes) {
                    Button(
                        onClick = {
                            if (!pressed) {
                                var average = totalHeight / counter
                                result =
                                    "People: $counter\nAverage: $average"
                            } else {
                                result = ""
                                counter = 0
                                sizesStr = ""
                                sizeInserted = !sizeInserted
                                isReadOnly = false
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
        }
        Column(
            modifier = Modifier.weight(0.2f),
            verticalArrangement = Arrangement.Bottom
        ) {
            Footer(navController, numberProject = 36 )
        }
    }
}