package BlackJack;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BlackJack {
	public static void main(String[] args) {
		int numberOfPlayers = 0;
		Scanner getData = new Scanner(System.in);
		
		System.out.println("Welcome to blackJack!!");
		while(true) {
			System.out.println("Please enter the number of players 1-4: ");
			try{
				numberOfPlayers = getData.nextInt();
				if(numberOfPlayers >=1 && numberOfPlayers <=4) {
					break;
				}else {
					//System.out.println("Invalid input please try again");
					throw new InputMismatchException();
				}
			}catch(InputMismatchException e) {
				System.out.println("Invalid input please try again");
				getData.nextLine();
			}
		}
		Player players[] = new Player[numberOfPlayers];
		for(int i = 0; i<players.length; i++) {
			String name;
			System.out.printf("Please enter player %d's name: \n", i+1);
			name = getData.next();
			players[i] = new Player(name);
		}
		while(true) {
			String playAgain;
			Game playGame = new Game(players);
			playGame.deal();
			playGame.printPlayersHand();
			playGame.playRound(getData);
			//		playGame.announceWinners();
			while(true) {
				try {
					System.out.println("Play again?[Y/N]");
					playAgain = getData.next();
					if(playAgain.toLowerCase().equals("n")) {
						System.out.println("Thanks for playing blackjack come back soon!");
						getData.close();
						System.exit(1);
					}else if(!playAgain.toLowerCase().equals("y")) {
						throw new InputMismatchException();
					}//end if else
				}catch(InputMismatchException e) {
					System.out.println("Invalid input please enter y to play another round n to leave");
					getData.nextLine();
					continue;
				}//end try catch
				playGame.nextRound();
				break;
				
			}//end input while
		
		}// end while


		
		
	}//end main
}//end blackjack
