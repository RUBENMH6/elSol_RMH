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
fun Footer(navController: NavController, numberProject: Int) {
    //This method is for make a footer to Project_X.kt

    //Exemple: numberProject: 5
    val previous = numberProject - 1 // Ex: 4
    val next = numberProject + 1 // Ex: 6
    val nameProject = "Project_$numberProject" // Ex: Project_5
    val projectPrevious = "Project_$previous" // Ex: Project_4
    val projectNext = "Project_$next" // Ex: Project_6

    //Depending on the project, the 'Back' button returns to one menu or another.
    val rutaIndex = when (numberProject) {
        in 1 .. 10 -> "Menu_1_10" // For the example, the 'Back' button would return to 'Menu_1_10.kt'
        in 11 .. 20 -> "Menu_11_20"
        in 21 .. 30 -> "Menu_21_30"
        in 31.. 40 -> "Menu_31_40"
        in 41 .. 50 -> "Menu_41_50"
        in 51 .. 60 -> "Menu_51_60"
        in 61 .. 70 -> "Menu_61_70"
        in 71 .. 80 -> "Menu_71_80"
        in 81 .. 90 -> "Menu_81_90"
        in 91 .. 100 -> "Menu_91_100"
        else -> ""
    }
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Bottom
        ) {
            Button(
                onClick = { navController.navigate(rutaIndex) },
                modifier = Modifier
                    .width(200.dp)
                    .height(40.dp)
                    .background(color = Purple400, shape = RoundedCornerShape(10.dp))
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Purple400
                )
            ) {
                Text(text = "Back")
            }
            Spacer(modifier = Modifier.size(5.dp))
            Button(
                onClick = { navController.navigate(projectPrevious) },
                modifier = Modifier
                    .width(200.dp)
                    .height(40.dp)
                    .background(color = Purple400, shape = RoundedCornerShape(10.dp))
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Purple400
                )
            ) {
                Text(text = "<")
            }
            Spacer(modifier = Modifier.size(5.dp))
            Button(
                onClick = { navController.navigate(projectNext) },
                modifier = Modifier
                    .width(200.dp)
                    .height(40.dp)
                    .background(color = Purple400, shape = RoundedCornerShape(10.dp))
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Purple400
                )
            ) {
                Text(text = ">")
            }
            Spacer(modifier = Modifier.size(5.dp))
            Button(
                onClick = { navController.navigate("Menu") },
                modifier = Modifier
                    .width(200.dp)
                    .height(40.dp)
                    .background(color = Purple400, shape = RoundedCornerShape(10.dp))
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Purple400
                )
            ) {
                Text(text = "Menu")
            }
        }


}





