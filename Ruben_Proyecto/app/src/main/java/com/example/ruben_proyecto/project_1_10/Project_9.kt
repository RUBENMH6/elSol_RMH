package com.example.ruben_proyecto.project_1_10


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ruben_proyecto.header_footer.Footer
import com.example.ruben_proyecto.header_footer.Header
import com.example.ruben_proyecto.ui.theme.Purple40


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Project_9(navController: NavController) {
    var number1 by remember { mutableStateOf("") }
    var number2 by remember { mutableStateOf("") }
    var number3 by remember { mutableStateOf("") }
    var number4 by remember { mutableStateOf("") }
    var resultSum by remember { mutableStateOf("") }
    var resultMul by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        ) {
        Column(
            modifier = Modifier.weight(0.2f)
        ) {
           Header(numberProject = 9)
        }
        Column(
            modifier = Modifier.weight(0.6f),
            verticalArrangement = Arrangement.Bottom
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Row(modifier = Modifier.weight(2f)) {
                    OutlinedTextField(
                        value = number1,
                        onValueChange = { newValue -> number1 = newValue },
                        label = { Text("Insert a number") },
                        modifier = Modifier.padding(10.dp)
                    )
                }
                Row(modifier = Modifier.weight(2f)) {
                    OutlinedTextField(
                        value = number2,
                        onValueChange = { newValue -> number2 = newValue },
                        label = { Text("Insert a number") },
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                Row(modifier = Modifier.weight(2f)) {
                    OutlinedTextField(
                        value = number3,
                        onValueChange = { newValue -> number3 = newValue },
                        label = { Text("Insert a number") },
                        modifier = Modifier.padding(10.dp)
                    )
                }
                Row(modifier = Modifier.weight(2f)) {
                    OutlinedTextField(
                        value = number4,
                        onValueChange = { newValue -> number4 = newValue },
                        label = { Text("Insert a number") },
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
            Row(
                modifier = Modifier.padding(16.dp),

                ) {
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = {
                        val num1 = number1.toIntOrNull() ?: 0
                        val num2 = number2.toIntOrNull() ?: 0
                        val num3 = number3.toIntOrNull() ?: 0
                        val num4 = number4.toIntOrNull() ?: 0
                        val sum = num1 + num2 + num3 + num4
                        val sumDouble = sum.toDouble()
                        val average = sumDouble / 4

                        resultSum = sum.toString()
                        resultMul = average.toString()


                    },
                    modifier = Modifier
                        .width(200.dp)
                        .height(40.dp)
                        .weight(3f)
                        .background(color = Purple40, shape = RoundedCornerShape(10.dp)),

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Purple40
                    )
                ) {
                    Text(text = "Calculate")
                }
                Spacer(modifier = Modifier.weight(1f))
            }
            Row() {
                Row() {
                    Text(
                        text = "Sum: "
                    )
                }
                Row(
                    modifier = Modifier.weight(1f)
                ) {
                }
                Row(
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = "$resultSum",
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Row() {
                Row() {
                    Text(
                        text = "Average: "
                    )
                }
                Row(
                    modifier = Modifier.weight(1f)
                ) {
                }
                Row(
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = "$resultMul",
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
        Column(
            modifier = Modifier.weight(0.2f),
            verticalArrangement = Arrangement.Bottom
        ) {
            Footer(navController, 9)
        }
    }
}

