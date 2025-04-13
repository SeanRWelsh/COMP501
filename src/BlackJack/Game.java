package BlackJack;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
	private Player players[];
	private Deck deck = new Deck();;
	
	public Game(Player[] players) {
		this.players = new Player[players.length+1];
		int i=0;
		for(i=0; i<players.length; i++) {
			this.players[i] = players[i];
		}//end for
		this.players[i] = new Dealer();
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
				if(player.getName() != "dealer") {
					playerTurn(player, getData);
				}else {
					dealerTurn((Dealer) player);
			}//if else
		}//end player loop
	}//end play round
	
	public boolean playAgain(Scanner getData) {
		while(true) {
			String playAgain;
			System.out.println("Play again?[Y/N]");

				playAgain = getData.next();
				if(playAgain.toLowerCase().equals("y")) {
					nextRound();
					return true;
				}else if(playAgain.toLowerCase().equals("n")) {
					return false;
				}else{
					System.out.println("Invalid input please enter y to play another round n to leave");
					getData.nextLine();	
				}//end if else
		}//end input while	
	}//end playAgain
	
	private void nextRound() {
		deck.shuffle();
		for(Player player: players) {
			player.newGame();
		}//end player for loop
	}//end next round
	
	private void playerTurn(Player player, Scanner getData) {
		while(true) {
		String playerOption;
		System.out.println(player.getName() + " your current hand ");
		player.showHand();
		System.out.println("adds up to " + player.getHandTotal());
		try {
			System.out.println("Would you like to hit or stay [H/S]");
			playerOption = getData.next();
			if(playerOption.toLowerCase().equals("s")) {
				System.out.println("Opted to stay bold strategy ");
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
			player.showHand();
			System.out.println("which adds up to "+ player.getHandTotal());
			System.out.println("ooof busted...better luck next time");
			player.setBusted(true);
			break;
		}//end	if	
		}//end while
	}//end playerTurn
	
	private void dealerTurn(Dealer dealer) {
		System.out.println(dealer.getName() + " your current hand adds up to " + dealer.getHandTotal());
		while(dealer.getHandTotal()<16) {
			dealer.setHand(deck.dealCard());
			System.out.println("dealer hits! ");
			System.out.println("dealer now has " );
			dealer.showFullHand();
			System.out.println(" totaling " + dealer.getHandTotal());
		}
		if(dealer.getHandTotal() > 21) dealer.setBusted(true);
	}
	
	public void announceWinners() {
		int dealer = players.length-1;
		if(players[dealer].getHandTotal() == 21 &&
				players[dealer].getNumberOfCardsInHand()<=2) {
			System.out.println("Dealer wins  with "); 
			((Dealer) players[dealer]).showFullHand();
		}else if(players[dealer].isBusted()) {
			System.out.println("Dealer busted!!!!! ");
			for(int i=0; i<dealer; i++) {
				if(players[i].isBusted()) {
					System.out.println(players[i].getName() + " also busted...better luck next time ");
				}
				players[i].setWins();
				System.out.println(players[i].getName() + " Won!!");
			}
		}else {
			for(int i=0; i<dealer; i++) {
				if(players[i].isBusted()) {
					System.out.println(players[i].getName() + " busted better luck next time ");
			
				}else if(players[i].getHandTotal() > players[dealer].getHandTotal()) {
					players[i].setWins();
					System.out.println(players[i].getName() + " Won!! with "); 
					players[i].showHand();
					System.out.println(" beating the dealer by " + 
							(players[i].getHandTotal()-players[dealer].getHandTotal()));
				}else if(players[i].getHandTotal() == players[dealer].getHandTotal()) {
					System.out.println(players[i].getName() + " tied with ");
					players[i].showHand();
					System.out.println(" dealer had ");
					players[dealer].showHand();
				}else {
					System.out.println(players[i].getName() + " lost with ");
					players[i].showHand();
					System.out.println(" losing to the dealer by " + 
									(players[dealer].getHandTotal()-players[i].getHandTotal()));
				}
			}
			
		}
		
	}//end announce winners
	public void printDeal() {
		for(Player player: players) {
			System.out.println(player.getName());
			player.showHand();
		}//end for
	}//end print players hand

}//end game
