package com.example.ruben_proyecto.project_41_50

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ruben_proyecto.header_footer.Footer
import com.example.ruben_proyecto.header_footer.Header

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Project_45(navController: NavController) {

    var inputStr by remember { mutableStateOf("") }
    var input by remember { mutableStateOf(0) }
    var counter1 by remember { mutableStateOf(0) }
    var counter2 by remember { mutableStateOf(0) }
    var counter3 by remember { mutableStateOf(0) }
    var sumatory by remember { mutableStateOf(0) }
    var average by remember { mutableStateOf(0.0) }
    var result by remember { mutableStateOf("") }
    var stop by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.weight(0.2f)
        ) {
            Header(numberProject = 45)
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
                if (!stop) {
                    OutlinedTextField(
                        value = inputStr,
                        onValueChange = {
                            inputStr = it
                        },
                        label = {
                            Text(text = "Insert a number (9999 to finish) :")
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                input = inputStr.toInt()
                                if (inputStr != "9999") {
                                    sumatory += input
                                    inputStr = ""
                                } else {
                                    result = "Sumatory: $sumatory"
                                    if (sumatory == 0) {
                                         result  += "\nValue is zero"
                                    } else {
                                        if (sumatory > 0 ){
                                            result += "\nValue is positve"
                                        } else {
                                            result += "\nValue is negative"
                                        }
                                    }
                                    stop = true
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


            Spacer(modifier = Modifier.size(100.dp, 20.dp))
            Row() {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = result,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
        Column(
            modifier = Modifier.weight(0.2f),
            verticalArrangement = Arrangement.Bottom
        ) {
            Footer(navController, numberProject = 45)
        }


    }

}

