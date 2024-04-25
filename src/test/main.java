package test;

public class main {

	public static void main(String[] args) {
		Pokedex pokedex = Pokedex.getInstance();
		Player playerOne = new Player("Josh");
		Player playerTwo = new Player("Ethan");
		
		playerOne.addPokemonsToTeam(pokedex.getAllPokemon().get(0));
		playerTwo.addPokemonsToTeam(pokedex.getAllPokemon().get(1));
		
		Battle battle = new Battle(playerOne, playerTwo);
		battle.startBattle(); //Start the battle
		

	}

}
