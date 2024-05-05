package test;

public class main {
    public static void main(String[] args) {
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
