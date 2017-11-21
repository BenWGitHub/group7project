package game;

import java.util.Random;
import java.util.Scanner;

public class GameController {

	private Player p1;
	private Player p2;
	private Scanner scanner;
	private int[] shipLengths;

	public GameController(Player p1, Player p2) {

		this.p1 = p1;
		this.p2 = p2;
		this.scanner = new Scanner(System.in);
		shipLengths = new int[] { 5, 4, 3, 3, 2 };

		System.out.println("========================");
		System.out.println(p1.getName());
		System.out.println("========================");

		for (int i = 0; i < shipLengths.length; i++) {
			this.addShips(p1, shipLengths[i]);
		}

		System.out.println("========================");
		System.out.println(p2.getName());
		System.out.println("========================");

		for (int i = 0; i < shipLengths.length; i++) {
			this.addShips(p2, shipLengths[i]);
		}

		printBoard(p1, p2);
		printBoard(p2, p1);

		while (true) {

			int x = -1;
			int y = -1;

			System.out.println("Player 1, Please Enter The Coordinates For Where You Would Like To Attack.");

			do {
				System.out.println("X: ");

				while (!scanner.hasNextInt()) {
					System.out.println("Not A Number, Try Again.");
					scanner.next();
				}
				x = scanner.nextInt();

				if (x < 0 || x > 9) {
					System.out.println("X must be between 0 and 9 inclusive, Try Again: ");
				}

			} while (x < 0 || x > 9);

			do {
				System.out.println("Y: ");

				while (!scanner.hasNextInt()) {
					System.out.println("Not A Number, Try Again.");
					scanner.next();
				}
				y = scanner.nextInt();

				if (y < 0 || y > 9) {
					System.out.println("Y must be between 0 and 9 inclusive, Try Again: ");
				}
			} while (y < 0 || y > 9);

			p1.fireAt(p2, x, y);

			if (!p2.hasShips()) {
				System.out.println("Congratulations Player 1, You've Sunken All Your Enemies Ships!");
				break;
			}

			///////////////////////////////////////////////////////////////////////////////////////////////////

			if (p2.getName().equals("Player 2")) {

				System.out.println("Player 2, Please Enter The Coordinates For Where You Would Like To Attack.");

				do {
					System.out.println("X: ");

					while (!scanner.hasNextInt()) {
						System.out.println("Not A Number, Try Again.");
						scanner.next();
					}
					x = scanner.nextInt();

					if (x < 0 || x > 9) {
						System.out.println("X must be between 0 and 9 inclusive, Try Again: ");
					}
				} while (x < 0 || x > 9);

				do {
					System.out.println("Y: ");

					while (!scanner.hasNextInt()) {
						System.out.println("Not A Number, Try Again.");
						scanner.next();
					}
					y = scanner.nextInt();

					if (y < 0 || y > 9) {
						System.out.println("Y must be between 0 and 9 inclusive, Try Again: ");
					}
				} while (y < 0 || y > 9);

				p2.fireAt(p1, x, y);

				if (!p1.hasShips()) {
					System.out.println("Congratulations Player 2, You've Sunken All Your Enemies Ships!");
					break;
				}

			} else {
				p2.fireAt(p1, new Random().nextInt(10), new Random().nextInt(10));
				
				if(!p1.hasShips()) {
					System.out.println("Sorry Player 2, The Computer Has Won! Better Luck Next Time!");
				}
			}

			x = -1;
			y = -1;
		}
	}

	// TODO: Change printBoard so that it takes a player object and prints their
	// perspective of the game
	// ((Their gameboard with all ships showing and their opponents gameboard
	// displaying HITS/SINKS and MISSES
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
		// unable to track if ships have been hit currently
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

	private void addShips(Player p, int len) {
		int x, y;
		String dir = new String("");

		// Ask for user input and assign to x, must be between 0 and 9 (inclusive)
		Scanner sc = new Scanner(System.in);

		do {
			x = -1;
			y = -1;

			do {
				System.out.print("Please Enter The X co-ordinate for your ship between 0 and 9: ");
				if (sc.hasNextLine()) {
					x = sc.nextInt();
				}

				System.out.print("Please Enter The Y co-ordinate for your ship between 0 and 9: ");

				if (sc.hasNextLine()) {
					y = sc.nextInt();
				}

				if ((x < 0 || x > 9) || (y < 0 || y > 9)) {
					System.out.println("Coordinates must be between must be between 0 and 9, Try Again: ");
				}
			} while ((x < 0 || x > 9) || (y < 0 || y > 9));

			// Ask for user input and assign to dir, must be either N, E, S or W

			sc.nextLine();

			do {
				System.out.print("Please Enter A Direction To Place Your Ship (N, E, S or W): ");
				if (sc.hasNextLine()) {
					dir = sc.nextLine().trim().toUpperCase();
				}

				if (!(dir.equals("N") || dir.equals("E") || dir.equals("S") || dir.equals("W"))) {
					System.out.println("The Direction Must be N, S, E or W.");
				}

			} while (!(dir.equals("N") || dir.equals("E") || dir.equals("S") || dir.equals("W")));

		} while (!p.addShip(len, x, y, dir));
	}
}
