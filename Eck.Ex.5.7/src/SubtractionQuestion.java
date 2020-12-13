/** Eck Exercise 5.7
 * Uses interface to create subtractionquestion
 * @author jd07
 *
 */
public class SubtractionQuestion implements IntQuestion {

    private int a, b;  // The numbers in the problem.

    public SubtractionQuestion() { // constructor
        a = (int)(Math.random() * 50 + 1);
        b = (int)(Math.random() * 50);
        if (b>a) { // swap so a always >= b in question
        	int temp = b;
        	b = a;
        	a = temp;
        }// end if
    }

    public String getQuestion() {
        return "What is " + a + " - " + b + " ?";
    }

    public int getCorrectAnswer() {
        return a - b;
    }


}
