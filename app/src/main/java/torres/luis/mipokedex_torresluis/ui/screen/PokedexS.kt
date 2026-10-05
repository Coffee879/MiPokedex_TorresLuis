package torres.luis.mipokedex_torresluis.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.zIndex
import torres.luis.mipokedex_torresluis.model.Pokemon
import torres.luis.mipokedex_torresluis.model.SamplePokemon
import torres.luis.mipokedex_torresluis.ui.components.PokemonDetailCard
import torres.luis.mipokedex_torresluis.ui.components.PokemonHeader
import torres.luis.mipokedex_torresluis.ui.theme.PokemonYellow

@Composable
fun PokedexRoute(pokemons: List<Pokemon> = SamplePokemon) {
    var index by rememberSaveable { mutableIntStateOf(1) }
    var favorites by rememberSaveable { mutableStateOf(setOf<Int>()) }

    val size = pokemons.size
    val current = pokemons[index]
    val previous by remember(pokemons) { derivedStateOf { pokemons[(index - 1 + size) % size] } }
    val next by remember(pokemons) { derivedStateOf { pokemons[(index + 1) % size] } }

    PokedexScreen(
        pokemon = current,
        previous = previous,
        next = next,
        isFavorite = current.dexNumber in favorites,
        onFavoriteClick = {
            favorites = if (current.dexNumber in favorites) favorites - current.dexNumber else favorites + current.dexNumber
        },
        onPrevious = { index = (index - 1 + size) % size },
        onNext = { index = (index + 1) % size },
    )
}

@Composable
fun PokedexScreen(
    pokemon: Pokemon,
    previous: Pokemon,
    next: Pokemon,
    isFavorite: Boolean,
    onFavoriteClick: () -> Unit,
    onPrevious: () -> Unit,
    onNext: () -> Unit,
) {
    Column(Modifier.fillMaxSize().background(PokemonYellow)) {
        PokemonHeader(pokemon, isFavorite, onFavoriteClick, Modifier.weight(0.36f).zIndex(1f))
        PokemonDetailCard(pokemon, previous, next, onPrevious, onNext, Modifier.weight(0.64f))
    }
}
