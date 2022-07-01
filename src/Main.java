// Harsh Gandhi
// This is the main class which starts the project and gives user option for battle or quit. If they pick battle, than it goes to battle class. 
import java.util.Scanner;

public class Main {

	// this is the main method for the program where it keeps the program going
	// until the user enters quit. It gives user option between Battle and Quit.
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.println("Hello and Welcome to Monster Battle");
		System.out.println("You have two options: Battle or Quit");

		while (true) {
			String question = input.nextLine();
			if (question.toLowerCase().equals("battle")) {
				Battle.battleMode(input);

			} else if (question.toLowerCase().equals("quit")) {
				System.out.println("Good Bye!");
				System.exit(1);
			} else {
				System.out.println("Error! Try again");
			}

		}

	}
}
