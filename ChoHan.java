package for_GameProject2;

import java.util.Random;


public class ChoHan extends Game {

	Random random = new Random();
	int money = 2;
	int sum; 
	int dice1;
	int dice2;
	String answer;
	String evenOrOdd = "";

	
	
	public ChoHan() {
		super();
		dice1 = random.nextInt(5) + 1;
		dice2 = random.nextInt(5) + 1;
		sum = dice1 + dice2;
        if(sum % 2 == 0) {
            answer = "CHO";
        }else
            answer = "HAN";
	}
	
	@Override
	public String rules() {
		// TODO Auto-generated method stub
		return "Cho-Han is a traditional Japanese guessing game.\n"
				+ "A dealer rolls two 6-sided die, and you must guess\n"
				+ "if thier sum is CHO (even) or HAN (odd).\n"
				+ "You start with $2. A wrong answer loses you $1 and \n"
				+ "a right answer wins $1. You must stop playing at $0\n"
				+ "Good luck!\n\n";
	}

	@Override
	public void setUp() {
		System.out.println("The dealer swirls the cup and you hear the dice rattle\n"
							+ "The dealer slams the cup on the floor, covering the dice\n"
							+ "and asks for your bet.\n\n    CHO (even) or HAN (odd)");

	}
	
	@Override
	public boolean goodPlayerInput(String guess) {

		if(guess.toUpperCase().equals("CHO") || guess.toUpperCase().equals("HAN")){
			guess = evenOrOdd;
			return true;
		}else if(guess.equalsIgnoreCase("quit")) {
		return true;
		}
		return false;	// edit
	}

	@Override
	public void checkWinOrLose() {
		System.out.println("The dealer lifts his cup to reveal:\n"
				+ dice1 + " - " + dice2 + "\n"
				+ "The correct answer is: " + answer);
		if(evenOrOdd.toUpperCase().equals(answer)) {
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
