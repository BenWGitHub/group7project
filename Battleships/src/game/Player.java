package game;

import java.util.Scanner;

public class Player {
	private GameBoard gb;

	public Player() {
		gb = new GameBoard();
	}

	// TODO: User Input
	public void addShip(int len) {
		// Needs to be updated so that gb.addShips takes user input as parameters)

		int x = -1;
		int y = -1;
		String dir = new String("");

		// Ask for user input and assign to x, must be between 0 and 9 (inclusive)
		Scanner sc = new Scanner(System.in);

		do {
			System.out.print("Please Enter The X co-ordinate for your ship between 0 and 9: ");
			if (sc.hasNextLine()) {
				x = sc.nextInt();
			}

			if (x < 0 || x > 9) {
				System.out.println("X must be between 0 and 9.");
			}
		} while (x < 0 || x > 9);

		// Ask for user input and assign to y, must be between 0 and 9 (inclusive)

		do {
			System.out.print("Please Enter The Y co-ordinate for your ship between 0 and 9: ");
			
			if (sc.hasNextLine()) {
				y = sc.nextInt();
			}
			
			if (y < 0 || y > 9) {
				System.out.println("Y must be between 0 and 9.");
			}

		} while (y < 0 || y > 9);

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

		gb.addShip(x, y, len, dir);

	}

	public GameBoard getGameBoard() {
		return gb;
	}

	// TODO: User Input
	// TODO: Redo this method, re-think the logic
	public void fireAt(Player p) {
		// Ask user for location to fire
		// x , y need to be updated by the user

	}

	public boolean hasShips() {

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (gb.getBoard()[i][j] != null) {
					return true;
				}
			}
		}

		return false;
	}
}
