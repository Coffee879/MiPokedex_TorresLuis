package torres.luis.mipokedex_torresluis.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val PokemonYellow = Color(0xFFF7D928)
val PokemonRed = Color(0xFFD72E2E)
val TextDark = Color(0xFF4F4F4F)

private val Scheme = lightColorScheme(primary = PokemonRed, background = Color.White, onBackground = TextDark)

@Composable
fun PokedexTheme(content: @Composable () -> Unit) =
    MaterialTheme(colorScheme = Scheme, typography = Typography, content = content)
