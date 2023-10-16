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
fun Project_22(navController: NavController) {
    var askExam by remember { mutableStateOf("") }
    var answerExam by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.weight(0.2f)
        ) {
            Header(numberProject = 22)
        }
        Column(
            modifier = Modifier.weight(0.6f),
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = askExam,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { newValue -> askExam = newValue },
                label = {
                    Text("Enter a number of ask to exam")
                }
            )
            Spacer(modifier = Modifier.size(100.dp, 20.dp))
            OutlinedTextField(
                value = answerExam,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { newValue -> answerExam = newValue },
                label = { Text("Enter a number of correct answer to exam") }
            )
            Spacer(modifier = Modifier.size(100.dp, 20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = {
                        val ask = askExam.toInt()
                        val answer = answerExam.toInt()
                        val average = (answer.toDouble() / ask.toDouble()) * 100

                        result = when {
                            average > 100 -> "Out of level"
                            average >= 90 -> "Max level"
                            average >= 75 -> "Medium level"
                            average >= 50 -> "Regular level"
                            else -> "Out of level"
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
            Footer(navController, numberProject = 22 )
        }


    }
}