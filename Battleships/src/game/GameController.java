package game;

import java.util.Scanner;

// TODO: Add all user input to this class instead of contained within other classes
public class GameController {

	private Player p1;
	private Player p2;
	private Scanner scanner;

	public GameController() {

		this.p1 = new Player("Player 1");
		this.p2 = new Player("Player 2");
		this.scanner = new Scanner(System.in);

		setUpShips();
		printBoard(p1, p2);
		printBoard(p2, p1);

		while (true) {

			int x = -1;
			int y = -1;

			System.out.println("Player 1, Please Enter The Coordinates For Where You Would Like To Attack.");

			do {
				System.out.println("X: ");
				
				while(!scanner.hasNextInt()) {
					System.out.println("Not A Number, Try Again.");
					scanner.next();
				}
				x = scanner.nextInt();
				
				if(x < 0 || x > 9) {
					System.out.println("X must be between 0 and 9 inclusive, Try Again: ");
				}
				
			} while (x < 0 || x > 9);

			do {
				System.out.println("Y: ");
				
				while(!scanner.hasNextInt()) {
					System.out.println("Not A Number, Try Again.");
					scanner.next();
				}
				y = scanner.nextInt();
				
				if(y < 0 || y > 9) {
					System.out.println("Y must be between 0 and 9 inclusive, Try Again: ");
				}
			} while (y < 0 || y > 9);

			p1.fireAt(p2, x, y);

			if (!p2.hasShips()) {
				System.out.println("Congratulations Player 1, You've Sunken All Your Enemies Ships!");
				break;
			}

			///////////////////////////////////////////////////////////////////////////////////////////////////

			System.out.println("Player 2, Please Enter The Coordinates For Where You Would Like To Attack.");

			do {
				System.out.println("X: ");
				
				while(!scanner.hasNextInt()) {
					System.out.println("Not A Number, Try Again.");
					scanner.next();
				}
				x = scanner.nextInt();
				
				if(x < 0 || x > 9) {
					System.out.println("X must be between 0 and 9 inclusive, Try Again: ");
				}
			} while (x < 0 || x > 9);

			do {
				System.out.println("Y: ");
				
				while(!scanner.hasNextInt()) {
					System.out.println("Not A Number, Try Again.");
					scanner.next();
				}
				y = scanner.nextInt();
				
				if(y < 0 || y > 9) {
					System.out.println("Y must be between 0 and 9 inclusive, Try Again: ");
				}
			} while (y < 0 || y > 9);

			p2.fireAt(p1, x, y);

			if (!p1.hasShips()) {
				System.out.println("Congratulations Player 2, You've Sunken All Your Enemies Ships!");
				break;
			}

			x = -1;
			y = -1;
		}
	}

	private void setUpShips() {
		
		// Ask Player 1 to set up their ships

		System.out.println("========================");
		System.out.println("PLAYER 1");
		System.out.println("========================");

		p1.addShip(5);
		p1.addShip(4);
		p1.addShip(3);
		p1.addShip(3);
		p1.addShip(2);
		
		// Ask Player 2 to set up their ships

		System.out.println("========================");
		System.out.println("PLAYER 2");
		System.out.println("========================");

		p2.addShip(5);
		p2.addShip(4);
		p2.addShip(3);
		p2.addShip(3);
		p2.addShip(2);
		//

		System.out.println();
	}

	// TODO: Change printBoard so that it takes a player object and prints their
	// perspective of the game
	// ((Their gameboard with all ships showing and their opponents gameboard
	// displaying HITS and MISSES
	private void printBoard(Player currentPlayer, Player opposingPlayer) {

		System.out.println("=============================");
		System.out.println(currentPlayer.getName() + "'s Board");
		System.out.println("=============================");

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				Ship s = currentPlayer.getGameBoard().getBoard()[i][j];
				if (s != null) {
					System.out.print(s.getId() + " ");
				} else {
					System.out.print("NN ");
				}
				if (j == 9) {
					System.out.println();
				}
			}
		}

		System.out.println();
		System.out.println("=============================");
		System.out.println(opposingPlayer.getName() + "'s Board");
		System.out.println("=============================");
		// TODO: Make this so that the currentPlayer only knows where they've targeted
		// and not where their opponents
		// unknown ship locations are
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				Ship s = opposingPlayer.getGameBoard().getBoard()[i][j];
				if (s != null) {
					System.out.print(s.getId() + " ");
				} else {
					System.out.print("NN ");
				}
				if (j == 9) {
					System.out.println();
				}
			}
		}
	}

}
