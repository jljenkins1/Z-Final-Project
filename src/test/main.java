package test;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
    	 Scanner scanner = new Scanner(System.in);
         System.out.println("Enter the directory of the .json file:");
         String filePath = scanner.nextLine();
    	
    	// Create player one
        Player playerOne = new Player();
        System.out.println("Player One's team:");
        playerOne.printTeamDetails();

        // Create player two
        Player playerTwo = new Player();
        System.out.println("Player Two's team:");
        playerTwo.printTeamDetails();

        // Initiate a battle between player one and player two
        Battle battle = new Battle(playerOne, playerTwo);
        battle.startBattle();

    }
}
