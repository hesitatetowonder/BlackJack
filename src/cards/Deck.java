package cards;

import java.util.*;

public class Deck {
	private List<Card> theDeck = new ArrayList<>();

	public void buildDeck() {
		String[] s = { "Hearts", "Spades", "Clubs", "Diamonds" };
		String[] card = { "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack",
				"Queen", "King" };
		for (int i = 0; i < card.length; i++) {
			for (int j = 0; j < s.length; j++) {
				if (i == 0) {
					Card c = new Card(card[i], s[j], 11);
					theDeck.add(c);
				}
				else if(i<9){
					Card c = new Card(card[i], s[j], i+1);
					theDeck.add(c);
				}
				else{
					Card c = new Card(card[i], s[j], 10);
					theDeck.add(c);
				}
			}
		}
		Collections.shuffle(theDeck);
	}
}
