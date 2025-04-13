package BlackJack;

public class Dealer extends Player {
	public Dealer() {
		super("dealer");
	}

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
			}
		} // end for
		for (int i = 0; i < getNumberOfCardsInHand(); i++) {
			visualHand[2] += "│               │  ";
		} // end for
		for (int i = 0; i < getNumberOfCardsInHand(); i++) {
			if (i + 1 == getNumberOfCardsInHand()) {
				visualHand[3] += "│        " + "       │  ";
			} else {
				visualHand[3] += "│       " + hand[i].getSuitSymbol() + "       │  ";
			}
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
			}
		} // end for
		for (int i = 0; i < getNumberOfCardsInHand(); i++) {
			visualHand[6] += "└───────────────┘  ";
		} // end for

		for (String line : visualHand) {
			System.out.println(line);
		}
	}

	public void showFullHand() {
		super.showHand();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Card hand[] = getHand();
		sb.append("dealer");
		sb.append("'s visible hand is ");
		sb.append(hand[0]);
		return sb.toString();
	}// end toString

}
