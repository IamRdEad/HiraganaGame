import java.util.Random;
import javax.swing.JOptionPane;

public class Game {
	private String[] letters = {"a", "i", "u", "e", "o", "ka", "ki",
								"ku", "ke", "ko"};
	private int total;
	private int mistakes;
	private int currentLetter;
	
	public Game() {
		this.total = 0;
		this.mistakes = 0;
		JOptionPane.showMessageDialog(null, "Good luck - がんばって");
	}
	
	public String getLetterPath() {
		total++;
		String st = "letters/";
		Random rnd = new Random();
		int num = rnd.nextInt(0, 10);
		st += letters[num] + ".png";
		currentLetter = num;
		return st;
	}

	public void checkLetter(String guess) {
		if(!guess.equals(letters[currentLetter])) {
			mistakes++; 
			JOptionPane.showMessageDialog(null, "Your answer is wrong this is letter: " + letters[currentLetter]);
		}
	}

	public void endGame() {
		total--;
		double percent = mistakes == 0? 100 : 100-(double)mistakes/total*100;
		String st = "Number of letters in total: " + total
					+ "\nNumber of mistakes: " + mistakes
					+ "\nIn total: " + percent + "%";
		JOptionPane.showMessageDialog(null, st);
	}

}
