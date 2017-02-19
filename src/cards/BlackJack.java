package cards;

import java.util.*;

public class BlackJack {
	public static void main(String[] args) {

		BlackJack jack = new BlackJack();
		
		jack.start();
	}
	
		public void start() {
			List<Card> newDeck = new ArrayList<Card>();
			Deck bicycle = new Deck();
			Dealer dealer = new Dealer();
			newDeck = bicycle.buildDeck();
			dealer.shuffleUpAndDealPlayer(newDeck);
	}
		
}

