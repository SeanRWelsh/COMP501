package BlackJack;

public class Player {
	private String name;
	private Card hand[]; 
	private int wins, cardsInHand;
	private boolean busted;
	
	public Player(String name) {
		this.name = name;
		this.hand = new Card[11];
		this.wins = 0;
		this.cardsInHand =0;
		this.busted = false;
	}//end Player constructor
	
	public String getName() {
		return name;
	}//end getName
	
	public Card[] getHand() {
		return hand;
	}//end getHand
	public int getNumberOfCardsInHand() {
		int numberOfCards = 0;
		for(Card card:hand) {
			if(card != null)
				numberOfCards++;
		}//end for
		return numberOfCards;
		
	}//end getNumberOfCardsInHand
	
	public void showHand() {
		Card hand[] = getHand();
		String visualHand[]= {"","","","","","",""};
		for(int i=0; i<getNumberOfCardsInHand(); i++) {
			visualHand[0] +="┌───────────────┐  ";
		}//end for
		for(int i=0; i<getNumberOfCardsInHand(); i++) {
			String topLeft = String.format("%-2s", hand[i].getValueSymbol());
			visualHand[1] +="│" + topLeft + "             │  ";
		}//end for
		for(int i=0; i<getNumberOfCardsInHand(); i++) {
			visualHand[2]+= "│               │  ";
		}//end for
		for(int i=0; i<getNumberOfCardsInHand(); i++) {
			visualHand[3]+= "│       " + hand[i].getSuitSymbol() + "       │  ";
		}//end for
		for(int i=0; i<getNumberOfCardsInHand(); i++) {
			visualHand[4]+="│               │  ";
		}//end for
		for(int i=0; i<getNumberOfCardsInHand(); i++) {
			String bottomRight = String.format("%2s", hand[i].getValueSymbol());
			visualHand[5]+="│             " + bottomRight + "│  ";
		}//end for
		for(int i=0; i<getNumberOfCardsInHand(); i++) {
			visualHand[6]+="└───────────────┘  ";
		}
        for (String line : visualHand) {
            System.out.println(line);
        }
	}
	
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
		busted =false;
	}//end newGame
	
	public int getHandTotal() {
		int total = 0;	
		for(int i=0; i<hand.length; i++) {
			if(hand[i] != null) total+=hand[i].getValue();
			if(hand[i+1] == null) break; 
		}
		return total;
	}
	
	public boolean isBusted() {
		return busted;
	}
	
	public void setBusted(boolean busted) {
		this.busted = busted;
		
	}
}
