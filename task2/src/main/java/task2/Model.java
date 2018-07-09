package task2;

import java.util.ArrayList;

public class Model {

	private ArrayList<Integer> history = new ArrayList<Integer>();
	private int min = 0;
	private int max = 100;
	private int secretNumber = rand(min, max);

	public boolean addNewGuess(int guess) {
		history.add(guess);
		return guess == secretNumber;
	}

	public boolean isInRange(int guess) {
		return guess > min && guess < max;
	}

	public int rand(int min, int max) {
		return min + (int) (Math.random() * (max - min + 1));
	}

	public void setMin(int min) {
		this.min = min;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public ArrayList<Integer> getHistory() {
		return history;
	}

	public int getSecretNumber() {
		return secretNumber;
	}
}
