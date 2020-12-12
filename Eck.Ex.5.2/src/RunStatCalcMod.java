/** Eck Exercise 5.2
 * Program to test StatCalcMod
 * Asks user to input numbers one at a time.
 * Prints out statistics
 * @author jd07
 *
 */

import textio.TextIO;

public class RunStatCalcMod {
	public static void main(String[] args) {
		
		// use modified class
//		StatCalcMod calc;
//		calc = new StatCalcMod();

		// use extended class
		StatCalcWithMax calc;
		calc = new StatCalcWithMax();

		// use extended class - try adding new java file?
//		StatCalcWithMinMax calc;
//		calc = new StatCalcWithMinMax();

		double num; 
		System.out.println("Start entering numbers (0 to finish)");
		do {
			num = TextIO.getlnDouble();
			if (num != 0.0) {
				calc.enter(num);
			} else
				break;
		} while(true); // end do-while
		System.out.println("Max = " + calc.getMax());
		System.out.println("Min = " + calc.getMin());
		System.out.println("Mean = " + calc.getMean());
		System.out.println("Count = " + calc.getCount());
		System.out.println("Sum = " + calc.getSum());
		System.out.println("SD = " + calc.getStandardDeviation());
	} // end main
	
}

class StatCalcWithMax extends StatCalc {
    private double max = Double.NEGATIVE_INFINITY; // Added by Joel
    private double min = Double.POSITIVE_INFINITY; // Added by Joel

    /**
     * adds to StatCalc.enter
     */
    public void enter(double num) {
		super.enter(num); // call StatCalc.enter()
        if (num > max)
        	max = num;
        if (num < min)
        	min = num;
    }
    public double getMax() {
    	return max;
    }
    public double getMin() {
    	return min;
    }

} // end class StatCalcWithMax

// Eck's code
class StatCalcWithMinMax extends StatCalc {

	   private double max = Double.NEGATIVE_INFINITY;  // Largest item seen.
	   private double min = Double.POSITIVE_INFINITY;  // Smallest item seen.

	   public void enter(double num) {
	      super.enter(num);  // Call the enter method from the StatCalc class.
	      if (num > max)  // Then do the extra processing for min and max.
	         max = num;
	      if (num < min)
	         min = num;
	   }
	 
	   public double getMin() {
	      return min;
	   }
	   
	   public double getMax() {
	      return max;
	   }

	}  // end class StatCalcWithMinMax
