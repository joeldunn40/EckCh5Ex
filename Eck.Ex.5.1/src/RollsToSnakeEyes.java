/** Eck Exercise 5.1
 * Program to test PairOfDicePrivate
 * Counts number of rolls until snakes eyes
 * @author jd07
 *
 */
public class RollsToSnakeEyes {
	
	
	public static void main(String[] args) {
		int die1, die2;
		int rolls = 0;
		
		// test initial contructor
		PairOfDicePrivate dice = new PairOfDicePrivate(2,5);
		
		// test dice value getters
		die1 = dice.getDie1();
		die2 = dice.getDie2();
		
		// test toString method
		System.out.println("Dice: " + die1 + " " + die2);
		System.out.println(dice);
		
		// Count rolls to snake eyes
		do {
			rolls++;
			dice.roll();			
			System.out.printf("%3d: ", rolls);
			System.out.println(dice);
		} while( (dice.getDie1() + dice.getDie2() ) != 2 );   
		// end do
			
		System.out.println("Took " + rolls + " rolls");
	} // end main
}
