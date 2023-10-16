package com.example.ruben_proyecto.menus

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ruben_proyecto.menus.items.Menu_Item
import com.example.ruben_proyecto.menus.items.Menu_Principal_Item
import com.example.ruben_proyecto.menus.items.Menu_Principal_Title
import com.example.ruben_proyecto.menus.items.Menu_Title
import com.example.ruben_proyecto.ui.theme.Purple40

@Composable
fun MenuProyecto(navController: NavHostController) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize().padding(50.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Menu_Principal_Title()
        Spacer(modifier = Modifier.size(30.dp))
        Menu_Principal_Item(navController, number = 100)
    }
}