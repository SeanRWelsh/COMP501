package BlackJack;

public class Card {
	private String suit, name;
	private int value;
	private boolean inDeck;
	
	public Card(String suit, String name, int value) {
		this.suit = suit;
		this.name = name;
		this.value = value;
		this.inDeck = true;
	}
	
	public String getSuit() {
		return suit;
	}
	
	public String getname() {
		return name;
	}
	
	public int getValue() {
		return value;
	}
	public boolean getInDeck() {
		return inDeck;
	}
	public void setInDeck(boolean inDeck) {
		this.inDeck = inDeck;
	}
	public boolean inDeck() {
		return inDeck;
	}
	
	@Override
	public String toString() {
		return  name + " of " + suit;
	}

}
