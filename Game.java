package for_GameProject2;

public abstract class Game {

	public abstract void rules();
    public abstract void setUp();
    public abstract boolean goodPlayerInput(String guess);
    public abstract void checkWinOrLose();
    public abstract boolean canPlayAgain();
	}

