
/** Eck Exercise 5.5
 * Program to play blackjack against dealer
 * Two cards each
 * If dealer is 21, dealer wins
 * Else 
 * 	player can choose to "hit": add card
 * 		or "stand": move to dealer's turn 
 * 	if player > 21: "bust", dealer wins
 * Dealer's turn:
 * 	If <= 16 must add card
 * 	If dealer < player: must add card 
 * 	If > 21 player wins
 * 	If dealer >= player (& under 21) dealer wins
 * Part B: add bets from $100
 * @author jd07
 *
 */

import textio.TextIO;

public class BlackjackVsDealer {
	static Deck deck = new Deck(); // single deck for game
	static double pot = 100.00;
	static double bet;
	
	public static void main(String[] args) {
		boolean playerWin;
		do {
			System.out.println("Do you want to play a new round?");
			if (TextIO.getBoolean()) {
				// play game
				playerWin = playGame();
				if (playerWin) {
					System.out.println("Congratulations: Player Won!");
					pot+=bet;
				} else
					System.out.println("Dealer won - better luck next time...");
					pot-=bet;
			} else {
				System.out.println("Thanks for playing");
				System.out.printf("You have $%.2f.",pot);
				break;
			}
		} while (true);
	}
	
	/** 
	 * sets up game with shuffled pack
	 * create hand for dealer (add two cards)
	 * create hand for player
	 * 	add two cards
	 * 	show cards
	 * 	do you want to hit?
	 * 		deal new card
	 * 		add new card
	 * 		show new card
	 * 		calculate value
	 * 		check if bust -> you lose
	 * 
	 */
	static boolean playGame() {
		deck.shuffle();
		BlackjackHand dealer = new BlackjackHand();
		BlackjackHand player = new BlackjackHand();
		
		// initial two card deal
		System.out.println("Dealing cards...");
		dealer = dealNewHand(2,false);
		System.out.println("Player has:");
		player = dealNewHand(2,true);
		System.out.println("Player has total card value: " + player.getBlackjackValue());
		
		System.out.printf("You have $%.2f. How much do you want to bet",pot);
		bet = TextIO.getlnDouble();
		
		if (player.getBlackjackValue() == 21) {
			// move straight to dealer
		} else {
			// ask for more cards
			do {
				System.out.println("Do you want to hit?");
				boolean hit = TextIO.getBoolean();
				if (hit) {
					hitMe(player); // subroutine to add cards
					System.out.println("Player now has total card value: " + player.getBlackjackValue());
					if (player.getBlackjackValue() > 21) {
						System.out.println("You went bust!");
						return false; // dealer won!
					} // end if hit
				} else 
					break;	// "stand": move on to dealer
			} while(player.getCardCount()<6); // player keeps adding cards to a max of 6 cards
		} // end if
		System.out.println("Player is standing with total card value: " + player.getBlackjackValue());
		
		// dealer's turn
		// reveal cards
		System.out.println("Dealer's turn:");
		System.out.println(dealer.getCard(0));
		System.out.println(dealer.getCard(1));
		// check initial hand
		if (dealer.getBlackjackValue() >= player.getBlackjackValue()) {
			System.out.println("Dealer's cards total: " + dealer.getBlackjackValue());
			return false; // dealer win immediately
		} else {
			do {
			// deal new cards to rule
			hitMe(dealer); // add cards
			} while( (dealer.getBlackjackValue() < player.getBlackjackValue()) && 
					dealer.getBlackjackValue()<21 && 
					dealer.getCardCount()<6 );
			// all possible cards dealt
			System.out.println("Dealer's cards total: " + dealer.getBlackjackValue());
			if (dealer.getBlackjackValue() > 21 || (dealer.getBlackjackValue() < player.getBlackjackValue()) ) {
				return true; // player wins!
			} else
				return false; //dealer wins!
		} // end if (dealer's turn)
	} //  end play game
	
	/**
	 * Deal new cards to new hand
	 * Precondition: numCards is an int (number of cards to deal); show is a boolean on whether to print cards to screen 
	 * Postcondition: subroutune returns a blackjackhand object with numCards of cards. If show is true, then new hand 
	 * will be displayed.
	 * @param numCards number of cards to deal (integer).
	 * @param show print the card value to the screen
	 * @return new BlackjackHand
	 */
	static BlackjackHand dealNewHand(int numCards, boolean show) {
		BlackjackHand newHand = new BlackjackHand();
		for (int i = 0; i < numCards; i++) {
			Card c = new Card();
			c = deck.dealCard();
			newHand.addCard(c);
			if (show)
				System.out.println(c);
		} // end card deal
		return newHand;
	} // end dealNewHand
	
	/**
	 * Precondition: blackjackhand already exists and has been dealt.
	 * Postcondition: Adds new card to hand, prints out card. 
	 * @param hand dealt blackjackhand
	 */
	static void hitMe(BlackjackHand hand) {
		Card c = new Card();
		c = deck.dealCard();
		hand.addCard(c);
		System.out.println(c);
	}
}
