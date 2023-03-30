package for_GameProject2;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
public class Spaceship extends Game{

	
	String[] words = {"frog", "sage", "blue", "bone", "cone", "lend", "pint", "luck", "seed", "foam", "dusk", "cave", "harp", "ruby", "soak", "tusk", "mend", "jolt", "quit", "vain", "haze", "bunk", "jade", "bald"};
	Random random = new Random();
	ArrayList<String> missedLetters = new ArrayList<String>(); // holds users incorrect guesses
	ArrayList<String> correctLetters = new ArrayList<String>(); // holds correct guesses
	Scanner scan = new Scanner(System.in);
	ArrayList<String> images = new ArrayList<String>(); //ASCII art
	int index = 0;
	String chosenWord = ""; //random answer word
	String guessedLetter = ""; 
	boolean won = false; //set to true if win 
	String guessedWord = ""; // all correct letters
	
	public Spaceship() {
		super();
		int randomIndex = random.nextInt(words.length); //chooses random word
		chosenWord = words[randomIndex];
		
		try {
			scan = new Scanner(new File("rockets.txt"));
			scan.useDelimiter(",");//catches exception for rocket
			while(scan.hasNext()) {
				String image = scan.next();
				images.add(image);
			}
				
		}catch(FileNotFoundException e) {
			e.getMessage();
		}
		
	}
	
	
	@Override
	public void rules() {
		System.out.println( "This is a better version of hangman! Given only the number of \n"
				+ "letters in a word, you must discover the word in 9 tries, \n"
				+ "one letter at a time. A spaceship shows your progress and \n"
				+ "when it reaches LIFTOFF you are out of guesses. Good luck!");
	}
	
	@Override
    public void setUp() {
		
	    System.out.println(images.get(index));
	    System.out.print("Missed letters: ");
	    if(missedLetters.isEmpty()) {
	        System.out.print("No missed letters yet.");
	    }else {
	        for (int i = 0; i < missedLetters.size(); i++ ) {
	            System.out.print(missedLetters.get(i) + " ");
	        }
	        System.out.println("");
	    }
	    
	    String[] hiddenWord = new String[chosenWord.length()];
	    for (int i = 0; i < chosenWord.length(); i++) {
	        if (correctLetters.contains(Character.toString(chosenWord.charAt(i)))) {
	            hiddenWord[i] = Character.toString(chosenWord.charAt(i));
	        } else {
	            hiddenWord[i] = "_";
	        }
	    }
	    System.out.println(String.join(" ", hiddenWord));

    System.out.println("\n Guess a letter: \n");

}
	



	@Override
    public boolean goodPlayerInput(String guess) {
		guess.toUpperCase();
		if (guess.length() != 1) {
			return false; 
		}else if (missedLetters.contains(guess)) {
			return false;
		}else if (correctLetters.contains(guess)) {
			return false; 
		}else if(!guess.matches("[a-zA-Z]")) {
			return false;
		}else {
			guessedLetter = guess;
			return true; 
		}
	
	}
	
	private boolean compareGuess() {
		for(int i = 0; i < chosenWord.length(); i++){
			if(!guessedWord.contains(Character.toString(chosenWord.charAt(i)))){
				return false;
			}
		}
		return true;
		}


	
	@Override
	public void checkWinOrLose() {
	    if(chosenWord.contains(guessedLetter)) {
	        correctLetters.add(guessedLetter);
	        guessedWord += guessedLetter;
	        if(compareGuess()) {
	            won = true;
	            System.out.println("You won! The word was " + chosenWord);
	        } else {
	            System.out.println("Correct!");
	        }
	    } else {
	        missedLetters.add(guessedLetter);
	        index++;
	        if(index == images.size()) {
	            System.out.println("The word was " + chosenWord);
	        } else {
	            System.out.println("No, that letter is not in the word.");
	        }
	    }
	}
	
	@Override
	public boolean canPlayAgain(){
		if(won) {
			return false;
		}else {
			return true;
		}
	}
}
