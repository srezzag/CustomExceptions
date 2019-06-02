
/*
 * @author Samy Rezzag
 * IT-214 Assignment 2 - Exercise 72036
 */

import java.util.Scanner;

/*
 * Rezzag_Assignment2_Exception is the driver class.
 * It contains a main method to start the application. It also contains 3 private classes to handle end of sentence exceptions.
 * These 3 classes are private because they are inner classes of Rezzag_Assignment2_Exception. Also, they are static because if they weren't,
 * we'd have to instantiate them in order to use 'throw'. Static nested classes are used so we can have them compile before the 
 * rest of the code and their functions will be readily available.
 */

public class Rezzag_Assignment2_Exception {

	/*
	 * Main method will instantiate variables and scanner to collect user input. It
	 * will take user input and determine if the sentence has valid punctuation.
	 */

	public static void main(String args[]) {

		/*
		 * I initialize sentence to "" intentionally to trigger the while loop. This
		 * will defer any blank inputs (just hitting enter when prompted). I do this
		 * because blank inputs will cause an out of bounds issue when assigning
		 * 'lastChar' a value. I used this approach because I like the one-liner and it
		 * prevents having to write lots of code to make a loop and create a data
		 * structure and sift through it myself.
		 */

		String sentence = "";
		char lastChar;
		Scanner input = new Scanner(System.in);

		while (sentence.isEmpty()) {
			System.out.print("Enter a sentence:");
			sentence = input.nextLine();
		}

		lastChar = sentence.charAt(sentence.length() - 1);
		input.close();

		/*
		 * Here I test if lastChar is a comma. If not, I make sure it's also not a
		 * period, exclamation or question mark. Anything that passes these 2 conditions
		 * will be a correct sense.
		 */

		if (lastChar == ',') {
			try {
				throw new CommaException("You can't end a sentence in a comma.");
			} catch (CommaException c) {
				c.printStackTrace();
			}
		} else if (lastChar != '!' && lastChar != '?' && lastChar != '.') {
			try {
				throw new PunctuationException("The sentence does not end correctly.");
			} catch (PunctuationException p) {
				p.printStackTrace();
			}
		} else {
			System.out.print("The sentence ends correctly.");
		}
	}

	/*
	 * Private static nested class. Private -- Because there are no outer-classes
	 * that need access to it. Static -- Because otherwise we'd have to create an
	 * inner class instance from within a non-static context.
	 */

	private static class CommaException extends PunctuationException {

		public CommaException(String string) {
			super(string);
		}
	}

	/*
	 * Private static nested class. Private -- Because there are no outer-classes
	 * that need access to it. Static -- Because otherwise we'd have to create an
	 * inner class instance from within a non-static context.
	 */

	private static class PunctuationException extends EndOfSentenceException {

		public PunctuationException(String string) {
			super(string);
		}

	}

	/*
	 * Private static nested class. Private -- Because there are no outer-classes
	 * that need access to it. Static -- Because otherwise we'd have to create an
	 * inner class instance from within a non-static context.
	 */

	private static class EndOfSentenceException extends Exception {

		String str;

		public EndOfSentenceException(String string) {
			System.out.print(string);
		}
	}
}