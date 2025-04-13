package BlackJack;
import java.security.SecureRandom;

public class Deck {
	private Card[] cards = new Card[52];
	
	public Deck() {
		int counter =0;
		while(counter<52) {
			for(int j = 2; j<15; j++) {
				String suit, name = "", suitSymbol ="", valueSymbol ="";
				int value = j;
				switch(j) {
				case(2):
					name= "Two";
					valueSymbol="2";
					break;
				case(3):
					name= "Three";
					valueSymbol="3";
					break;
				case(4):
					name= "Four";
					valueSymbol="4";
					break;
				case(5):
					name= "Five";
					valueSymbol="5";
					break;
				case(6):
					name= "Six";
					valueSymbol="6";
					break;
				case(7):
					name= "Seven";
					valueSymbol="7";
					break;
				case(8):
					name= "Eight";
					valueSymbol="8";
					break;
				case(9):
					name= "Nine";
					valueSymbol="9";
					break;
				case(10):
					name= "Ten";
					valueSymbol="10";
					break;
				case(11):
					name= "Jack";
					valueSymbol="J";
					value = 10;
					break;
				case(12):
					name= "Queen";
					value = 10;
					valueSymbol="Q";
					break;
				case(13):
					name= "King";
					value = 10;
					valueSymbol="K";
					break;
				case(14):
					name= "Ace";
					value = 11;
					valueSymbol="A";
					break;
				}//end switch
				if(counter <13) {
					suit = "Hearts";
					suitSymbol = "♥";
				}else if(counter <26) {
					suit = "Diamonds";
					suitSymbol = "♦";
				}else if(counter <39) {
					suit = "Spades";
					suitSymbol = "♠";
				}else {
					suit = "Clubs";
					suitSymbol = "♣";
				}
				cards[counter] = new Card(suit, name, value, suitSymbol, valueSymbol);
				counter++;
			}// end for
		}//end while

	}//end default constructor
	
	public Card dealCard() {
		SecureRandom randomNumberGenerator = new SecureRandom();
		int randomNumber = randomNumberGenerator.nextInt(52);
		while(!cards[randomNumber].inDeck()) {
			randomNumber= randomNumberGenerator.nextInt(52);
		}
		cards[randomNumber].setInDeck(false);
		return cards[randomNumber];
	}
	
	public void shuffle() {
		for(Card card: cards) {
			card.setInDeck(true);
		}
		
	}//end shuffle
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<52; i++) {
			sb.append(cards[i].toString());
			sb.append(cards[i].getInDeck());
			sb.append("\n");
		}
		return sb.toString();
	}//end toString
}//end Deck
