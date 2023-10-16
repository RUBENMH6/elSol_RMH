package com.example.ruben_proyecto.project_31_40

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
fun Project_34(navController: NavController) {
    val valuesStr = remember { mutableStateListOf<String>() }
    var inputValue by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    var counter by remember { mutableStateOf(0) }
    var piecesStr by remember { mutableStateOf("") }
    var pieces by remember { mutableStateOf(1) }
    var piecesApproved by remember { mutableStateOf(0) }
    var values by remember { mutableStateOf(0.0) }
    var pressed by remember { mutableStateOf(false) }
    var pieceInserted by remember { mutableStateOf(false) }
    var isReadOnly by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.weight(0.2f)
        ) {
            Header(numberProject = 34)
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
                OutlinedTextField(
                    value = piecesStr,
                    onValueChange = {
                        piecesStr = it
                    },
                    label = {
                        Text(text = "How many pieces are you process?")
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            pieceInserted = !pieceInserted
                            pieces = piecesStr.toInt()
                            isReadOnly = true
                        }
                    ),
                    readOnly = isReadOnly,
                    singleLine = true,
                    modifier = Modifier
                        .weight(1f)
                        .height(60.dp),
                    shape = RoundedCornerShape(10.dp),
                    trailingIcon = {
                        IconButton(onClick = {
                            pieceInserted = !pieceInserted
                            piecesStr = ""
                            counter = 0
                            pieces = 1
                            result = ""
                            isReadOnly = false
                        }) {
                            Icon(imageVector = Icons.Default.Clear, contentDescription = "Clear")

                        }
                    }
                )
            }
            Row() {
                if (pieceInserted) {
                    OutlinedTextField(
                        value = inputValue,
                        onValueChange = {
                            inputValue = it
                        },
                        label = {
                            Text(text = "Insert a measurament of piece")
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                if (counter < pieces) {
                                    var measure = inputValue.toDouble()
                                    if (measure >= 1.20 && measure <= 1.30) {
                                        piecesApproved++
                                        result = "Approved"
                                    } else {
                                        result = "Refused"
                                    }
                                    counter++
                                    inputValue = ""
                                } else {
                                    inputValue = "You have already insert $pieces pieces"
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
            Row() {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Spacer(modifier = Modifier.size(0.dp, 60.dp))
                    Text(
                        text = result,
                        color =
                        when {
                            result.contains("Approved") -> Color.Green
                            result.contains("Refused") -> Color.Red
                            else -> Color.Black
                        },
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Row() {
                Spacer(modifier = Modifier.weight(0.3f))
                if (counter == pieces) {
                    Button(
                        onClick = {
                            if (!pressed) {
                                result =
                                    "Number of pieces: $pieces\nPieces approved: $piecesApproved"
                            } else {
                                result = ""
                                counter = 0
                                piecesStr = ""
                                pieceInserted = !pieceInserted
                                isReadOnly = false
                                inputValue = ""
                            }
                            pressed = !pressed
                        },
                        modifier = Modifier
                            .width(100.dp)
                            .height(40.dp)
                            .weight(0.4f),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Purple40
                        )
                    ) {
                        Icon(
                            imageVector = if (!pressed) Icons.Default.Check else Icons.Default.Refresh,
                            contentDescription = if (!pressed) "Check" else "Close",
                            tint = Color.White
                        )
                    }
                }
                Spacer(modifier = Modifier.weight(0.3f))
            }
        }
        Column(
            modifier = Modifier.weight(0.2f),
            verticalArrangement = Arrangement.Bottom
        ) {
            Footer(navController, numberProject = 34 )
        }
    }
}