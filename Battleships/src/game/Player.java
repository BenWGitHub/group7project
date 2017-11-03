package game;

import java.util.Random;

public class Player {
	private GameBoard gb;
	
	public Player() {
		gb = new GameBoard();
	}
	
	// TODO: User Input
	public void setUpShips() {
		//Needs to be updated so that gb.addShips takes user input as parameters)
		for(int i = 0; i < 3; i++) {
			Random rnd = new Random();
			int dirInt = rnd.nextInt(3);
			char dir = ' ';
			if(dirInt == 0) {
				dir = 'N';
			} else if(dirInt == 1) {
				dir = 'E';
			} else if (dirInt == 2) {
				dir = 'S';
			} else {
				dir = 'W';
			}
			gb.addShip(rnd.nextInt(gb.getBoard().length-1),rnd.nextInt(gb.getBoard()[0].length-1),2,dir);
		}
		
	}
	
	public GameBoard getGameBoard() {
		return gb;
	}
	
	// TODO: User Input
	public void fire() {
		// Ask user for location to fire
		//x , y need to be updated by the user
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
			//System.out.println("MISS!");
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
