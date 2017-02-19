package cards;

import java.util.*;

public class Player {
	Scanner kb = new Scanner(System.in);

	public void hand(List<Card> deck, int playerHand, int dealerHand, Card dealerCard2) {
		Dealer dealer = new Dealer();
		System.out.println("The value of your hand is currently : " + playerHand);
		System.out.println("Would you like to (H)it or (S)tay? ");
		String choice = kb.next();
		while ((choice.equals("H")) || (choice.equals("h"))) {
			Card card3 = hit(deck);
			System.out.print("your new card is : " + card3);
			System.out.println("");
			playerHand += card3.getValue();
			if (playerHand > 21) {
				System.out.println("Game Over, YOU BUSTED!!!!!!");
				System.exit(0);
			} else if (playerHand == 21) {
				System.out.println("Great Job, you win, 21!!!!!");
				System.exit(0);
			} else {
				System.out.print("Your total is now : " + playerHand + "\n" + "would you like to (H)it or (S)tay? ");
				choice = kb.next();
			}
		}
		System.out.println("The final value of your hand is : " + playerHand);
		dealer.dealerPlay(deck, playerHand, dealerHand, dealerCard2);

	}

	public Card hit(List<Card> deck) {
		Card card3 = deck.remove(0);
		return card3;
	}

	public void playAgain() {
		BlackJack jack = new BlackJack();
		System.out.print( "Would you like to play again(Y or N)? ");
		String answer = kb.next();
		if ((answer.equals("Y")) || (answer.equals("y"))) {
			jack.start();

		}
	}
}
