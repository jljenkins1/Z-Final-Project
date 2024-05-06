package test;
import java.io.InputStream;
import java.util.Scanner;
public class main {
    public static void main(String[] args) throws InterruptedException {

    	System.out.println("Welcome to the Pokemon Fighting simlulator! We have 20 Pokemon for you and another trainer to practice battling with!");
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
