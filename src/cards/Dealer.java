package cards;

import java.util.*;

public class Dealer {
	List<Card> dealDeck = new ArrayList<Card>();
	List<Integer> playerHand = new ArrayList<>();
	List<Integer> dealerHand = new ArrayList<>();
	Card card1;
	Card card2;
	Card dealerCard1;
	Card dealerCard2;

	public List<Integer> shuffleUpAndDealPlayer(List<Card> deck) {
		card1 = deck.remove(0);
		card2 = deck.remove(1);
		System.out.print("You have been dealt : " + card1 + " and " + card2);
		System.out.println("");
		if ((card1.getValue() + card2.getValue()) == 21) {
			System.out.println("BLACKJACK!!!!!! You win!!!");
			return playerHand;
		}
		playerHand.add(card1.getValue()+card2.getValue());
		shuffleUpAndDealDealer(deck);
		return playerHand;

	}

	public List<Integer> shuffleUpAndDealDealer(List<Card> deck) {
		Collections.shuffle(deck);
		dealerCard1 = deck.remove(0);
		dealerCard2 = deck.remove(1);
		if (dealerCard1.getName().equals("Ace")) {
			System.out.println("The Dealer is showing an : " + dealerCard1);
		} else {
			System.out.println("The Dealer is showing a : " + dealerCard1);
		}
		if ((dealerCard1.getValue() + dealerCard2.getValue()) == 21) {
			System.out.println("");
			System.out.println("Sorry, dealer has BLACKJACK!!!!!! You lose.");
		}
		return dealerHand;
	}
}
