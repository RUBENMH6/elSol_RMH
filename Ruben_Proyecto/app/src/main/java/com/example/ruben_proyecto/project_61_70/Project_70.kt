package com.example.ruben_proyecto.project_61_70

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ruben_proyecto.header_footer.Footer
import com.example.ruben_proyecto.header_footer.Header
import com.example.ruben_proyecto.ui.theme.Purple40

@Composable
fun Project_70(navController: NavController) {
    var presentacion by remember { mutableStateOf(true) }
    var cargarSumar by remember { mutableStateOf(false) }
    var finalizacion by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.weight(0.2f)
        ) {
            Header(numberProject = 70)
        }
        Column(
            modifier = Modifier.weight(0.6f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (presentacion) {
                presentacion(presentacion, cargarSumar, { presentacion = it }, { cargarSumar = it })
            }
            if (cargarSumar) {
                cargarSumar(cargarSumar, finalizacion, { cargarSumar = it }, { finalizacion = it })
            }
            if (finalizacion) {
                finalizacion(finalizacion)
            }
        }
        Column(
            modifier = Modifier.weight(0.2f),
            verticalArrangement = Arrangement.Bottom
        ) {
            Footer(navController, numberProject = 70)
        }
    }
}

@Composable
fun presentacion(
    presentacion: Boolean,
    cargarSumar: Boolean,
    onPresentacionChange: (Boolean) -> Unit,
    onCargarSumarChange: (Boolean) -> Unit
) {

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        myText("Programa que permite cargas dos valores por teclado")
        myText("Efectua la suma de los valores")
        myText("Muesra el resulta de la suma")

    }

    TextButton(onClick = {
        onPresentacionChange(!presentacion)
        onCargarSumarChange(!cargarSumar)
    }) {
        Text("Comenzar",
            color = Purple40,
            fontWeight = FontWeight(1000))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun cargarSumar(
    cargarSumar: Boolean,
    finalizacion: Boolean,
    onCargarSumarChange: (Boolean) -> Unit,
    onFinalizacionChange: (Boolean) -> Unit
) {

    var addList = remember { mutableStateListOf<Int>() }
    var counter by remember { mutableStateOf(0) }
    var numberStr by remember { mutableStateOf("") }
    var addition by remember { mutableStateOf("") }
    var added by remember { mutableStateOf(false) }
    OutlinedTextField(
        value = numberStr,
        onValueChange = {
            numberStr = it
        },
        label = { Text(text = "Enter a number ($counter/2)") },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                val number = numberStr.toIntOrNull()
                if (counter < 2) {
                    if (number != null) {
                        addList.add(number)
                    }
                    counter++
                    if (counter == 2) {
                        added = !added
                    }
                    numberStr = ""
                }
            }
        ),
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        shape = RoundedCornerShape(10.dp),
        trailingIcon = {
            IconButton(onClick = {
                counter = 0
                numberStr = ""
                added = false
                addition = ""
                addList.clear()
            }) {
                Icon(
                    imageVector = Icons.Default.Clear,
                    contentDescription = "Clear"
                )
            }
        }
    )
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (added) {
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { added = !added
                    var add = 0
                    for (i in 0 until addList.size) {
                        add += addList[i]
                        addition = add.toString() }},
                modifier = Modifier
                    .width(100.dp)
                    .height(40.dp)
                    .background(color = Purple40, shape = RoundedCornerShape(10.dp)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Purple40
                )
            ) {
                Text(text = "Add")
            }
        }
        if (!added && counter == 2) {
            Spacer(modifier = Modifier.height(20.dp))
            myText("Addition: $addition")
            Spacer(modifier = Modifier.height(20.dp))
            TextButton(onClick = {
                onCargarSumarChange(!cargarSumar)
                onFinalizacionChange(!finalizacion)
            }) {
                Text(
                    text = "Finalizar",
                    color = Purple40,
                    fontWeight = FontWeight(1000)
                )
            }
        }
    }


}

@Composable
fun finalizacion(finalizacion: Boolean) {
    
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        myText("Gracias por utilizar este programa")
    }
    
}

@Composable
fun myText(message: String) {
    Text (
        text = message,
        fontWeight = FontWeight(1000),
        lineHeight = 20.sp,
        textAlign = TextAlign.Center
    )
}