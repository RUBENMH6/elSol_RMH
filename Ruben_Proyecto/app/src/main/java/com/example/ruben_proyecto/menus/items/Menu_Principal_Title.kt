package com.example.ruben_proyecto.menus.items

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.ruben_proyecto.ui.theme.Purple40

@Composable
fun Menu_Principal_Title() {
    Text(
        text = "Projects of Rubén",
        fontSize = 30.sp,
        color = Purple40,
        fontWeight = FontWeight.Bold
    )
}