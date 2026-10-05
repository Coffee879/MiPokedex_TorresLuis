package torres.luis.mipokedex_torresluis.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import torres.luis.mipokedex_torresluis.R
import torres.luis.mipokedex_torresluis.model.Pokemon
import torres.luis.mipokedex_torresluis.ui.theme.PokemonRed
import torres.luis.mipokedex_torresluis.ui.theme.TextDark

private val NameStyle = TextStyle(color = Color.White, fontSize = 45.sp, fontWeight = FontWeight.Bold)
private val NumberStyle = TextStyle(color = TextDark, fontSize = 20.sp, fontWeight = FontWeight.Bold)

@Composable
fun PokemonHeader(
    pokemon: Pokemon,
    isFavorite: Boolean,
    onFavoriteClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(modifier.fillMaxSize().statusBarsPadding()) {
        Image(
            painter = painterResource(R.drawable.pokebola),
            contentDescription = null, // decorativa
            modifier = Modifier.align(Alignment.TopEnd).padding(top = 48.dp).size(260.dp).alpha(0.95f),
            contentScale = ContentScale.Fit,
        )
        Column(Modifier.padding(start = 24.dp, top = 28.dp)) {
            Text(pokemon.name, style = NameStyle)
            Text(pokemon.number, style = NumberStyle, modifier = Modifier.padding(top = 4.dp))
        }
        IconButton(
            onClick = onFavoriteClick,
            modifier = Modifier.align(Alignment.TopEnd).padding(top = 8.dp, end = 12.dp),
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_favortio),
                contentDescription = stringResource(R.string.fav),
                tint = if (isFavorite) PokemonRed else Color.White,
            )
        }
        Image(
            painter = painterResource(pokemon.image),
            contentDescription = pokemon.name,
            modifier = Modifier.align(Alignment.BottomCenter).size(width = 180.dp, height = 190.dp),
            contentScale = ContentScale.Fit,
        )
    }
}
