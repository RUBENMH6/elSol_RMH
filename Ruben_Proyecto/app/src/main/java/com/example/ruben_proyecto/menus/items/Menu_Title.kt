package com.example.ruben_proyecto.menus.items

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ruben_proyecto.ui.theme.Purple40

@Composable
fun Menu_Title(number1: Int, number2: Int) {
        Text(
            text = "Projects $number1 to $number2",
            fontSize = 20.sp,
            color = Purple40,
            fontWeight = FontWeight.Bold
        )
}