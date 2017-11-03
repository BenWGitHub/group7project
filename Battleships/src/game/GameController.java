package game;

public class GameController {
	
	private Player p1;
	private Player p2;
	
	public GameController() {
		this.p1 = new Player();
		this.p2 = new Player();
		
		// Ask Player 1 to set up their ships
		p1.setUpShips();
		// Ask Player 2 to set up their ships
		p2.setUpShips();
		
		/**
		 * Just some code the see if the ships are added to the board correctly (Not necessary for game)
		 * S == Ship added at this location
		 * N == Nothing present (location is null)
		 */
		{
		
		System.out.println("Player 1's Board");
		System.out.println("========================");
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(p1.getGameBoard().getBoard()[i][j] != null) {
					System.out.print("S ");
				} else {
					System.out.print("N ");
				}
				if(j == 9) {
					System.out.println();
				}
			}
		}
		
		System.out.println();
		System.out.println("Player 2's Board");
		System.out.println("========================");
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(p2.getGameBoard().getBoard()[i][j] != null) {
					System.out.print("S ");
				} else {
					System.out.print("N ");
				}
				if(j == 9) {
					System.out.println();
				}
			}
		}
		
		}
		
		// LOOP
		// Allow Player 1 to attack player 2's ships
		// Allow Player 2 to attack player 1's ships
		// Break IF either player has no ships remaining
		// Declare winner
		
		//: TODO Detect who actually won the game
		while(true) {
			
			p1.fire();
			p2.fire();
			
			if(!p1.hasShips() || !p2.hasShips()) {
				break;
			}
		}
		
		System.out.println("Congratulations!!!");
	}
}
