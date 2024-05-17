package es.cesur.progprojectpok.utils;

import es.cesur.progprojectpok.clases.Entrenador;
import es.cesur.progprojectpok.clases.Pokemon;
import es.cesur.progprojectpok.clases.Tipos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PokemonTest {

    private Entrenador entrenador;
    private Pokemon pokemon;
    private Pokemon enemigo;

    @BeforeEach
    void setUp() {
        entrenador = new Entrenador("DaniManse", "1234", 1);
        pokemon = new Pokemon("Pikachu", Tipos.Agua, Tipos.Fuego);
        enemigo = new Pokemon("Charmander", Tipos.Eléctrico, Tipos.Agua);
        entrenador.setEquipo(new Pokemon[]{pokemon, null, null, null, null, null});
    }

    @Test
    void subirNivel() {
        int nivelInicial = pokemon.getNivelPok();
        pokemon.subirNivel(10);
        int nivelFinal = pokemon.getNivelPok();
        assertTrue(nivelFinal == nivelInicial + 1, "El nivel del Pokémon debería aumentar en 1");
        assertFalse(nivelFinal < nivelInicial + 1, "El nivel del Pokémon debería aumentar en 1");
    }


    @Test
    void capturar() {
        int equipoInicial = entrenador.getEquipo().length;
        entrenador.capturar(enemigo);
        int equipoFinal = entrenador.getEquipo().length;
        assertFalse(equipoFinal == equipoInicial + 1, "El Pokémon capturado debería añadirse al equipo");
    }

}

