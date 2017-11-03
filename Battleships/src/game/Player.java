package game;

public class Player {
	private GameBoard gb;
	
	public Player() {
		gb = new GameBoard();
	}
	
	// TODO: User Input
	public void setUpShips() {
		
		gb.addShip(5,6,4,'W');
		
	}
	
	public GameBoard getGameBoard() {
		return gb;
	}
	
	// TODO: User Input
	public void fire() {
		// Ask user for location to fire
		
		int x = 0;
		int y = 0;
		
		if(gb.getBoard()[x][y] != null) {
			Ship s = gb.getShipAt(x,y);
			gb.getBoard()[x][y] = null; // Deletes ship
			for(int i = 0; i < 10; i++) {
				for(int j = 0; j < 10; j++) {
					if(gb.getShipAt(i, j).equals(s)) {
						System.out.println("HIT!");
					} else {
						System.out.println("You sank you opponents " + s.getId() + "!");
					}
				}
			}
		} else {
			System.out.println("MISS!");
		}
	}
	
	public boolean hasShips() {
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(gb.getBoard()[i][j] != null) { return true; }
			}
		}
		
		return false;
	}
}
