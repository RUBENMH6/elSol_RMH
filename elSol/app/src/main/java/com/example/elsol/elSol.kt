import com.example.elsol.SolInfo
import com.example.elsol.getSol



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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.elsol.ui.theme.Purple80
import kotlinx.coroutines.launch

@Composable
fun elSol(snackbarHostState: SnackbarHostState) {
    Column {
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(getSol()) { sol ->
                MyCard(sol, snackbarHostState)
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCard(solInfo: SolInfo, snackbarHostState: SnackbarHostState) {
    val scope = rememberCoroutineScope()
    Card(
        elevation = CardDefaults.cardElevation(6.dp),
        modifier = Modifier.padding(start = 5.dp, end = 5.dp , top = 10.dp, bottom = 10.dp),
        colors = CardDefaults.cardColors(Purple80),
        onClick = { scope.launch { snackbarHostState.showSnackbar(solInfo.name) }}
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