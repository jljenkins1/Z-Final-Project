package test;

import java.util.List;

public class Player {
	private String name;
	private List<Pokemon> team;
	
	public Player(String name) {
		this.name = name;
		this.team = new ArrayList<>(); //initializes list of pokemon team
	}
	
	public void addPokemonToTeam(Pokemon pokemon) {
		if (team.size() < 6) {
			team.add(pokemon);
		}
	}
	//other methods like chooseMove and switchPokemon
}
