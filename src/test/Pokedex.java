package test;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class Pokedex {
    private static final String filePath = "src/test/pokemon.json";

    // Method to display all Pokemon and their stats from the JSON file
    public static void displayAllPokemon() {
        System.out.println("Complete Pokedex:");
    	try {
            Gson gson = new Gson();
            FileReader reader = new FileReader(filePath);
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
