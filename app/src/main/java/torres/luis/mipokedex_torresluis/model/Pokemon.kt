package torres.luis.mipokedex_torresluis.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import torres.luis.mipokedex_torresluis.R

@Immutable
data class Pokemon(
    val dexNumber: Int,
    val name: String,
    val type: String,
    val height: String,
    val weight: String,
    val ability: String,
    val description: String,
    @DrawableRes val image: Int,
) {
    val number: String = "#$dexNumber"
    val navLabel: String = "$name N. ${dexNumber.toString().padStart(4, '0')}"
}

val SamplePokemon = listOf(
    Pokemon(6, "Charizard", "fuego / volador", "1,7 m", "90,5 kg", "mar llamas",
        "escupe fuego tan caliente que puede derretir rocas", R.drawable.charizard)
)
