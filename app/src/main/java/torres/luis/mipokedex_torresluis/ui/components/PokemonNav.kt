package torres.luis.mipokedex_torresluis.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import torres.luis.mipokedex_torresluis.R
import torres.luis.mipokedex_torresluis.model.Pokemon
import torres.luis.mipokedex_torresluis.ui.theme.TextDark

private val NavStyle = TextStyle(color = TextDark, fontSize = 11.sp, textAlign = TextAlign.Center)

@Composable
private fun NavPokemon(pokemon: Pokemon, modifier: Modifier = Modifier) {
    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painterResource(pokemon.image), pokemon.navLabel, Modifier.size(80.dp))
        Text(pokemon.navLabel, style = NavStyle, maxLines = 1, overflow = TextOverflow.Ellipsis)
    }
}

@Composable
fun PokemonNavBar(
    previous: Pokemon,
    next: Pokemon,
    onPrevious: () -> Unit,
    onNext: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(modifier.fillMaxWidth(), verticalAlignment = Alignment.Bottom) {
        IconButton(onPrevious) {
            Icon(painterResource(R.drawable.ic_flecha_atras), stringResource(R.string.anterior), tint = TextDark)
        }
        NavPokemon(previous, Modifier.weight(1f))
        NavPokemon(next, Modifier.weight(1f))
        IconButton(onNext) {
            Icon(painterResource(R.drawable.ic_flecha_adelante), stringResource(R.string.next), tint = TextDark)
        }
    }
}
