package test;

public class Pokemon {
	private String name;
	private Type type;
	private int maxHP;
	private int currentHP;
	private List<Move> moves;
	
	public Pokemon(String name, Type type, int maxHP, int, List<Move> moves) {
		this.name = name;
		this.type = type;
		this.maxHP = maxHP;
		this.currentHP = maxHP;
		this.moves = new ArrayList<>(moves);
	}
	
	// getters and setters
	
	public void recieveDamage(int damage) {
		this.currentHP -= damage;
		if (this.currentHP < 0)this.currentHP = 0;
	}
	
	//other methods
}
