package cards;

import java.util.*;

public class Dealer {
	List<Card> dealDeck = new ArrayList<Card>();
	
	public void shuffleUpAndDeal(List<Card> deck){
		Collections.shuffle(deck);
		System.out.print("Your cards are : " + deck.remove(0));
		System.out.print(deck.remove(1));
		
	}

}
