package BlackJack;
import java.security.SecureRandom;

public class Deck {
	private Card[] cards = new Card[52];
	
	public Deck() {
		int counter =0;
		while(counter<52) {
			for(int j = 2; j<15; j++) {
				String suit, name = "";
				int value = j;
				switch(j) {
				case(2):
					name= "Two";
					break;
				case(3):
					name= "Three";
					break;
				case(4):
					name= "Four";
					break;
				case(5):
					name= "Five";
					break;
				case(6):
					name= "Six";
					break;
				case(7):
					name= "Seven";
					break;
				case(8):
					name= "Eight";
					break;
				case(9):
					name= "Nine";
					break;
				case(10):
					name= "Ten";
					break;
				case(11):
					name= "Jack";
					value = 10;
					break;
				case(12):
					name= "Queen";
					value = 10;
					break;
				case(13):
					name= "King";
					value = 10;
					break;
				case(14):
					name= "Ace";
					value = 11;
				
					break;
				}//end switch
				if(counter <13) {
					suit = "Hearts";
				}else if(counter <26) {
					suit = "Diamonds";
				}else if(counter <39) {
					suit = "Spades";
				}else {
					suit = "Clubs";
				}
				cards[counter] = new Card(suit, name, value);
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
