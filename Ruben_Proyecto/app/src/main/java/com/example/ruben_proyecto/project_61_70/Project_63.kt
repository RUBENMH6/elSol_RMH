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
fun Project_63(navController: NavController) {
    var numStr by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.weight(0.2f)
        ) {
            Header(numberProject = 63)
        }
        Column(
            modifier = Modifier.weight(0.6f),
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = numStr,
                onValueChange = {
                    numStr = it
                },
                label = { Text(text = "Insert a number") }
                ,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        result = ""
                       val num = numStr.toInt()
                        numStr = ""
                        when {
                            num > 0 -> result = "Positive"
                            num < 0 -> result = "Negative"
                            else -> result = "Zero"
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
            Footer(navController, numberProject = 63 )
        }
    }
}