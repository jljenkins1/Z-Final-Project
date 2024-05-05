package test;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.google.gson.annotations.SerializedName;


import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;


public class Pokemon {
	private String name;
    @SerializedName("type") 
    private PType pType;
    @SerializedName("hp") 
    private int maxHP;
    private int currentHP;
    private int attack;
    private int defense;
    @SerializedName("special_attack") 
    private int specialAttack;
    @SerializedName("special_defense") 
    private int specialDefense;
    private List<Move> moves;
    private Player owner;
    public Pokemon(String name, PType pType, int maxHP, int currentHP, int attack, int defense, int specialAttack, int specialDefense, Player Owner) {
        this.name = name;
        this.pType = pType;
        this.maxHP = maxHP;
        this.currentHP = maxHP; 
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.moves = Move.MoveFactory.getMovesForType(pType);
        this.owner = owner;
    }
// getters and setters
    public String getName() {
        return name;
    }

    public PType getPType() {
        return pType;
    }

    public void setPType(PType pType) {
        this.pType = pType;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public int getSpecialDefense() {
        return specialDefense;
    }
    public Player getOwner(){
    	return owner;
    }
    public void setOwner(Player owner) {
    	this.owner = owner;
    }
    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }
    public boolean hasFainted() {
        return currentHP <= 0;
    }

    private static String filePath;

    public Pokemon(String filePath) {
        this.filePath = filePath;
        // Load Pokemon data from the JSON file using the provided file path
    }

    public static Pokemon loadPokemonFromJson(String pokemonName) {
        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader(filePath);
            Type pokemonListType = new TypeToken<List<Pokemon>>() {}.getType();
            List<Pokemon> pokemons = gson.fromJson(reader, pokemonListType);
            if (pokemons != null) {
                for (Pokemon pokemon : pokemons) {
                    if (pokemon.getName().equalsIgnoreCase(pokemonName)) {
                    	pokemon.setPType(PType.valueOf(pokemon.pType.name().toUpperCase()));
                    	pokemon.setCurrentHP(pokemon.getMaxHP());
                        return pokemon;
                    }
                }
            }
            throw new IllegalArgumentException("No Pokémon found with the name: " + pokemonName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", pType=" + pType +
                ", maxHP=" + maxHP +
                ", currentHP=" + currentHP +
                ", attack=" + attack +
                ", defense=" + defense +
                ", specialAttack=" + specialAttack +
                ", specialDefense=" + specialDefense +
                '}';
    }
}
