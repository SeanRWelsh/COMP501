/*
 *Sean Welsh
 *Assignment BlackJack 
 *This Program allows up to 4 players to play blackJack against a dealer
 *BlackJack class contains Main and drives the program
 *Game handles all Game logic
 *Player handles
 */
package BlackJack;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BlackJack {
	public static void main(String[] args) {
		int numberOfPlayers = 0;
		Scanner getData = new Scanner(System.in);
		Player players[];
		Game playGame;
		boolean playAgain = true;

		System.out.println("Welcome to blackJack!!");
		while (true) {
			System.out.println("Please enter the number of players 1-4: ");
			try {
				numberOfPlayers = getData.nextInt();
				if (numberOfPlayers >= 1 && numberOfPlayers <= 4) {
					break;
				} else {
					// System.out.println("Invalid input please try again");
					throw new InputMismatchException();
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input please try again");
				getData.nextLine();
			}
		}
		players = new Player[numberOfPlayers];
		for (int i = 0; i < players.length; i++) {
			String name;
			System.out.printf("Please enter player %d's name: \n", i + 1);
			name = getData.next();
			players[i] = new Player(name);
		}
		playGame = new Game(players);
		while (playAgain) {
			playGame.deal();
			playGame.printDeal(getData);
			playGame.playRound(getData);
			playGame.announceWinners();
			playAgain = playGame.playAgain(getData);
		} // end while

		System.out.println("Final win tally");
		for (int i = 0; i < players.length; i++) {
			System.out.println(players[i].getName() + " Won a total of " +
					players[i].getWins());
		}

		System.out.println("Thanks for Playing blackjack!");

	}// end main
}// end blackjack
