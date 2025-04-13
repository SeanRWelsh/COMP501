package BlackJack;

import java.security.SecureRandom;

public class Deck {
	private Card[] cards = new Card[52];

	// Constructor for Deck. Creates a standard 52 card deck by individually
	// creating each card object and storing each card in an array
	public Deck() {
		int counter = 0;
		while (counter < 52) {
			for (int j = 2; j < 15; j++) {
				String suit, name = "", suitSymbol = "", valueSymbol = "";
				int value = j;
				// Set up for cards name value symbol and value
				switch (j) {
					case (2):
						name = "Two";
						valueSymbol = "2";
						break;
					case (3):
						name = "Three";
						valueSymbol = "3";
						break;
					case (4):
						name = "Four";
						valueSymbol = "4";
						break;
					case (5):
						name = "Five";
						valueSymbol = "5";
						break;
					case (6):
						name = "Six";
						valueSymbol = "6";
						break;
					case (7):
						name = "Seven";
						valueSymbol = "7";
						break;
					case (8):
						name = "Eight";
						valueSymbol = "8";
						break;
					case (9):
						name = "Nine";
						valueSymbol = "9";
						break;
					case (10):
						name = "Ten";
						valueSymbol = "10";
						break;
					case (11):
						name = "Jack";
						valueSymbol = "J";
						value = 10;
						break;
					case (12):
						name = "Queen";
						value = 10;
						valueSymbol = "Q";
						break;
					case (13):
						name = "King";
						value = 10;
						valueSymbol = "K";
						break;
					case (14):
						name = "Ace";
						value = 11;
						valueSymbol = "A";
						break;
				}// end switch

				// set up for cards suit
				if (counter < 13) {
					suit = "Hearts";
					suitSymbol = "♥";
				} else if (counter < 26) {
					suit = "Diamonds";
					suitSymbol = "♦";
				} else if (counter < 39) {
					suit = "Spades";
					suitSymbol = "♠";
				} else {
					suit = "Clubs";
					suitSymbol = "♣";
				}
				// create a new card object and place in array
				cards[counter] = new Card(suit, name, value, suitSymbol, valueSymbol);
				counter++;
			} // end for
		} // end while
	}// end default constructor

	// Use secureRandom to randomly choose a card from the deck. If card has already
	// been dealt generate another random number and check again
	// once a random card still in the deck is found set card to no longer in deck
	// and pass the card to whatever called it
	public Card dealCard() {
		SecureRandom randomNumberGenerator = new SecureRandom();
		int randomNumber = randomNumberGenerator.nextInt(52);
		while (!cards[randomNumber].isInDeck()) {
			randomNumber = randomNumberGenerator.nextInt(52);
		} // end while

		cards[randomNumber].setInDeck(false);
		return cards[randomNumber];
	}// end dealCard

	// Iterates through each card and resets its inDeck value back to true
	public void shuffle() {
		for (Card card : cards) {
			card.setInDeck(true);
		} // end for
	}// end shuffle
}// end Deck
