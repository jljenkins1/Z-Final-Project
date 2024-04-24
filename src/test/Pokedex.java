package test;

public class Pokedex {
	
		private static Pokedex instance;
		private List<Pokemon> pokemons;
		
		private Pokedex() {
			pokemons new ArrayList<>();
		}
		
		public static Pokedex getInstance() {
			if (instance == null) {
				instance = new Pokedex();
			}
			return instance;
		}
		//additional methods
}


