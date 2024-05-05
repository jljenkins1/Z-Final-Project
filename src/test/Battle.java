package test;

import java.util.Scanner;
import java.util.List;


public class Battle {
    private Player playerOne;
    private Player playerTwo;
    private boolean isOver; // Flag to indicate the battle is over

    public Battle(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.isOver = false;
        
    }

    public void startBattle() {
        selectActivePokemon(playerOne);
        selectActivePokemon(playerTwo);
        // Logic to conduct the battle
        while (!isOver) {
            // Player One's turn
            System.out.println("Player One's turn:");
            takeTurn(playerOne, playerTwo);

            // Check if battle is over
            if (checkWinCondition()) {
                isOver = true;
                break;
            }

            // Player Two's turn
            System.out.println("Player Two's turn:");
            takeTurn(playerTwo, playerOne);

            // Check if battle is over
            if (checkWinCondition()) {
                isOver = true;
                break;
            }
        }

        // Once the battle is over, display the winner or any other end-of-battle logic
        if (isOver) {
            // Display winner or any other end-of-battle logic
            System.exit(0); // Terminate the program
        }
    }

    private void selectActivePokemon(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(player.getPlayerName() + ", choose your active Pokémon:");
        List<Pokemon> team = player.getTeam();
        for (int i = 0; i < team.size(); i++) {
            System.out.println((i + 1) + ". " + team.get(i).getName());
        }
        System.out.print("Enter the number corresponding to your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (choice >= 1 && choice <= team.size()) {
            Pokemon activePokemon = team.get(choice - 1);
            activePokemon.setOwner(player); // Set the owner here
            player.setActivePokemon(activePokemon);
            System.out.println(player.getPlayerName() + " selected " + activePokemon.getName() + " as the active Pokémon.");
        } else {
            System.out.println("Invalid choice. Please try again.");
            selectActivePokemon(player);
            
        }

    }
    private void takeTurn(Player currentPlayer, Player opponentPlayer) {
        System.out.println(currentPlayer.getPlayerName() + "'s turn:");
        currentPlayer.printTeamDetails();
        System.out.println("Choose an option:");
        System.out.println("1. Attack");
        System.out.println("2. Switch Pokémon");
        int choice = getPlayerChoice();

        switch (choice) {
            case 1:
                chooseAttack(currentPlayer, opponentPlayer);
                break;
            case 2:
                // Logic to switch Pokémon
            	selectActivePokemon(currentPlayer);
                break;
            default:
                System.out.println("Invalid choice. Please choose again.");
                takeTurn(currentPlayer, opponentPlayer); // Prompt again for a valid choice
                break;
        }
    }
    private void chooseAttack(Player playerOne, Player playerTwo) {
        // Get player one's move choice
        Pokemon p1ActivePokemon = playerOne.getActivePokemon();
        List<Move> p1Moves = p1ActivePokemon.getMoves();
        System.out.println("Choose a move for " + p1ActivePokemon.getName() + ":");
        for (int i = 0; i < p1Moves.size(); i++) {
            System.out.println((i + 1) + ". " + p1Moves.get(i).getName());
        }
        int p1MoveChoice = getPlayerChoice();
        Move p1SelectedMove = p1Moves.get(p1MoveChoice - 1);

        // Get player two's move choice
        Pokemon p2ActivePokemon = playerTwo.getActivePokemon();
        List<Move> p2Moves = p2ActivePokemon.getMoves();
        System.out.println("Choose a move for " + p2ActivePokemon.getName() + ":");
        for (int i = 0; i < p2Moves.size(); i++) {
            System.out.println((i + 1) + ". " + p2Moves.get(i).getName());
        }
        int p2MoveChoice = getPlayerChoice();
        Move p2SelectedMove = p2Moves.get(p2MoveChoice - 1);

        // Determine turn order based on move speeds
        if (p1SelectedMove.getSpeed() > p2SelectedMove.getSpeed()) {
            applyDamage(p1ActivePokemon, p1SelectedMove, p2ActivePokemon);
            applyDamage(p2ActivePokemon, p2SelectedMove, p1ActivePokemon);
        } else if (p1SelectedMove.getSpeed() < p2SelectedMove.getSpeed()) {
            applyDamage(p2ActivePokemon, p2SelectedMove, p1ActivePokemon);
            applyDamage(p1ActivePokemon, p1SelectedMove, p2ActivePokemon);
        } else {
            // Speeds are equal, decide randomly or through a tie-breaking method
            // For simplicity, let's use a coin toss
            if (Math.random() < 0.5) {
                applyDamage(p1ActivePokemon, p1SelectedMove, p2ActivePokemon);
                applyDamage(p2ActivePokemon, p2SelectedMove, p1ActivePokemon);
            } else {
                applyDamage(p2ActivePokemon, p2SelectedMove, p1ActivePokemon);
                applyDamage(p1ActivePokemon, p1SelectedMove, p2ActivePokemon);
            }
        }
    }


    
    private void applyDamage(Pokemon attacker, Move move, Pokemon defender) {
        // Calculate the effectiveness multiplier
        double effectivenessMultiplier = move.getEffectivenessMultiplier(attacker.getPType(), defender.getPType());
        if (attacker.getCurrentHP() <= 0) {
            // Output a message indicating that the defender has already fainted
            System.out.println(defender.getName() + " has already fainted!");
            return; // Exit the method early to prevent further execution
        }
        // Determine if the move is physical or special
        int attackStat = move.isPhysical() ? attacker.getAttack() : attacker.getSpecialAttack();
        int defenseStat = move.isPhysical() ? defender.getDefense() : defender.getSpecialDefense();
        
        // Calculate damage
        int baseDamage = move.getPower();
        int damage = (int) Math.floor((baseDamage + (attackStat - defenseStat)) * effectivenessMultiplier);

        // Apply damage to the opponent's Pokémon
        defender.setCurrentHP(defender.getCurrentHP() - damage);

        // Output the damage dealt
        System.out.println(attacker.getName() + " used " + move.getName() + "!");
        System.out.println("It dealt " + damage + " damage to " + defender.getName() + "!");

        // Check if the opponent's Pokémon has fainted
        if (defender.getCurrentHP() <= 0) {
            System.out.println(defender.getName() + " fainted!");
            Player owner = defender.getOwner();
            owner.getTeam().remove(defender);
            // Set a new active Pokémon for the owner if there are remaining Pokémon in the team
            if (!owner.getTeam().isEmpty()) {
                System.out.println("Selecting a new active Pokémon for " + owner.getPlayerName() + "...");
                selectActivePokemon(owner);
            } else {
                System.out.println(owner.getPlayerName() + " has no remaining Pokémon. They lose the battle!");
                // Implement logic to end the battle or declare the other player as the winner
                if(playerOne.getTeam().isEmpty()){
                    System.out.println(playerOne.getPlayerName() + " has no remaining Pokémon. " + playerTwo.getPlayerName() + " wins the battle!");
                    System.out.println("Good Game!");
                    isOver = true;
                    return;
                }else if (playerTwo.getTeam().isEmpty()) {
                    System.out.println(playerTwo.getPlayerName() + " has no remaining Pokémon. " + playerOne.getPlayerName() + " wins the battle!");
                    System.out.println("Good Game!");
                    isOver = true;
                    return;
                }
                
            }
            return;
            
            // Implement logic to switch to the next Pokémon or end the battle if all Pokémon have fainted
        }
    }
 

    private int getPlayerChoice() {
    	 Scanner scanner = new Scanner(System.in);
         while (!scanner.hasNextInt()) {
             System.out.println("Invalid input. Please enter a number.");
             scanner.next(); // Consume invalid input
         }
         int choice = scanner.nextInt();
         scanner.nextLine(); // Consume newline character
         return choice;
    }

    private boolean checkWinCondition() {
        // Check if any player has lost all Pokémon
        if (playerOne.getTeam().isEmpty()) {
            System.out.println(playerOne.getPlayerName() + " has no remaining Pokémon. " + playerTwo.getPlayerName() + " wins the battle!");
            System.out.println("Good Game!");
            return true;
        } else if (playerTwo.getTeam().isEmpty()) {
            System.out.println(playerTwo.getPlayerName() + " has no remaining Pokémon. " + playerOne.getPlayerName() + " wins the battle!");
            System.out.println("Good Game!");
            return true;
        }
        return false; // No win condition met
    }

    // Methods to execute turns and check win conditions
}
