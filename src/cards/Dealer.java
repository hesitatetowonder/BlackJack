package cards;

import java.util.*;

public class Dealer {
	Player p1 = new Player();
	Card card1, card2, dealerCard1, dealerCard2;
	List<Card> playerHand = new ArrayList<>();
	List<Card> dealerHand = new ArrayList<>();

	public void shuffleUpAndDealPlayer(List<Card> deck) {
		Collections.shuffle(deck);
		card1 = deck.remove(0);
		card2 = deck.remove(0);
		playerHand.add(card1);
		playerHand.add(card2);
		int value = card1.getValue() + card2.getValue();
		if ((card1.getValue() == 11) && (card2.getValue() == 11)) {
			System.out.println("You got two Aces, " + playerHand.get(0) + " and " + playerHand.get(1)
					+ ", if both were 11 you would bust \nso " + playerHand.get(0) + " is now 1");
			playerHand.get(0).setValue(1);
			System.out.println("Your hand is now : " + playerHand);
		}
		if (value == 21) {
			System.out.println("Congratulations, You got BLACKJACK, " + playerHand + ", You Win!!!!");
			p1.playAgain();
		}
		dealerHand(deck, playerHand);

	}

	public void dealerHand(List<Card> deck, List<Card> playerHand) {
		dealerCard1 = deck.remove(0);
		dealerCard2 = deck.remove(0);
		dealerHand.add(dealerCard1);
		dealerHand.add(dealerCard2);
		if (dealerCard1.getValue() + dealerCard2.getValue() == 21) {
			System.out.println("Dealer got BLACKJACK, " + dealerHand + " , sorry,  you lose.");
			p1.playAgain();
		}
		p1.hand(playerHand, dealerHand, deck);
	}

	public void dealerPlay(List<Card> playerHand, List<Card> dealerHand, List<Card> deck) {
		int dealer;
		System.out.println("The Dealer's hand is" + dealerHand);
		dealer = dealerHand.get(0).getValue() + dealerHand.get(1).getValue();
		if (dealer <= 16) {
			do {
				System.out.println("Total is less than or equal to 16, dealer hits : ");
				Card newCard = deck.remove(0);
				System.out.println("Dealers card is " + newCard + " Dealer hand is now : " + dealerHand + newCard);
				dealerHand.add(newCard);
				for (int i = 2; i < dealerHand.size(); i++) {
					dealer += dealerHand.get(i).getValue();
				}
			} while (dealer <= 16);
		}
		else if((dealer > 17) && (dealer <= 21)){
			System.out.println("" + dealerHand + "  is 17 or greater : ");
			System.out.println("Dealer stays");
			System.out.println("Dealer hand is " + dealerHand + "total:" + dealerTotal(dealerHand));
			System.out.println("Player hand is " + playerHand + "total:" + p1.playerTotal(playerHand));
		}
		else if(dealer > 21){
			for (int i = 0; i < playerHand.size(); i++) {
				if (dealer > 21) {
					if (dealerHand.get(i).getValue() == 11) {
						dealerHand.get(i).setValue(1);
						System.out.println("If dealers " + dealerHand.get(i).getName() + " of "
								+ dealerHand.get(i).getSuits() + " is 11 he bust, so it is now 1");
						dealerPlay(playerHand, dealerHand, deck);
					}
				}
			}
		
		System.out.print("" + dealerHand + "Dealer hand is now > 21 : ");
		System.out.println("Dealer busts, player wins!");
		p1.playAgain();
		}
		System.out.println("Dealer = " + dealerTotal(dealerHand));
		System.out.println("Player = " + p1.playerTotal(playerHand));
		System.out.println("*************************************************************************************");
		System.out.println("**********************************DECISION TIME**************************************");
		System.out.println("**********************************The WINNER is**************************************");
		if (p1.playerTotal(playerHand) > dealer) {
			System.out.println("                                     PLAYER");
		} 
		else if (p1.playerTotal(playerHand) < dealer) {
			System.out.println("                                     DEALER");
		} 
		else if (p1.playerTotal(playerHand) == dealer) {
			System.out.println("                                      PUSH");
		}
		p1.playAgain();
	}
	

	public int dealerTotal(List<Card> dealerHand){
		int total = 0;
		for (int i = 0; i < dealerHand.size(); i++) {
			total += dealerHand.get(i).getValue();
		}
		return total;
		
	}
}
