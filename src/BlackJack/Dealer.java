package BlackJack;

public class Dealer extends Player {
	public Dealer() {
		super("dealer");
	}// end constructor

	// Sets up and ascii representation of the dealers hand. Hides one card from
	// being displayed
	public void showHand() {
		Card hand[] = getHand();
		String visualHand[] = { "", "", "", "", "", "", "" };
		for (int i = 0; i < getNumberOfCardsInHand(); i++) {
			visualHand[0] += "┌───────────────┐  ";
		} // end for
		for (int i = 0; i < getNumberOfCardsInHand(); i++) {
			String topLeft = String.format("%-2s", hand[i].getValueSymbol());
			if (i + 1 == getNumberOfCardsInHand()) {
				visualHand[1] += "│ " + "              │  ";
			} else {
				visualHand[1] += "│" + topLeft + "             │  ";
			} // end if else
		} // end for

		for (int i = 0; i < getNumberOfCardsInHand(); i++) {
			visualHand[2] += "│               │  ";
		} // end for

		for (int i = 0; i < getNumberOfCardsInHand(); i++) {
			if (i + 1 == getNumberOfCardsInHand()) {
				visualHand[3] += "│        " + "       │  ";
			} else {
				visualHand[3] += "│       " + hand[i].getSuitSymbol() + "       │  ";
			} // end if else
		} // end for

		for (int i = 0; i < getNumberOfCardsInHand(); i++) {
			visualHand[4] += "│               │  ";
		} // end for

		for (int i = 0; i < getNumberOfCardsInHand(); i++) {
			String bottomRight = String.format("%2s", hand[i].getValueSymbol());
			if (i + 1 == getNumberOfCardsInHand()) {
				visualHand[5] += "│ " + "              │  ";
			} else {
				visualHand[5] += "│             " + bottomRight + "│  ";
			} // end if else
		} // end for

		for (int i = 0; i < getNumberOfCardsInHand(); i++) {
			visualHand[6] += "└───────────────┘  ";
		} // end for

		for (String line : visualHand) {
			System.out.println(line);
		} // end for
	}// end showHand

	// calls super classes showHand in order to show dealers full hand when
	// applicable
	public void showFullHand() {
		super.showHand();
	}// end showFullHand
}// end Dealer
