package com.example.elsol

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridItemScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elsol.ui.theme.Purple80

@Composable
fun elSol() {
    Column {
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(getSol()) { sol ->
                MyCard(sol)
            }
        }
    }
}

@Composable
fun MyCard(solInfo: SolInfo) {
    Card(
        elevation = CardDefaults.cardElevation(6.dp),
        modifier = Modifier.padding(start = 5.dp, end = 5.dp , top = 10.dp, bottom = 10.dp),
        colors = CardDefaults.cardColors(Purple80)
    ) {
        Image(
            painter = painterResource(solInfo.imageId),
            contentDescription = solInfo.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .size(200.dp)
        )
        Row(
            modifier = Modifier
                .height(60.dp)
                .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,

        ) {
            Text(
                text = solInfo.name,
                modifier = Modifier.weight(0.9f)
            )
            Icon(
                imageVector = Icons.Filled.MoreVert,
                contentDescription = null
            )
        }


    }
    Spacer(modifier = Modifier.height(20.dp))
}