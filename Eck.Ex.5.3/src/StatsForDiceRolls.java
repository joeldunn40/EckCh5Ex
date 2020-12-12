/** Eck Exercise 5.3
 * Counts how many rolls until particular sum of dice occurs
 * Repeats 10,000 times
 * Displays mean, sd & max number of rolls for each possible sum
 * Uses StatCalc (from Eck)
 * Uses PairOfDicePrivate (by Joel Eck.Ex.5.1)
 * @author jd07
 *
 */
public class StatsForDiceRolls {
	public static void main(String[] args) {
		PairOfDicePrivate dice = new PairOfDicePrivate();
		StatCalcWithMax calc;
		int rpt = 1_000_000; // number of repeats
		
		// Loop over each dice sum
		for (int id = 2; id < 13; id++) {
			calc = new StatCalcWithMax();
			// Loop over repeats
			for (int ir = 0; ir < rpt; ir++) {
				int sumDie;
				int rolls = 0;
				do {
					dice.roll();
					rolls++;
					sumDie = dice.getDie1() + dice.getDie2();
				} while( sumDie != id); // until sumDie = target sum
				calc.enter((double)rolls);
			} // end for ir
			System.out.printf("SUM %2d:",id); // dice sum
			System.out.printf("\tMEAN %3.1f:",calc.getMean()); // mean rolls
			System.out.printf("\tSD %3.1f: ",calc.getStandardDeviation()); // sd rolls
			System.out.printf("\tUSD %3.1f: ",calc.getUnbiasedSD()); // sd rolls
			System.out.printf("\tMAX %4d.\n",calc.getMax()); // max rolls
		} // end for id
		
	} // end main
}//end StatsForDiceRolls

/** 
 * New class for stats that includes max as integer
 */
class StatCalcWithMax extends StatCalc {
	private int max = Integer.MIN_VALUE;
	
	public void enter(double num) {
		super.enter(num);
		if ((int)num > max) 
			max = (int)num;
	} // end enter

	public int getMax() {
		return max;
	} // end getMax
	
	public double getUnbiasedSD() {
		return super.getStandardDeviation()*Math.sqrt(super.getCount()/(super.getCount()-1.0));
	}
}// end StatCalcWithMax

