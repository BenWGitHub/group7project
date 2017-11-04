package game;

import java.util.Scanner;

public class Player {
	private GameBoard gb;
	private String name;

	public Player(String name) {
		gb = new GameBoard();
		this.setName(name);
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

	public void fireAt(Player p, int x , int y) {

		if(p.getGameBoard().getBoard()[x][y] != null) {
			// HIT OR SINK
			Ship s = p.getGameBoard().getShipAt(x, y);
			p.getGameBoard().getBoard()[x][y] = null;
			if(p.getGameBoard().contains(s.getId())) {
				//HIT
				System.out.println("HIT");
			} else  {
				// SINK
				System.out.println("SINK");
			}
		} else {
			//MISS
			System.out.println("MISS");
		}
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
