package torres.luis.mipokedex_torresluis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import torres.luis.mipokedex_torresluis.data.pokemonList
import torres.luis.mipokedex_torresluis.ui.components.MenuPokedex
import torres.luis.mipokedex_torresluis.ui.theme.PokedexTheme

class PokedexList : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokedexTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MenuPokedex(pokemonList, innerPadding)
                }
            }
        }
    }
}
