package com.example.ruben_proyecto.project_51_60

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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ruben_proyecto.header_footer.Footer
import com.example.ruben_proyecto.header_footer.Header
import com.example.ruben_proyecto.ui.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Project_55(navController: NavController) {
    var result by remember { mutableStateOf("") }
    var inputStr by remember { mutableStateOf("") }
    var input by remember { mutableStateOf(0) }
    var pressed by remember { mutableStateOf(true) }
    var inputInserted by remember { mutableStateOf(true) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.weight(0.2f)
        ) {
            Header(numberProject = 55)
        }
        Column(
            modifier = Modifier.weight(0.6f),
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.size(100.dp, 20.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                if (inputInserted)  {
                    OutlinedTextField(
                        value = inputStr,
                        onValueChange = {
                            inputStr = it
                        },
                        label = {
                            Text(text = "Enter a number for the multiplication table.")
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                pressed = !pressed
                                input = inputStr.toInt()
                                inputInserted = !inputInserted
                            }
                        ),
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp),
                        shape = RoundedCornerShape(10.dp),
                        trailingIcon = {
                            IconButton(onClick = {
                                pressed = true
                                input = 0
                                result = ""
                                inputStr = ""
                                inputInserted = true
                            }) {
                                Icon(imageVector = Icons.Default.Clear, contentDescription = "Clear")
                            }
                        }
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.weight(1f))
                if (!pressed) {
                    Button(
                        onClick = {
                            pressed = !pressed
                            for (i in 1 .. 12) {
                                val num = i * input
                                result += "$i x $input = $num\n"
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
                        Text("Show table of $input")

                    }
                }
                Spacer(modifier = Modifier.weight(1f))
            }
            Spacer(modifier = Modifier.size(100.dp, 20.dp))
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
            Footer(navController, numberProject = 55 )
        }
    }
}