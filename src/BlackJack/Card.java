package BlackJack;

public class Card {
	private String suit, suitSymbol, valueSymbol, name;
	private int value;
	private boolean inDeck;

	public Card(String suit, String name, int value, String suitSymbol, String valueSymbol) {
		this.suit = suit;
		this.name = name;
		this.value = value;
		this.inDeck = true;
		this.suitSymbol = suitSymbol;
		this.valueSymbol = valueSymbol;
	}//end constructor

	public String getSuit() {
		return suit;
	}//end getSuit

	public String getName() {
		return name;
	}//end getName

	public int getValue() {
		return value;
	}//end getValue

	public void setInDeck(boolean inDeck) {
		this.inDeck = inDeck;
	}//end setInDeck

	public boolean isInDeck() {
		return inDeck;
	}//end isInDeck

	public String getValueSymbol() {
		return valueSymbol;
	}//end getValueSymbol

	public String getSuitSymbol() {
		return suitSymbol;
	}//end getSuitSymbol

	public void setValue(int value) {
		this.value = value;
	}//end setValue
}
