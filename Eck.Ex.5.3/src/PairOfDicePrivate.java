/** Eck Exercise 5.1
 * Class based on Eck's PairOfDice but with private die1
 * and die2 variables and related getter methods
 * @author jd07
 *
 */
public class PairOfDicePrivate {
    private int die1;   // Number showing on the first die.
    private int die2;   // Number showing on the second die.

    public PairOfDicePrivate() {
            // Constructor.  Rolls the dice, so that they initially
            // show some random values.
        roll();  // Call the roll() method to roll the dice.
    }

    public PairOfDicePrivate(int val1, int val2) {
            // Constructor.  Creates a pair of dice that
            // are initially showing the values val1 and val2.
        die1 = val1;  // Assign specified values 
        die2 = val2;  //            to the instance variables.
    }

    // getter to return value of die1
    public int getDie1() {
    	return die1;
    }
    
    // getter to return value of die2
    public int getDie2() {
    	return die2;
    }

    public String toString() {
    	return "Values of dice 1 and 2 are: " +
    			die1 + " and " + die2;
    }
    
    public void roll() {
            // Roll the dice by setting each of the dice to be
            // a random number between 1 and 6.
        die1 = (int)(Math.random()*6) + 1;
        die2 = (int)(Math.random()*6) + 1;
    }


} // end of PairOfDicePrivate
