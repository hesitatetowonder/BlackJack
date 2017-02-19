package cards;

import java.util.*;

public class Player {
	Scanner kb = new Scanner(System.in);

	public void hand(List<Card> playerHand, List<Card> dealerHand, List<Card> deck) {
		Dealer dealer = new Dealer();		
		if (playerHand.size() >= 3){
			System.out.println("Your cards are now : " + playerHand);	
		}
		else {
			System.out.println("You have " + playerHand);
			System.out.println("The dealer has been dealt two cards, the one showing is : " + dealerHand.get(0));
		}
		System.out.println("Time to make a decision : Would you like to (H)it or (S)tay? ");
		String decision = kb.next();
		int player = playerHand.get(0).getValue() + playerHand.get(1).getValue();
		if ((decision.equals("H")) || (decision.equals("h"))) {
			Card newCard;
			newCard = deck.remove(0);
			playerHand.add(newCard);
			System.out.println("Your new card is : " + newCard);
			for (int i = 2; i < playerHand.size(); i++) {
				player += playerHand.get(i).getValue();
			}
			if (player < 21) {
				System.out.println("Still under 21 : ");
				hand(playerHand, dealerHand, deck);
			} else if (player == 21) {
				System.out.println("That's 21, worst you can do is a push, let's see what the dealer gets...");
				dealer.dealerPlay(playerHand, dealerHand, deck);
			} else if (player > 21) {
				for (int i = 0; i < playerHand.size(); i++) {
					if (player > 21){
					if (playerHand.get(i).getValue() == 11){
						playerHand.get(i).setValue(1);
						System.out.println("If your " + playerHand.get(i).getName() + " of " + playerHand.get(i).getSuits()
											+ " is 11 you bust so it is now 1");
						player -= 10;
					}
					}
				}
				if (player < 22){
					hand(playerHand, dealerHand, deck);
				}
				System.out.println("Awwwwwwwwwwwwww.....too bad, you BUSTED!!!!!!!!!!!");
				playAgain();
			}
		}
		dealer.dealerPlay(playerHand, dealerHand, deck);
	}
	
	public void playAgain(){
		BlackJack jack = new BlackJack();
		System.out.println("*************************************************************************************");
		System.out.print("Play Again (y or n) : ");
		String again = kb.next();
		if((again.equals("Y"))||(again.equals("y"))){
			jack.start();
		}
		else{
			System.exit(0);
		}
	}
		public int playerTotal(List<Card> playerHand){
			int total = 0;
			for (int i = 0; i < playerHand.size(); i++) {
				total += playerHand.get(i).getValue();
			}
			return total;
	}
}
