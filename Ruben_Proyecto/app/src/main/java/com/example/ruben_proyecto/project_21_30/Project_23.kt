package com.example.ruben_proyecto.project_21_30


import androidx.compose.foundation.background
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
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
fun Project_23(navController: NavController) {
    var number1Str by rememberSaveable { mutableStateOf("") }
    var number2Str by rememberSaveable { mutableStateOf("") }
    var number3Str by rememberSaveable { mutableStateOf("") }
    var result by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.weight(0.2f)
        ) {
            Header(numberProject = 23)
        }
        Column(
            modifier = Modifier.weight(0.6f),
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = number1Str,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { newValue -> number1Str = newValue },
                label = {
                    Text("Insert a number")
                }
            )
            Spacer(modifier = Modifier.size(100.dp, 20.dp))
            OutlinedTextField(
                value = number2Str,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { newValue -> number2Str = newValue },
                label = { Text("Insert a number") }
            )
            Spacer(modifier = Modifier.size(100.dp, 20.dp))
            OutlinedTextField(
                value = number3Str,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { newValue -> number3Str = newValue },
                label = { Text("Insert a number") }
            )
            Spacer(modifier = Modifier.size(100.dp, 20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = {
                        val num1 = number1Str.toInt()
                        val num2 = number2Str.toInt()
                        val num3 = number3Str.toInt()

                        if (num1 > num2 && num1 > num3) {
                            result = "$num1"
                        } else {
                            if (num2 > num3) {
                                result = "$num2"
                            } else {
                                result = "$num3"
                            }
                        }
                    },
                    modifier = Modifier
                        .width(200.dp)
                        .height(40.dp)
                        .weight(3f)
                        .background(color = Purple40, shape = RoundedCornerShape(10.dp)),

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Purple40
                    )
                )
                {
                    Text("Calculate")
                }
                Spacer(modifier = Modifier.weight(1f))

            }
            Spacer(modifier = Modifier.size(100.dp, 20.dp))
            Row() {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {

                    Text(
                        text = "$result",
                        fontWeight = FontWeight.Bold
                    )
                }

            }

        }
        Column(
            modifier = Modifier.weight(0.2f),
            verticalArrangement = Arrangement.Bottom
        ) {
            Footer(navController, numberProject = 23 )
        }


    }
}