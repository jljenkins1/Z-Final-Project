package test;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

public class Player {
    private String playerName;
    private List<Pokemon> team;
    private Pokemon activePokemon;

    public Player() {
        this.team = new ArrayList<>();
        this.playerName = getPlayerNameFromUser();
        addPokemonToTeamFromUserInput();
    }
    public void removeFaintedPokemon() {
        Iterator<Pokemon> iterator = team.iterator();
        while (iterator.hasNext()) {
            Pokemon pokemon = iterator.next();
            if (pokemon.hasFainted()) {
                iterator.remove();
                System.out.println(pokemon.getName() + " has fainted and was removed from " + playerName + "'s team.");
            }
        }
    }
            //getters and setters

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public List<Pokemon> getTeam() {
        return team;
    }

    public void setTeam(List<Pokemon> team) {
        this.team = team;
    }
    
    public Pokemon getActivePokemon() {
        return activePokemon;
    }

    public void setActivePokemon(Pokemon activePokemon) {
        this.activePokemon = activePokemon;
    }
    //user inputted names for each player
    private String getPlayerNameFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter player name: ");
        return scanner.nextLine();
    }
    //allow users to type in names of pokemon to add to their roster of six

    private void addPokemonToTeamFromUserInput() {
        Scanner scanner = new Scanner(System.in);
        boolean addedPokemon = false;
        for (int i = 0; i < 6; i++) {
            System.out.print("Enter the name of the Pokemon to add to your team (or type 'done' to finish, 'display' to see all Pokemon): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
            	if(!addedPokemon) {
            		System.out.println("You must add at least one pokemon!");
            		i--;
            		continue;
            	}
                break;
            } else if (input.equalsIgnoreCase("display")) {
            	//this allows users to see all the pokemon that are availible and their stats.
                Pokedex.displayAllPokemon();
            } else {
                Pokemon pokemon = Pokemon.loadPokemonFromJson(input);
                if (pokemon != null) {
                	List<Move> moves = Move.MoveFactory.getMovesForType(pokemon.getPType());
                    pokemon.setMoves(moves);
                    team.add(pokemon);
                    addedPokemon = true;
                    System.out.println(input + " added to your team!");
                } else {
                    System.out.println("Pokemon not found!");
                }
            }
        }
    }
    public void removePokemon(Pokemon pokemon) {
        team.remove(pokemon);
    }
    //method that prints all stats of a team including name type and other stats
    public void printTeamDetails() {
        System.out.println("Player: " + playerName);
        System.out.println("Team: ");
        for (Pokemon pokemon : team) {
            System.out.println(pokemon.toString());
        }
    }
}
