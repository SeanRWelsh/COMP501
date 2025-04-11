package BlackJack;

public class Player {
	private String name;
	private Card hand[]; 
	private int wins, cardsInHand;
	
	public Player(String name) {
		this.name = name;
		this.hand = new Card[11];
		this.wins = 0;
		this.cardsInHand =0;
	}//end Player constructor
	
	public String getName() {
		return name;
	}//end getName
	
	public Card[] getHand() {
		return hand;
	}//end getHand
	
	public void setHand(Card card) {
		hand[cardsInHand] = card;
		cardsInHand++;
	}//end setHand
	
	public int getWins() {
		return wins;
	}//end getWins
	
	public void setWins() {
		wins++;
	}//end setWins
	
	public void newGame() {
		cardsInHand = 0;
		for(int i = 0; i<hand.length; i++) {
			hand[i]=null;
		}//end for
	}//end newGame
	
	public int getHandTotal() {
		int total = 0;	
		for(int i=0; i<hand.length; i++) {
			if(hand[i] != null) total+=hand[i].getValue();
			if(hand[i+1] == null) break; 
		}
		return total;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		sb.append("'s hand is ");
		for(int i=0; i<hand.length; i++) {
			if(hand[i] != null) {
				sb.append(hand[i]);
				if(hand[i+1] != null) {
					sb.append(", ");
				}else {
					break;
				}//end inner ifelse
			}//end out if
		}//end for
		return sb.toString();
	}//end toString
	

}
