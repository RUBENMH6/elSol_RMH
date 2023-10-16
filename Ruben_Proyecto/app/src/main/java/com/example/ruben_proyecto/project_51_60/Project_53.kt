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
fun Project_53(navController: NavController) {
    var inputStr by remember { mutableStateOf("")}
    var result by remember { mutableStateOf("")}
    var counter by remember { mutableStateOf(0)}
    var sumatory by remember { mutableStateOf(0)}
    var isOnlyRead by remember { mutableStateOf(false)}
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.weight(0.2f)
        ) {
            Header(numberProject = 53)
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
                label = {
                    Text(text = "Insert a 10 numbers ($counter/10):")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        val input = inputStr.toIntOrNull()
                        inputStr = ""
                        counter++
                        if (counter > 5 && counter <= 10) {
                            sumatory +=  input as Int
                        }
                        if (counter == 10) {
                            isOnlyRead = true
                            result = "Sumatory: $sumatory"
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
                    IconButton(
                        onClick = {
                            counter = 0
                            isOnlyRead = false
                            result = ""
                    }
                    ) {
                        Icon(imageVector = Icons.Default.Clear, contentDescription = "Clear")
                    }
                }
            )

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
            Footer(navController, numberProject = 53 )
        }
    }
}