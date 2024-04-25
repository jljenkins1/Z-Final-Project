package test;

public class Battle {
	private Player playerOne;
	private Player playerTwo;
	private boolean isOver; //flag to indicate the battle is over
	
	public Battle(Player playerOne, Player playerTwo) {
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		this.isOver = false; 
	}
	public void startBattle() {
		// logic to conduct the battle
	}
	//methods to execute turns and check win conditions
}
