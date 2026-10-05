package torres.luis.mipokedex_torresluis.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import torres.luis.mipokedex_torresluis.R
import torres.luis.mipokedex_torresluis.model.Pokemon
import torres.luis.mipokedex_torresluis.ui.theme.TextDark

private val DescStyle = TextStyle(color = TextDark, fontSize = 16.sp, lineHeight = 22.sp, textAlign = TextAlign.Center)
private val CardShape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)

@Composable
fun PokemonDetailCard(
    pokemon: Pokemon,
    previous: Pokemon,
    next: Pokemon,
    onPrevious: () -> Unit,
    onNext: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(modifier.fillMaxSize(), shape = CardShape, color = Color.White, shadowElevation = 8.dp) {
        Column(
            Modifier.fillMaxSize().navigationBarsPadding().padding(top = 16.dp, bottom = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            TypeChip(pokemon.type)
            Spacer(Modifier.height(26.dp))
            Row(Modifier.fillMaxWidth().padding(horizontal = 32.dp)) {
                Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(18.dp)) {
                    StatRow(stringResource(R.string.label_altura), pokemon.height)
                    StatRow(stringResource(R.string.label_peso), pokemon.weight)
                }
                StatColumn(stringResource(R.string.label_skill), pokemon.ability, Modifier.weight(1f))
            }
            Spacer(Modifier.height(32.dp))
            Text(pokemon.description, style = DescStyle, modifier = Modifier.padding(horizontal = 32.dp))
            Spacer(Modifier.weight(1f))
            PokemonNavBar(previous, next, onPrevious, onNext)
        }
    }
}
