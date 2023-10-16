package com.example.ruben_proyecto.menus.items

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ruben_proyecto.ui.theme.Purple40

@Composable
fun Menu_Item(navController: NavController, number: Int) {
    //Method that implements the buttons of each project
    var configuration = LocalConfiguration.current //Taking into account the orientation of the device
    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            Row(
                modifier = Modifier.padding(top = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
            for (i in number - 9..number - 5) {
                    Button(
                        onClick = { navController.navigate("Project_$i") },
                        modifier = Modifier
                            .width(100.dp)
                            .height(40.dp)
                            .background(color = Purple40, shape = RoundedCornerShape(10.dp)),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Purple40
                        )
                    ) {
                        Text(
                            text = "P$i",
                            fontWeight = FontWeight.Bold
                        )
                    }
                Spacer(modifier = Modifier.size(20.dp))
                }
            }
            Spacer(modifier = Modifier.size(20.dp))
            Row() {
            for (i in number - 4..number) {
                    Button(
                        onClick = { navController.navigate("Project_$i") },
                        modifier = Modifier
                            .width(100.dp)
                            .height(40.dp).padding(top = 5.dp)
                            .background(color = Purple40, shape = RoundedCornerShape(10.dp)),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Purple40
                        )
                    ) {
                        Text(
                            text = "P$i",
                            fontWeight = FontWeight.Bold
                        )
                    }
                Spacer(modifier = Modifier.size(20.dp))
                }
            }
        }
        else -> {
            for (i in number - 9..number) {
                Row() {
                    Button(
                        onClick = { navController.navigate("Project_$i") },
                        modifier = Modifier
                            .width(200.dp)
                            .height(40.dp)
                            .background(color = Purple40, shape = RoundedCornerShape(10.dp)),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Purple40
                        )
                    ) {
                        Text(
                            text = "Project $i",
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                Spacer(modifier = Modifier.size(20.dp))
            }
        }
    }
}