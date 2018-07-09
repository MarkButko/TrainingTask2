package task2;

public class View {

	public static final String EQUALS_STRING = "=";
	public static final String SPACE_STRING = " ";
	public static final String DASH_STRING = "-";

	public static final String GREETING = "Hello. Try to guess number.";
	public static final String NEW_RANGE = "Range: ";
	public static final String LESS = "Our number is less.";
	public static final String GREATER = "Our number is greater";
	public static final String WRONG = "Wrong input! Type number in range.";
	public static final String HISTORY = "History of guesses: ";
	public static final String CONGRATULATION = "Congratulation!";

	public void printlnMessage(String message) {
		System.out.println(message);
	}

	public void printlnRange(int min, int max) {
		System.out.println(View.NEW_RANGE + min + View.DASH_STRING + max);
	}
}
