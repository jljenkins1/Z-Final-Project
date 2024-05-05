package test;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Pokedex {
    private static final String FILE_PATH = "test/pokemon.json";

    // Method to display all Pokemon and their stats from the JSON file (complies into the .jar file itself as well)
    public static void displayAllPokemon() {
        System.out.println("Complete Pokedex:");
        try {
            Gson gson = new Gson();
            InputStream inputStream = Pokedex.class.getClassLoader().getResourceAsStream(FILE_PATH);
            if (inputStream != null) {
                InputStreamReader reader = new InputStreamReader(inputStream);
                Type pokemonListType = new TypeToken<List<Pokemon>>() {}.getType();
                List<Pokemon> pokemons = gson.fromJson(reader, pokemonListType);
                if (pokemons != null) {
                    for (Pokemon pokemon : pokemons) {
                        System.out.println(pokemon.getName() + " - Type: " + pokemon.getPType() +
                                ", Max HP: " + pokemon.getMaxHP() + ", Attack: " + pokemon.getAttack() +
                                ", Defense: " + pokemon.getDefense() + ", Special Attack: " + pokemon.getSpecialAttack() +
                                ", Special Defense: " + pokemon.getSpecialDefense());
                    }
                } else {
                    System.out.println("No Pokémon found in the Pokedex.");
                }
            } else {
                System.out.println("Pokemon JSON file not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

