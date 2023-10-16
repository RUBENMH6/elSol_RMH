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
fun Project_7(navController: NavController) {
    var priceStr by remember { mutableStateOf("") }
    var quantityStr by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Header(numberProject = 7)
        }
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = priceStr,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { newValue -> priceStr = newValue },
                label = { Text("Insert a price (€) ") },

                )

            OutlinedTextField(
                value = quantityStr,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { newValue -> quantityStr = newValue },
                label = { Text("Insert a quantity") },

                )
            Row(
                modifier = Modifier.padding(16.dp),

                ) {
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = {
                        val num1 = priceStr.toIntOrNull() ?: 0
                        val num2 = quantityStr.toIntOrNull() ?: 0
                        val value = num1 * num2

                        result = "${value.toString()} €"

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

                Row(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Total price: "
                    )
                }
                Row(
                    modifier = Modifier.weight(1f)
                ) {
                    Spacer(modifier = Modifier.size(100.dp))
                }
                Row(
                    modifier = Modifier.weight(1f),
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
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Bottom
        ) {
            Footer(navController, 7)
        }
    }

}

