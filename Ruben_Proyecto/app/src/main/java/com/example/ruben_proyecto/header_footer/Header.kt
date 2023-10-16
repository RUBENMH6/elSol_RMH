package com.example.ruben_proyecto.header_footer

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.ruben_proyecto.ui.theme.Purple40

@Composable
fun Header(numberProject: Int) {
    //Method to put the project number in the header and two dividers to make it look more beautiful
    Spacer(modifier = Modifier.size(10.dp))
    Divider(thickness = 2.dp, color = Purple40)
    Spacer(modifier = Modifier.size(10.dp))
    Row() {
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "PROJECT $numberProject",
            color = Purple40,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center

        )
        Spacer(modifier = Modifier.weight(1f))
    }
    Spacer(modifier = Modifier.size(10.dp))
    Divider(thickness = 2.dp, color = Purple40)
    Spacer(modifier = Modifier.size(0.dp))
}