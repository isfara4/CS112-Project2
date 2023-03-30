package for_GameProject2;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Game g = null;
		String guess; 
		boolean startPlay = true;
		boolean loop = true;
		Scanner scan = new Scanner(System.in);
		
		while(startPlay) {
			System.out.println("Welcome to the CS112 Gaming System:");
			System.out.println("Enter 1 to play Spaceship");
			System.out.println("Enter 2 to play Cho-Han");
			System.out.println("Or enter QUIT at any time to end the game.");
	        
		try {
			String menuChoice = scan.next();
			if(menuChoice.equals("1")){
				g = new Spaceship();
			}else if(menuChoice.equals("2")){
				g = new ChoHan();
			}else if(menuChoice.equalsIgnoreCase("QUIT")){
				System.out.println("Exiting the program...");
				System.exit(0);
				 // some error handling regarding menuChoice
			}else {
				System.out.println("Please enter 1 or 2.");
				continue;
			}
			startPlay = false;
		}catch(NumberFormatException e) {
			System.out.println("Please enter a valid input");
		}
		}
	
		g.rules();
		while(loop) {
			g.setUp();
			guess = scan.next();
			if(guess.equalsIgnoreCase("quit")) {
				System.out.println("Exiting the program...");
				System.exit(0);	
			}
			while(!g.goodPlayerInput(guess)) {
				System.out.println("Sorry, bad input. Please try again.");
				guess = scan.next();	
			}
			g.checkWinOrLose();
			if(!g.canPlayAgain()) {
				loop = false;
				}
			}
		}

	}
