package for_GameProject2;

import java.util.Random;


public class ChoHan extends Game {

	Random random = new Random();
	int money = 2;
	int sum = 0; 
	int dice1 = 0;
	int dice2 = 0;
	String answer = "";
	String evenOrOdd = "";

	
	
	public ChoHan() {
		super();

        if(sum % 2 == 0) {
            answer = "CHO";
        }else
            answer = "HAN";
	}
	
	@Override
	public void rules() {
		System.out.println( "Cho-Han is a traditional Japanese guessing game.\n"
				+ "A dealer rolls two 6-sided die, and you must guess\n"
				+ "if their sum is CHO (even) or HAN (odd).\n"
				+ "You start with $2. A wrong answer loses you $1 and \n"
				+ "a right answer wins $1. You must stop playing at $0\n"
				+ "Good luck!\n\n");
	}

	@Override
	public void setUp() {
		dice1 = random.nextInt(5) + 1;
		dice2 = random.nextInt(5) + 1;
		sum = dice1 + dice2;
		System.out.println("The dealer swirls the cup and you hear the dice rattle\n"
							+ "The dealer slams the cup on the floor, covering the dice\n"
							+ "and asks for your bet.\n\n    CHO (even) or HAN (odd)");

	}
	
	@Override
	public boolean goodPlayerInput(String guess) {

		if(guess.toUpperCase().equals("CHO") || guess.toUpperCase().equals("HAN")){
			evenOrOdd = guess;
			return true;
		}else
			return false;
	}
	// edit
	

	@Override
	public void checkWinOrLose() {
		System.out.println("The dealer lifts his cup to reveal:\n"
				+ dice1 + " - " + dice2 + "\n"
				+ "The correct answer is: " + answer);
		if(evenOrOdd.equalsIgnoreCase(answer)) {
			System.out.println("You won!");
			money++;
		}else {
			System.out.println("You lost!");	
			money--;
		}
		System.out.println("You started with $2, and now you have $" + money );
		// TODO Auto-generated method stub
	}

	@Override
	public boolean canPlayAgain() {
		if(money > 0) {
			return true;
		}else {
			System.out.println("Your game is done. GG!");
		}
		return false;
	}

}
