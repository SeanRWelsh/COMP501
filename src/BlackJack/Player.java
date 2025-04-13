package BlackJack;

public class Player {
	private String name;
	private Card hand[];
	private int wins, cardsInHand, money, wager;
	private boolean busted;

	public Player(String name) {
		this.name = name;
		this.hand = new Card[11];
		this.wins = 0;
		this.cardsInHand = 0;
		this.busted = false;
		this.money = 5;
		this.wager = 0;
	}// end Player constructor

	public String getName() {
		return name;
	}// end getName

	public Card[] getHand() {
		return hand;
	}// end getHand

	public int getNumberOfCardsInHand() {
		return cardsInHand;
	}// end getNumberOfCardsInHand

	// Sets up and ascii representation of the players hand
	public void showHand() {
		Card hand[] = getHand();
		String visualHand[] = { "", "", "", "", "", "", "" };
		for (int i = 0; i < getNumberOfCardsInHand(); i++) {
			visualHand[0] += "┌───────────────┐  ";
		} // end for

		for (int i = 0; i < getNumberOfCardsInHand(); i++) {
			String topLeft = String.format("%-2s", hand[i].getValueSymbol());
			visualHand[1] += "│" + topLeft + "             │  ";
		} // end for

		for (int i = 0; i < getNumberOfCardsInHand(); i++) {
			visualHand[2] += "│               │  ";
		} // end for

		for (int i = 0; i < getNumberOfCardsInHand(); i++) {
			visualHand[3] += "│       " + hand[i].getSuitSymbol() + "       │  ";
		} // end for

		for (int i = 0; i < getNumberOfCardsInHand(); i++) {
			visualHand[4] += "│               │  ";
		} // end for

		for (int i = 0; i < getNumberOfCardsInHand(); i++) {
			String bottomRight = String.format("%2s", hand[i].getValueSymbol());
			visualHand[5] += "│             " + bottomRight + "│  ";
		} // end for

		for (int i = 0; i < getNumberOfCardsInHand(); i++) {
			visualHand[6] += "└───────────────┘  ";
		} // end for

		for (String line : visualHand) {
			System.out.println(line);
		} // end for
	}// end showHand

	public void setHand(Card card) {
		hand[cardsInHand] = card;
		cardsInHand++;
	}// end setHand

	public int getWins() {
		return wins;
	}// end getWins

	public void addAWin() {
		wins++;
	}// end addAWin

	// Resets player stats cardsInHand, hand, and busted
	public void newGame() {
		for (int i = 0; i < cardsInHand; i++) {
			hand[i] = null;
		} // end for
		cardsInHand = 0;
		busted = false;
		wager = 0;
	}// end newGame

	public int getHandTotal() {
		int total = 0;
		for (int i = 0; i < cardsInHand; i++) {
			if (hand[i] != null)
				total += hand[i].getValue();
		} // end for
		return total;
	}// end getHandTotal

	public boolean isBusted() {
		return busted;
	}// end isBusted

	public void addWinningBid() {
		money += wager;
	}

	public void removeLosingBid() {
		money -= wager;
	}

	public int getMoney() {
		return money;
	}

	public int getWager() {
		return wager;
	}

	public void setWager(int wager) {
		this.wager = wager;
	}

	public void setBusted(boolean busted) {
		this.busted = busted;
	}// end setBusted
}// end Player
