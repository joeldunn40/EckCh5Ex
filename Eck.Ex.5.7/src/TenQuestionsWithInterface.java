/** Eck Exercise 5.7
 * TenQuestions with different question types from interface
 */
import textio.TextIO;

public class TenQuestionsWithInterface {
	private static IntQuestion[] qs;
	private static int[] userAs;
	
	public static void main(String[] args) {
		create();
		administer();
		grade();
	} // end main

	// Anonymous Class for a new type of questions
	IntQuestion bigQuestion = new IntQuestion() {
	    public String getQuestion() {
	        return "What is the answer to the ultimate question " +
	                 " of life, the universe, and everything?";
	    }
	    public int getCorrectAnswer() {
	        return 42;
	    }
	};
	
	/**
	 * create question array
	 */
	static void create() {
		qs = new IntQuestion[7];
		for (int i = 0; i < 3; i++) {
			qs[i] = new AdditionQuestion();
		} // end for
		for (int i = 3; i < 6; i++) {
			qs[i] = new SubtractionQuestion();
		} // end for
		qs[6] = new IntQuestion() {
		    public String getQuestion() {
		        return "What is the answer to the ultimate question " +
		                 " of life, the universe, and everything?";
		    }
		    public int getCorrectAnswer() {
		        return 42;
		    }
		};
	} // end create
	
	/** 
	 * Ask questions & get answers
	 */
	static void administer() {
		userAs = new int[qs.length];
		for (int i = 0; i < qs.length; i++) {
			System.out.println(qs[i].getQuestion());
			userAs[i] = TextIO.getlnInt();
		}
	} // end administer
	
	/** 
	 */
	static void grade() {
		int score = 0;
		String mark;
		for (int i = 0; i < qs.length; i++) {
			mark = "Wrong!";
			if (qs[i].getCorrectAnswer() == userAs[i]) {
				mark = "Correct!";
				score++;
			} // end if (increment score & correct mark)
			System.out.printf("Question %d: You said: %d: Correct answer was %d: You were %s.\n",
					i+1,userAs[i],qs[i].getCorrectAnswer(),mark);
		} // end for each question
		System.out.println("Final score = " + score + 
				" out of " + qs.length);
	} // end grade

}
