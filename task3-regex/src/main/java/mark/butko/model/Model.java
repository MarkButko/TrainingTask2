package mark.butko.model;


import java.util.ArrayList;

public class Model {

	private ArrayList<Integer> history = new ArrayList<Integer>();
	private int min = 0;
	private int max = 100;
	private int secretNumber = rand(min, max);

	public boolean addNewGuess(int guess) {
		history.add(guess);
		if (guess < secretNumber) {
			min = guess;
		} else {
			max = guess;
		}
		return guess == secretNumber;
	}

	public boolean isInRange(int guess) {
		return guess > min && guess < max;
	}

	public int rand(int min, int max) {
		return min + (int) Math.ceil(Math.random() * (max - min - 1));
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMin() {
		return this.min;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMax() {
		return this.max;
	}

	public ArrayList<Integer> getHistory() {
		return history;
	}

	public int getSecretNumber() {
		return secretNumber;
	}
}
