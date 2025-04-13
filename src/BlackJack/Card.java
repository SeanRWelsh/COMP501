package BlackJack;

public class Card {
	private String suit, suitSymbol, valueSymbol, name;
	private int value;
	private boolean inDeck;
	
	public Card(String suit, String name, int value, String suitSymbol,String valueSymbol) {
		this.suit = suit;
		this.name = name;
		this.value = value;
		this.inDeck = true;
		this.suitSymbol = suitSymbol;
		this.valueSymbol = valueSymbol;
	}
	
	public String getSuit() {
		return suit;
	}
	
	public String getName() {
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
	
	public String getValueSymbol() {
		return valueSymbol;
	}
	public String getSuitSymbol() {
		return suitSymbol;
	}
	public void setValue(int value) {
		this.value=value;
	}
	
	@Override
	public String toString() {
		return  name + " of " + suit;
	}

}
