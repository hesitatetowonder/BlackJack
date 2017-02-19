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
		int value = card1.getValue() + card2.getValue();
		if (value == 21) {
			System.out.println("Congratulations, You got BLACKJACK, You Win!!!!");
			p1.playAgain();
		}
		playerHand.add(card1);
		playerHand.add(card2);
		dealerHand(deck, playerHand);

	}

	public void dealerHand(List<Card> deck, List<Card> playerHand) {
		dealerCard1 = deck.remove(0);
		dealerCard2 = deck.remove(0);
		dealerHand.add(dealerCard1);
		dealerHand.add(dealerCard2);
		if (dealerCard1.getValue() + dealerCard2.getValue() > 21){
			System.out.println("Dealer got BLACKJACK, sorry,  you lose.");
			p1.playAgain();
		}
		p1.hand(playerHand, dealerHand, deck);
	}

	public void dealerPlay(int player, List<Card> playerHand, List<Card> dealerHand, List<Card> deck) {
		int dealer = 0;
		System.out.println("The dealer reveals his second card : " + dealerHand.get(1) + "\n Dealer hand :" + dealerHand);
		dealer = dealerHand.get(0).getValue() + dealerHand.get(1).getValue();
		if (dealer <= 16){
		do {	
			System.out.println("Total is less than or equal to 16, dealer hits : ");
			Card newCard = deck.remove(0);
			System.out.println("Dealers card is " + newCard.getName() + " Dealer hand is now : " + dealerHand + newCard);
			dealerHand.add(newCard);
			for (int i = 2; i < dealerHand.size(); i++) {
				dealer += dealerHand.get(i).getValue();
			}
		} while (dealer <= 16);
		} // end if
		if (dealer > 21) {
			for (int i = 0; i < dealerHand.size(); i++) {
				dealerHand.get(i).getName();
				if(dealerHand.get(i).getValue() == 11){
					dealerHand.get(i).setValue(1);
					dealer -= 10;
					System.out.println("Dealer would bust with 11 so Ace is 1");
				}
			}
			System.out.print(""+ dealerHand + "Dealer hand is now > 21 : ");
			System.out.println("Dealer busts, player wins!");
			p1.playAgain();
		} else if (dealer > 17) {
			System.out.println("" + dealerHand + "17 or greater : ");
			System.out.println("Dealer stays");
			System.out.println("Dealer hand is " + dealerHand + "total:" + dealerTotal(dealerHand));
			System.out.println("Player hand is " + playerHand);
		}
		System.out.println("*************************************************************************************");
		System.out.println("**********************************DECISION TIME**************************************");
		System.out.println("**********************************The WINNER is**************************************");
		System.out.println("*************************************************************************************");
		if(player > dealer){
			System.out.println("*************************************PLAYER******************************************");
		}
		else if (player < dealer){
			System.out.println("*************************************DEALER******************************************");
		}
		else if (player == dealer){
			System.out.println("**************************************PUSH*******************************************");
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
