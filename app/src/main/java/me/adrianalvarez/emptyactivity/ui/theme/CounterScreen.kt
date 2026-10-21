package me.adrianalvarez.emptyactivity.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CounterScreen(viewModel: CounterViewModel = viewModel()) {

    var contadorNormal by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "¿Qué es un ViewModel?",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Es una clase que guarda y maneja el estado de la pantalla, " +
                    "y sobrevive a cambios como rotar el celular.",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        Text("Contador SIN ViewModel", fontWeight = FontWeight.Bold)
        Text("$contadorNormal", fontSize = 40.sp)
        Button(onClick = { contadorNormal++ }) {
            Text("Sumar")
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text("Contador CON ViewModel", fontWeight = FontWeight.Bold)
        Text("${viewModel.contador}", fontSize = 40.sp)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { viewModel.incrementar() }) {
                Text("Sumar")
            }
            OutlinedButton(onClick = { viewModel.reiniciar() }) {
                Text("Reiniciar")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Prueba: suma en ambos contadores y rota el celular. " +
                    "El de arriba vuelve a 0, el de abajo se mantiene.",
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        )
    }
}