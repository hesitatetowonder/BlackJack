package cards;

import java.util.*;

public class Dealer {
	Player p1 = new Player();
	List<Card> dealDeck = new ArrayList<Card>();
    int playerHand, dealerHand, newHand;
	Card card1, card2, dealerCard1, dealerCard2;

	public void shuffleUpAndDealPlayer(List<Card> deck) {
		Collections.shuffle(deck);
		card1 = deck.remove(0);
		card2 = deck.remove(1);
		System.out.print("You have been dealt : " + card1 + " and " + card2);
		System.out.println("");
		
		playerHand = (card1.getValue()+card2.getValue());
		if (playerHand == 21) {
			System.out.println("BLACKJACK!!!!!! You win!!!");
			System.exit(0);
		}
		shuffleUpAndDealDealer(deck, playerHand);
		p1.hand(deck, playerHand);

	}

	public List<Card> shuffleUpAndDealDealer(List<Card> deck, int playerHand) {
		dealerCard1 = deck.remove(0);
		dealerCard2 = deck.remove(1);
		if (dealerCard1.getName().equals("Ace")) {
			System.out.println("The Dealer is showing an : " + dealerCard1);
		} else {
			System.out.println("The Dealer is showing a : " + dealerCard1);
		}
		dealerHand = dealerCard1.getValue() + dealerCard2.getValue();
		if (dealerHand== 21) {
			System.out.println("");
			System.out.println("Sorry, dealer has BLACKJACK!!!!!! You lose.");
			System.exit(0);
		}
		return deck;
	}
	
	public Card hit(List<Card> deck){
		Card card3 = deck.remove(0);
		return card3;
	}
}
