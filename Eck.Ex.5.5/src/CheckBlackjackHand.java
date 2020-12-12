/** Eck Exercise 5.4
 * Program to test the BlackjackHand class (from Eck)
 * Pick a random number between 2 & 6
 * Deal that many cards and add them to the hand
 * Print out value computed for the hand: getBlackjackHandValue()
 * Repeat as long as the user wants to continue.
 * @author jd07
 *
 */

import textio.TextIO;

public class CheckBlackjackHand {
	/* 
	 * create deck object
	 * Ask user to play
	 * 	if Yes:
	 * 		randomise total number of cards (2-6)
	 * 			shuffle cards
	 * 			create blackjackhand object from deck
	 * 			deal card from deck
	 * 			add to hand
	 * 		print getBlackjackHandValue
	 * 	if no: exit	
	 */
	static Deck deck = new Deck(); // single deck for game
	
	public static void main(String[] args) {
		// shuffle deck
		do {
			System.out.println("Do you want a new hand?");
			if (TextIO.getBoolean()) {
				// play game
				playGame();
			} else {
				System.out.println("Thanks for playing");
				break;
			}
		} while (true);
	}
	
	static void playGame() {
		int numCards = (int)(Math.random()*5) + 2;
		int totalVal;
		deck.shuffle();
		BlackjackHand newHand = dealNewHand(numCards);
		totalVal = newHand.getBlackjackValue();
		System.out.printf("Your total from %d cards was %d\n",numCards,totalVal);
	} // play game
	
	static BlackjackHand dealNewHand(int numCards) {
		BlackjackHand newHand = new BlackjackHand();
		for (int i = 0; i <= numCards; i++) {
			Card c = new Card();
			c = deck.dealCard();
			newHand.addCard(c);
			System.out.println(c);
		} // end card deal
		return newHand;
	} // end dealNewHand
}
