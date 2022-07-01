// Harsh Gandhi 
// This is the battle class which gives user the option of picking between: Giant, Vampires or Wrewolves. When they pick two monsters, it starts the battle between them and after it is done, user is again asked if they want to generate another battle or quit. 

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Battle {
	// this is the main method of the battle mode and it welcome the user and it
	// tells user the options that they can pick from.
	// Than it reads the monster from user and it starts the battle.
	public static void battleMode(Scanner whichMonster) {
		System.out.println("Welcome to Battle Mode!!");
		System.out.println(
				"There are three monsters, Giant, Vampires, and Werewolves. You can pick two monsters to battle. Which one do you want to pick?");
		Monster monster = promptForMonster(whichMonster);
		Monster monster2 = promptForMonster(whichMonster);
		fight(monster, monster2);
	}

	// this is the method that tells the user if the input that they provided are
	// valid or not.
	public static Monster promptForMonster(Scanner whichMonster) {
		Monster monster = null;
		boolean success = false;
		while (!success) {
			String file = whichMonster.nextLine();

			monster = readMonster("text/" + file);

			if (monster == null) {
				System.out.println("File not found");
			} else
				success = true;
			readMonster(file);
		}
		return monster;
	}

	// this reads the monster and initialize the properties of monster to name2,
	// health 2, and strength.
	public static Monster readMonster(String filepath) {
		try (Scanner fileInput = new Scanner(new File(filepath))) {

			String name2 = fileInput.nextLine();
			double health2 = fileInput.nextDouble();
			double strngth2 = fileInput.nextDouble();

			Monster r = new Monster(name2, health2, strngth2);
			return r;

		} catch (FileNotFoundException e) {
			return null;
		}
	}

	// this is the fight method that produce the fight in two monster and it runs
	// the while loop until one of the monster health is less than 0.
	public static void fight(Monster monster, Monster monster2) {
		System.out.println("Now the fight begins!");
		System.out.println("The name of monster is " + monster.getName() + ". The health is " + monster.getHealth()
				+ ". The strength is " + monster.getStrength());
		System.out.println("The name of monster is " + monster2.getName() + ". The health is " + monster2.getHealth()
				+ ". The strength is " + monster2.getStrength());

		int i = 1;

		int round = 0;

		while (monster.getHealth() > 0 && monster2.getHealth() > 0) {
			round = round + 1;
			System.out.println();
			System.out.println("Time for round " + round);
			double attack2 = monster2.attack();
			monster.takeDamage(attack2);
			
			System.out.printf("%s has gotten damage of  %.2f \n", monster.getName(), attack2);
			System.out.printf(monster.getName() + " has been attacked by " + monster2.getName()
					+ " so now the health of " + monster.getName() + " is %.2f", monster.getHealth());			
			System.out.println();
			double attack3 = monster.attack();
			monster2.takeDamage(attack3);
			
			System.out.printf( "%s has gotten damage of  %.2f \n", monster2.getName(), attack3);
			System.out.printf(monster2.getName() + " has been attacked by " + monster.getName()
					+ " so now the health of " + monster2.getName() + " is %.2f", monster2.getHealth());
			System.out.println();
			if (monster.getHealth() < 0) {
				System.out.println(monster.getName() + " died");
				System.out.println("So the winner is " + monster2.getName());
				monster.toString();
			} else if (monster2.getHealth() < 0) {
				System.out.println(monster2.getName() + " died");
				System.out.println("So the winner is " + monster.getName());
			}

		}

	}

}
