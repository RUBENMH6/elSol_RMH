package com.example.ruben_proyecto.menus.menu_x_xx

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.ruben_proyecto.header_footer.Footer_Menu
import com.example.ruben_proyecto.menus.items.Menu_Item
import com.example.ruben_proyecto.menus.items.Menu_Title
import com.example.ruben_proyecto.ui.theme.Purple40
import com.example.ruben_proyecto.ui.theme.Purple400

@Composable
fun MenuProyecto_91_100(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize().padding(bottom = 10.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Menu_Title(number1 = 91, number2 = 100)
        Spacer(modifier = Modifier.height(20.dp))
        Menu_Item(navController, number = 100)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 10.dp),
        contentAlignment = Alignment.BottomEnd

    ) {
        Footer_Menu(navController, 91, 100)
    }
}