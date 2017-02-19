# Greg's BlackJack project
This is a classic game of BlackJack.
There are 5 classes.
The Card class holds the card structure and creates the cards.

The Deck class assembles a standard 52 card deck.

The Dealer class shuffles the deck and deals the cards to the player
and himself as well as playing his hand(hits at 16 stays at 17 and up)

The Player class allows the player to control his hand(hit or stay)

The BlackJack class gets the deck from the Deck class and passes
it to the Dealer to begin the game.

Aces begin as 11 and will be changed(one at a time) to 1
to avoid player or dealer going over 21, player will be
informed if the Ace value is changed.
The player will be dealt two cards.
If they get BlackJack(21) they win
The dealer will be dealt two cards(one face up one face down).
If the dealer gets BlackJack he wins.
Player will be asked if the would like to Hit or Stay.
If the player chooses Hit and their total goes over 21 they
are busted and they lose.
Once the player is satisfied with their score the dealer will
reveal his second card.
If the dealers total is 16 or lower he will hit, if it is 17
or above he will stay.  
If the dealer hits and exceeds 21 he will be busted and player wins.
If the dealer ends with a score lower than the player the player
wins.  If the dealers score is higher the player loses.
If the scores are the same the game ends in a push with neither
player winning.  Once the game is over the player is asked if they
would like to play again.
