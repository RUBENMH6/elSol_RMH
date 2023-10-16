package com.example.ruben_proyecto.items

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun Item_Result_Middle(result: String) {
    Spacer(modifier = Modifier.height(20.dp))
    Row() {
        Spacer(modifier = Modifier.weight(0.3f))
        Text(
            text = result,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.weight(0.3f))
    }
}