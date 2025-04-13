package BlackJack;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
	private Player players[];
	private Deck deck = new Deck();;

	public Game(Player[] players) {
		this.players = new Player[players.length + 1];
		int i = 0;
		for (i = 0; i < players.length; i++) {
			this.players[i] = players[i];
		} // end for
		this.players[i] = new Dealer();
	}// end Game constructor

	// deals 2 cards to every player including the dealer
	public void deal() {
		for (int i = 0; i < 2; i++) {
			for (Player player : players) {
				player.setHand(deck.dealCard());
			} // end inner for
		} // end outer for
	}// end deal

	// lets every player take there turn and then the dealer takes there turn
	public void playRound(Scanner getData) {
		for (Player player : players) {
			if (player.getName() != "dealer") {
				playerTurn(player, getData);
			} else {
				dealerTurn((Dealer) player);
			} // if else
		} // end player loop
	}// end play round

	// gets input from the players if they want to play again. If they do reset
	// everything for the next round
	// and pass back true to the calling item. If the player wishes to exit return
	// false to the calling item.
	public boolean playAgain(Scanner getData) {
		while (true) {
			String playAgain;
			System.out.println("Play again?[Y/N]");
			try {
				playAgain = getData.next();
				if (playAgain.toLowerCase().equals("y")) {
					nextRound();
					return true;
				} else if (playAgain.toLowerCase().equals("n")) {
					return false;
				} else {
					throw new InputMismatchException();
				} // end if else
			} catch (InputMismatchException e) {
				System.out.println("Invalid input please y to play again or n to exit");
				getData.nextLine();
			} // end try catch
		} // end input while
	}// end playAgain

	// reset all deck and player data for a fresh start
	private void nextRound() {
		deck.shuffle();
		for (Player player : players) {
			player.newGame();
		} // end player for loop
	}// end next round

	// handles logic of players turn asks if they want to hit or stay. If hit deals
	// them a card from the deck
	// if card is an Ace asks if they want it to be 11 or 1. finally adds card to
	// players hand. As long as the player
	// has not busted they will continue to be prompted to hit or stay
	private void playerTurn(Player player, Scanner getData) {
		while (true) {
			String playerOption;
			System.out.println(player.getName() + " your current hand ");
			player.showHand();
			System.out.println("adds up to " + player.getHandTotal());
			try {
				System.out.println("Would you like to hit or stay [H/S]");
				playerOption = getData.next();
				if (playerOption.toLowerCase().equals("s")) {
					System.out.println("Opted to stay bold strategy ");
					break;
				} else if (!playerOption.toLowerCase().equals("h")) {
					throw new InputMismatchException();
				} // end if else
			} catch (InputMismatchException e) {
				System.out.println("Invalid input please enter h for hit or s for stay");
				getData.nextLine();
				continue;
			} // end try catch

			// handle ace value
			Card cardDealt = deck.dealCard();
			if (cardDealt.getName() == "Ace") {
				setAceValue(getData, cardDealt);
			} // end if

			// add card to hand and if busted let the player know
			player.setHand(cardDealt);
			if (player.getHandTotal() > 21) {
				player.showHand();
				System.out.println("which adds up to " + player.getHandTotal());
				System.out.println("ooof busted...better luck next time");
				player.setBusted(true);
				break;
			} // end if
		} // end while
	}// end playerTurn

	// handles dealer turn logic. If dealer hand is < 16 hit otherwise stay. Show
	// the dealers updated hand
	private void dealerTurn(Dealer dealer) {
		System.out.println(dealer.getName() + " your current hand adds up to " + dealer.getHandTotal());
		while (dealer.getHandTotal() < 16) {
			dealer.setHand(deck.dealCard());
			System.out.println("dealer hits! ");
			System.out.println("dealer now has ");
			dealer.showFullHand();
			System.out.println(" totaling " + dealer.getHandTotal());
		} // end while
		if (dealer.getHandTotal() > 21)
			dealer.setBusted(true);
	}// end dealerTurn

	// Prompt user about what value they want there ace to be then update the value
	// of that particular ace
	private void setAceValue(Scanner getData, Card card) {
		int value;
		System.out.println("You were dealt an Ace Would you like its value to be 11 or 1?");
		while (true) {
			try {
				value = getData.nextInt();
				if (value == 1 || value == 11) {
					card.setValue(value);
					break;
				} else {
					// System.out.println("Invalid input please try again");
					throw new InputMismatchException();
				} // end if else
			} catch (InputMismatchException e) {
				System.out.println("Invalid input please enter 1 or 11");
				getData.nextLine();
			} // end try catch
		} // end while
	}// end setAceValue

	// determine who won. If a player won add a win to there tally
	public void announceWinners() {
		int dealer = players.length - 1;

		// condition 1. dealer dealt 21 everyone losses
		if (players[dealer].getHandTotal() == 21 &&
				players[dealer].getNumberOfCardsInHand() <= 2) {
			System.out.println("Dealer wins  with ");
			((Dealer) players[dealer]).showFullHand();

			// condition 2 dealer busted Everyone that did not bust won
		} else if (players[dealer].isBusted()) {
			System.out.println("Dealer busted!!!!! ");
			for (int i = 0; i < dealer; i++) {
				if (players[i].isBusted()) {
					System.out.println(players[i].getName() + " also busted...better luck next time ");
				} else {
					players[i].addAWin();
					System.out.println(players[i].getName() + " Won!!");
				} // end if else
			}
		} else {
			for (int i = 0; i < dealer; i++) {

				// condition 3 player busted auto loss
				if (players[i].isBusted()) {
					System.out.println(players[i].getName() + " busted better luck next time ");

					// condition 4 player hand total greater than dealer. player wins
				} else if (players[i].getHandTotal() > players[dealer].getHandTotal()) {
					players[i].addAWin();
					System.out.println(players[i].getName() + " Won!! with ");
					players[i].showHand();
					System.out.println(" beating the dealer by " +
							(players[i].getHandTotal() - players[dealer].getHandTotal()));

					// condition 5 player and dealer tie. Player does not get a win tally
				} else if (players[i].getHandTotal() == players[dealer].getHandTotal()) {
					System.out.println(players[i].getName() + " tied with ");
					players[i].showHand();
					System.out.println(" dealer had ");
					((Dealer) players[dealer]).showFullHand();

					// condition 6 players hand is less than dealers. player lost
				} else {
					System.out.println(players[i].getName() + " lost with ");
					players[i].showHand();
					System.out.println(" losing to the dealer by " +
							(players[dealer].getHandTotal() - players[i].getHandTotal()));
				} // end if else
			} // end player for loop
		} // end if else
	}// end announce winners

	// prints every players name and hand. Prints dealers cards but hides one
	public void printDeal(Scanner getData) {
		for (Player player : players) {
			Card card[] = player.getHand();
			System.out.println(player.getName());
			player.showHand();
			if (player.getName() == "dealer")
				break;
			for (int i = 0; i < player.getNumberOfCardsInHand(); i++) {
				if (card[i].getName() == "Ace")
					setAceValue(getData, card[i]);
			} // end inner for
		} // end outer for
	}// end print players hand
}// end game
