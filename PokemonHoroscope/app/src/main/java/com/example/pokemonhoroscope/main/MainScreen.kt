package com.example.pokemonhoroscope.main

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: PokemonViewModel) {
    val state = viewModel.state
    var year by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextField(value = year,
            onValueChange = { year = it },
            label = { Text(text = "Año de nacimiento")  },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
        //Button(onClick = { viewModel.CallApi(name.lowercase(Locale.getDefault())) }) { Text(text = "Buscar Pokemon") }
        Button(onClick = { viewModel.getHoroscope(year.toInt()) }) { Text(text = "Saber mi animal del horóscopo") }

        if (state.isLoading) {
            println("Esta cargando")
            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        if (state.pokemon.isNotEmpty() && state.called) {
            println("Cargo")
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                println(state.pokemon)
                Text(
                    text = "Su animal es: ${state.animal.capitalize(Locale.ROOT)}",
                    fontSize = 30.sp
                )
                AsyncImage(
                    model = state.pokemon[0].imageUrl,
                    contentDescription = "Imagen de ${state.pokemon[0].name}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                )
            }
        } else if(state.called) {
            Log.i("NotFound", "${state.called}")
            Text(text = "No existen pokemon con ese nombre")
        }
    }
}