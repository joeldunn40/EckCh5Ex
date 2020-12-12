/** Eck Exercise 5.6
 * Ask the user 10 simple addition questions.
 * Print out the questions with user's answers & whether Correct or Wrong.
 * Adapted from Ex 4.8, to use AdditionQuestion Class
 *  @author Joel
 *
 */

import textio.TextIO;

public class TenAdditionQuestionsPar {
	static final int numQs = 3;
	private static AdditionQuestion[] qs;
	private static int[] userAs;
	
	public static void main(String[] args) {
		create();
		administer();
		grade();
	} // end main

	/**
	 * create question array
	 */
	static void create() {
		qs = new AdditionQuestion[10];
		for (int i = 0; i < numQs; i++) {
			qs[i] = new AdditionQuestion();
		} // end for
	} // end create
	
	/** 
	 * Ask questions & get answers
	 */
	static void administer() {
		userAs = new int[10];
		for (int i = 0; i < numQs; i++) {
			System.out.println(qs[i].getQuestion());
			userAs[i] = TextIO.getlnInt();
		}
	} // end administer
	
	/** 
	 */
	static void grade() {
		int score = 0;
		String mark;
		for (int i = 0; i < numQs; i++) {
			mark = "Wrong!";
			if (qs[i].getCorrectAnswer() == userAs[i]) {
				mark = "Correct!";
				score++;
			} // end if (increment score & correct mark)
			System.out.printf("Question %d: You said: %d: Correct answer was %d: You were %s.\n",
					i,userAs[i],qs[i].getCorrectAnswer(),mark);
		} // end for each question
		System.out.println("Final score = " + score + 
				" out of " + numQs);
	} // end grade
}
