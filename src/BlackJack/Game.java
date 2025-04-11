package BlackJack;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
	private Player players[];
	private Deck deck = new Deck();;
	
	public Game(Player[] players) {
		this.players = new Player[players.length];
		for(int i=0; i<players.length; i++) {
			this.players[i] = players[i];
		}//end for
	}//end Game constructor
	
	public void deal() {
		for(int i = 0; i<2; i++) {
			for(Player player: players) {
				player.setHand(deck.dealCard());
			}//end inner for
		}//end outer for
	}//end deal
	
	public void playRound(Scanner getData) {
		for(Player player: players) {
			String playerOption;
			boolean hit = true;
			while(true) {
				System.out.println(player.getName() + " your current hand adds up to " + player.getHandTotal());
				try {
					System.out.println("Would you like to hit or stay [H/S]");
					playerOption = getData.next();
					if(playerOption.toLowerCase().equals("s")) {
						System.out.println("Opted to stay bold strategy " + 
								player + " adding up to " + player.getHandTotal());
						break;
					}else if(!playerOption.toLowerCase().equals("h")) {
						throw new InputMismatchException();
					}//end if else
					}catch(InputMismatchException e) {
						System.out.println("Invalid input please enter h for hit or s for stay");
						getData.nextLine();
						continue;
					}//end try catch
				
				player.setHand(deck.dealCard());
				if(player.getHandTotal() > 21) {
					System.out.println(player);
					System.out.println("which adds up to "+ player.getHandTotal());
					System.out.println("ooof busted...better luck next time");
					break;
				}//end	if			
			}//end while
		}//end player loop
	}//end play round
	
	public void nextRound() {
		System.out.println("before shuffle ");
		System.out.println(deck);
		deck.shuffle();
		System.out.println("after shuffle ");
		System.out.println(deck);
		for(Player player: players) {
			player.newGame();
		}
		printPlayersHand();
	}
	
//	public void announceWinners() {
//		Player
//		for(Player player: players) {
//			
//		}
		
//	}//end announce winners
	public void printPlayersHand() {
		for(Player player: players) {
			System.out.println(player);
		}//end for
	}//end print players hand

}//end game
