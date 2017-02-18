package cards;

import java.util.*;

public class Player {
	Scanner kb = new Scanner(System.in);

	public int hand(List<Card> deck, int playerHand) {
		System.out.println("The value of your hand is currently : " + playerHand);
		System.out.println("Would you like to (H)it or (S)tay? ");
		String choice = kb.next();

		if (choice.equals("H")) {
			Dealer dealer = new Dealer();
			Card card3 = dealer.hit(deck);
			System.out.print("your new card is : " + card3);
			System.out.println("");
			playerHand += card3.getValue();
			if (playerHand > 21) {
				System.out.println("Game Over, YOU BUSTED!!!!!!");
				System.exit(0);
			} else if (playerHand == 21) {
				System.out.println("Great Job, you win, 21!!!!!");
				System.exit(0);
			}
		}
		return playerHand;
	}

}
