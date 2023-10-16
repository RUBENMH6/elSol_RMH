package com.example.ruben_proyecto.header_footer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ruben_proyecto.ui.theme.Purple400

@Composable
fun Footer_Menu(navController: NavController, number1: Int, number2: Int) {
    val numPrev1 = number1 - 10
    val numPrev2 = number2 - 10
    val numNext1 = number1 + 10
    val numNext2 = number2 + 10
    //This method is for make a footer in Menu_X_XX.kt for return to Menu.kt
    Row(
        modifier = Modifier
            .padding(5.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom
    ) {

        if (number2 != 10) {
            Spacer(modifier = Modifier.weight(0.15f))
            Button(
                onClick = { navController.navigate("Menu_${numPrev1}_${numPrev2}") },
                modifier = Modifier
                    .width(200.dp)
                    .height(40.dp)
                    .background(color = Purple400, shape = RoundedCornerShape(10.dp))
                    .weight(0.15f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Purple400
                )
            ) {
                Text(text = "<")
            }
        } else {
            Spacer(modifier = Modifier.weight(0.3f))
        }
        Spacer(modifier = Modifier.size(5.dp))
        Button(
            onClick = { navController.navigate("Menu") },
            modifier = Modifier
                .width(200.dp)
                .height(40.dp)
                .background(color = Purple400, shape = RoundedCornerShape(10.dp))
                .weight(0.3f),
            colors = ButtonDefaults.buttonColors(
                containerColor = Purple400
            )
        ) {
            Text(text = "Back")
        }
        Spacer(modifier = Modifier.size(5.dp))
        Button(
            onClick = { navController.navigate("Menu_${numNext1}_${numNext2}") },
            modifier = Modifier
                .width(200.dp)
                .height(40.dp)
                .background(color = Purple400, shape = RoundedCornerShape(10.dp))
                .weight(0.15f),
            colors = ButtonDefaults.buttonColors(
                containerColor = Purple400
            )
        ) {
            Text(text = ">")
        }
        Spacer(modifier = Modifier.weight(0.15f))
    }


}