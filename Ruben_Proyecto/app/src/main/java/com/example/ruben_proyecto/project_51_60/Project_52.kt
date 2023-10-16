package com.example.ruben_proyecto.project_51_60

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
import androidx.compose.runtime.mutableStateListOf
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
fun Project_52(navController: NavController) {
    var triangleStr by remember { mutableStateOf("")}
    var triangle by remember { mutableStateOf(0)}
    var base by remember { mutableStateOf(0.0)}
    var height by remember { mutableStateOf(0.0)}
    var counter12 by remember { mutableStateOf(0)}
    var inputStr by remember { mutableStateOf("")}
    var result by remember { mutableStateOf("")}
    var baseCounter by remember { mutableStateOf(0)}
    var heightCounter by remember { mutableStateOf(0)}
    var triangleInserted by remember { mutableStateOf(false)}
    var baseInserted by remember { mutableStateOf(false)}
    var isReadOnly1 by remember { mutableStateOf(false)}
    var isReadOnly2 by remember { mutableStateOf(false)}
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.weight(0.2f)
        ) {
            Header(numberProject = 52)
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
                        triangle = triangleStr.toInt()
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
                        triangleInserted = !triangleInserted
                        triangleStr = ""
                        isReadOnly1 = false
                        baseCounter = 0
                        heightCounter = 0
                        baseInserted = false
                        counter12 = 0
                        result = ""
                        inputStr = ""
                        isReadOnly2 = false
                    }) {
                        Icon(imageVector = Icons.Default.Clear, contentDescription = "Clear")
                    }
                }
            )
            Row() {
                if (triangleInserted) {
                    OutlinedTextField(
                        value = inputStr,
                        onValueChange = {
                            inputStr = it
                        },
                        label = {
                            if (!baseInserted) {
                                Text(text = "Insert a base value: ($baseCounter/$triangle)")
                            } else {
                                Text(text = "Insert a height value: ($heightCounter/$triangle)")
                            }
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                var input = inputStr.toDouble()
                                if (!baseInserted) {
                                    if (baseCounter < triangle) {
                                        base = input
                                        baseCounter++
                                        inputStr = ""
                                        baseInserted = !baseInserted
                                    } else {
                                        inputStr = "You have already insert $baseCounter numbers."
                                        isReadOnly2 = true
                                    }
                                } else {
                                    if (heightCounter <= triangle) {
                                        height = input
                                        heightCounter++
                                        inputStr = ""
                                        baseInserted = !baseInserted
                                        val s = (base * height) / 2
                                        if (s > 12) {
                                            counter12++
                                        }
                                        result = "Base: $base\nHeight: $height\nSuperfice: $s"

                                        if (baseCounter == triangle && heightCounter == triangle) {
                                            result += "\nMore than 12: $counter12"
                                        }
                                    } else {
                                        inputStr = "You have already insert $heightCounter numbers."
                                        isReadOnly2 = true
                                    }
                                }

                            }
                        ),
                        readOnly = isReadOnly2,
                        singleLine = true,
                        modifier = Modifier
                            .weight(0.8f)
                            .height(60.dp),
                        shape = RoundedCornerShape(10.dp)
                    )
                }
            }
            Row() {
                Spacer(modifier = Modifier.weight(0.7f))
                Text(
                    text = result,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Column(
            modifier = Modifier.weight(0.2f),
            verticalArrangement = Arrangement.Bottom
        ) {
            Footer(navController, numberProject = 52 )
        }
    }
}