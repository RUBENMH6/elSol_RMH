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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ruben_proyecto.header_footer.Footer
import com.example.ruben_proyecto.header_footer.Header
import com.example.ruben_proyecto.items.Item_Result_Middle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Project_68(navController: NavController) {
    var numberStr by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    var count by remember { mutableStateOf(0) }
    var count0 by remember { mutableStateOf(0) }
    var count1 by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.weight(0.2f)
        ) {
            Header(numberProject = 68)
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
                label = { Text(text = "Insert a number ($count/10):") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        if (count < 10) {
                            val number = numberStr.toIntOrNull()
                            when (number) {
                                0 -> count0++
                                1,5,10 -> count1++
                            }
                            count++
                            if (count == 10) {
                                result = "Numbers 0: $count0\nNumbers 1,5 or 10: $count1"
                            }
                        }
                        numberStr = ""

                    }
                ),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RoundedCornerShape(10.dp),
                trailingIcon = {
                    IconButton(onClick = {
                    }) {
                        Icon(
                            imageVector = Icons.Default.Clear,
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
            Footer(navController, numberProject = 68 )
        }
    }
}