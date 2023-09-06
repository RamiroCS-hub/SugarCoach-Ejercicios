package com.example.pokemonhoroscope.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pokemonhoroscope.R
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: PokemonViewModel) {
    val state = viewModel.state
    var name by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextField(value = name,
            onValueChange = { name = it })
        Button(onClick = { viewModel.CallApi(name.lowercase(Locale.getDefault())) }) { Text(text = "LLamar a la API") }

        if (state.isLoading) {
            println("Esta cargando")
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        if (state.pokemon?.name != "" && state.pokemon != null) {
            println("Cargo")
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                println(state.pokemon)
                Text(
                    text = state.pokemon!!.name,
                    modifier = Modifier.fillMaxWidth()
                )
                AsyncImage(
                    model = state.pokemon!!.imageUrl,
                    contentDescription = "Imagen de ${state.pokemon!!.name}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                )
            }
        } else {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(text = "No existen pokemon con ese nombre")
            }
        }
    }
}