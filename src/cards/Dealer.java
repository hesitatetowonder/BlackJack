package cards;

import java.util.*;

public class Dealer {
	Player p1 = new Player();
	int playerHand, dealerHand, newHand;
	Card card1, card2, dealerCard1, dealerCard2;

	public void shuffleUpAndDealPlayer(List<Card> deck) {
		Collections.shuffle(deck);
		card1 = deck.remove(0);
		card2 = deck.remove(0);
		System.out.print("You have been dealt : " + card1 + " and " + card2);
		System.out.println("");

		playerHand = (card1.getValue() + card2.getValue());
		if (playerHand == 21) {
			System.out.println("BLACKJACK!!!!!! You win!!!");
			p1.playAgain();
		}
		shuffleUpAndDealDealer(deck, playerHand);
	}

	public void shuffleUpAndDealDealer(List<Card> deck, int playerHand) {
		dealerCard1 = deck.remove(0);
		dealerCard2 = deck.remove(0);
		if (dealerCard1.getName().equals("Ace")) {
			System.out.println("The Dealer is showing an : " + dealerCard1);
		} else {
			System.out.println("The Dealer is showing a : " + dealerCard1);
		}
		dealerHand = dealerCard1.getValue() + dealerCard2.getValue();
		if (dealerHand == 21) {
			System.out.println("");
			System.out.println("Sorry, dealer has BLACKJACK!!!!!! You lose.");
			p1.playAgain();
		}
		p1.hand(deck, playerHand, dealerHand, dealerCard2);
	}

	public void dealerPlay(List<Card> deck, int playerHand, int dealerHand, Card dealerCard2) {
		Card dealerCard3;
		System.out.print("Dealer reveals second card to be : " + dealerCard2);
		System.out.print("\nDealer's current total is : " + dealerHand);
		while (dealerHand <= 16) {
			System.out.println("\nThat is less than or equal to 16 so dealer hits: ");
			dealerCard3 = deck.remove(0);
		System.out.print("Card is : " + dealerCard3);
			dealerHand += dealerCard3.getValue();
			if (dealerHand > 21) {
				System.out.println("\nBUSTED, Dealer is out, You Win!");
				p1.playAgain();
			}
		}
		System.out.print("\nThat brings the dealer's total to : " + dealerHand);
		System.out.println("");
		System.out.print("Your total is : " + playerHand);
		System.out.println("");
		if (dealerHand > playerHand) {
			System.out.println("Sorry you lose.");
			p1.playAgain();
		} else if (dealerHand < playerHand) {
			System.out.println("You win!! Congratulations");
			p1.playAgain();
		} else {
			System.out.println("It's a push.....no winner.");
			p1.playAgain();
		}

	}

}
