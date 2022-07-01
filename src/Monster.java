// Harsh Gandhi
// This is the Monster class which has constructors and getters and setters method. It initializes the monsters and I can access information about monster by calling one of the methods. It also has isAlive method which shows if monster is alive and it has toString method. 

import java.util.Random;

public class Monster {

	// TODO Auto-generated method stub
	private String name;
	private double health;
	private double strength;

	// this is the default constructor of monster where the name string is empty,
	// and health and strength is 0.
	public Monster() {
		this.name = "";
		this.health = 0;
		this.strength = 0;
	}

	// This is my constructor for the monster where it initializes name, health, and
	// strength
	public Monster(String name, double health, double strength) {
		this.name = name;
		this.health = health;
		this.strength = strength;

		// scanner fileInput = new Scanner(new File("input file"))
	}

	// this is the get name method which I can use to get the name of monster in
	// different class.
	public String getName() {
		return name;
	}

	// this is the set name method which sets the name of the monsters.
	public void setName(String name) {
		this.name = name;
	}

	// this is the get health method which I can use to get the health of monster in
	// different class.
	public double getHealth() {
		return health;
	}

	// this is the set health method which sets the health of the monsters.
	public void setHealth(double health) {
		this.health = health;
	}

	// this is the get get method which I can use to get the strength of monster in
	// different class.
	public double getStrength() {
		return strength;
	}

	// this is the set strength method which sets the strength of the monsters.
	public void setStrength(double strength) {
		this.strength = strength;
	}

	// this si the take damage method which subtractes the health by the amount of
	// damage.
	public void takeDamage(double damage) {
		health = health - damage;
	}

	// this is the attack method which attacks the monster by providing random
	// number between 0 and th amount of strength.
	public double attack() {
		Random rand = new Random(); // instance of random class
		double upperbound = strength;
		return (rand.nextDouble() * strength);
	}

	// this is the isAlive method which returns false when health is less than 0 and
	// true when health is more than 0.
	public boolean isAlive() {
		if (health > 0) {
			return true;
		} else {
			return false;
		}

	}

	// this is the toString method which returns the final output to the user.
	public String toString() {
		String result = name + " (health: " + String.format("%.2f", health) + ", strength: "
				+ String.format("%.2f", strength) + ")";
		return result;
	}

}
