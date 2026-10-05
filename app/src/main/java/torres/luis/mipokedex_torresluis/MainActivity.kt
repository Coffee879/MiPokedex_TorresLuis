package torres.luis.mipokedex_torresluis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import torres.luis.mipokedex_torresluis.ui.screen.PokedexRoute
import torres.luis.mipokedex_torresluis.ui.theme.PokedexTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokedexTheme { PokedexRoute() }
        }
    }
}
