package torres.luis.mipokedex_torresluis.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import torres.luis.mipokedex_torresluis.ui.theme.PokemonRed
import torres.luis.mipokedex_torresluis.ui.theme.PokemonYellow
import torres.luis.mipokedex_torresluis.ui.theme.TextDark

private val LabelStyle = TextStyle(color = PokemonRed, fontSize = 18.sp, fontWeight = FontWeight.Bold)
private val ValueStyle = TextStyle(color = TextDark, fontSize = 17.sp)
private val TypeStyle = TextStyle(color = TextDark, fontSize = 13.sp, fontWeight = FontWeight.Bold)
private val ChipShape = RoundedCornerShape(topStart = 45.dp, topEnd = 45.dp)

@Composable
fun TypeChip(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = TypeStyle,
        modifier = modifier.clip(ChipShape).background(PokemonYellow).padding(horizontal = 14.dp, vertical = 5.dp),
    )
}

@Composable
fun StatRow(label: String, value: String, modifier: Modifier = Modifier) {
    Row(modifier) {
        Text(label, style = LabelStyle)
        Spacer(Modifier.width(8.dp))
        Text(value, style = ValueStyle)
    }
}

@Composable
fun StatColumn(label: String, value: String, modifier: Modifier = Modifier) {
    Column(modifier) {
        Text(label, style = LabelStyle)
        Text(value, style = ValueStyle, maxLines = 2, overflow = TextOverflow.Ellipsis, modifier = Modifier.padding(top = 4.dp))
    }
}
