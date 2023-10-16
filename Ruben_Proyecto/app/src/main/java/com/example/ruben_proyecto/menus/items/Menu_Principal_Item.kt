package com.example.ruben_proyecto.menus.items

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ruben_proyecto.ui.theme.Purple40

@Composable
fun Menu_Principal_Item(navController: NavController, number: Int) {
    var configuration = LocalConfiguration.current
    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            Row() {
            for (i in 1 ..number/2 step 10) {

                    Button(
                        onClick = { navController.navigate("Menu_${i}_${i+9}") },
                        modifier = Modifier
                            .width(120.dp)
                            .height(40.dp)
                            .background(color = Purple40, shape = RoundedCornerShape(10.dp)),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Purple40
                        )
                    ) {
                        Text(
                            text = "${i} to ${i+9}",
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.size(20.dp))
                }

            }
            Spacer(modifier = Modifier.height(20.dp))
            Row() {
            for (i in number/2 +1 ..number step 10) {

                    Button(
                        onClick = { navController.navigate("Menu_${i}_${i+9}") },
                        modifier = Modifier
                            .width(120.dp)
                            .height(40.dp)
                            .background(color = Purple40, shape = RoundedCornerShape(10.dp)),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Purple40
                        )
                    ) {
                        Text(
                            text = "${i} to ${i+9}",
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.size(20.dp))
                }

            }
        }
        else -> {
            for (i in 1..number step 10) {
                Button(
                    onClick = { navController.navigate("Menu_${i}_${i+9}") },
                    modifier = Modifier
                        .width(200.dp)
                        .height(40.dp)
                        .background(color = Purple40, shape = RoundedCornerShape(10.dp)),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Purple40
                    )
                ) {
                    Text(
                        text = "Project ${i} to ${i+9}",
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.size(20.dp))
            }
        }
    }
}