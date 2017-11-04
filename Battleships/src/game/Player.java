package game;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Player {
	private GameBoard gb;

	public Player() {
		gb = new GameBoard();
	}

	// TODO: User Input
	public void setUpShips() {
		// Needs to be updated so that gb.addShips takes user input as parameters)
		for (int i = 0; i < 3; i++) {
			Random rnd = new Random();
			int dirInt = rnd.nextInt(3);
			int rndX = rnd.nextInt(gb.getBoard().length - 1);
			int rndY = rnd.nextInt(gb.getBoard()[0].length - 1);
			char dir = ' ';
			if (dirInt == 0) {
				dir = 'N';
			} else if (dirInt == 1) {
				dir = 'E';
			} else if (dirInt == 2) {
				dir = 'S';
			} else {
				dir = 'W';
			}
			gb.addShip(rndX, rndY , 2, dir);
		}
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
