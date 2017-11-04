package game;

public class GameController {

	private Player p1;
	private Player p2;

	public GameController() {
		
		this.p1 = new Player();
		this.p2 = new Player();

		setUpShips();
		printBoard();

		// TODO:
		// LOOP
		// Allow Player 1 to attack player 2's ships
		// Allow Player 2 to attack player 1's ships
		// Break IF either player has no ships remaining
		// Declare winner

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
		
		System.out.println();
	}
	
	
	// TODO: Change printBoard so that it takes a player object and prints their perspective of the game
	// ((Their gameboard with all ships showing and their opponents gameboard displaying HITS and MISSES
	private void printBoard() {
	
		System.out.println("=============================");
		System.out.println("Player 1's Board");
		System.out.println("=============================");

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				Ship s = p1.getGameBoard().getBoard()[i][j];
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
		System.out.println("Player 2's Board");
		System.out.println("=============================");

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				Ship s = p2.getGameBoard().getBoard()[i][j];
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
