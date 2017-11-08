package game;

import java.util.HashSet;
import java.util.Set;

public class GameBoard {
	private Ship board[][];
	private Set<Position> usedPositions;
	
	
	public GameBoard() {
		board  = new Ship[10][10];
		usedPositions = new HashSet<>();
	}
	
	public void addShip(int x, int y, int length, String dir) {
		
		int x1 = x;
		int y1 = y;
		
		if(dir.equals("W")) {
			for(int i = 0; i < length; i++) {
				y1 = y - i;
				usedPositions.add(new Position(x1, y1));
				board[x1][y1] = new Ship(x, y, dir + length);
			}
		} else if(dir.equals("N")) {
			for(int i = 0; i < length; i++) {
				x1 = x - i;
				usedPositions.add(new Position(x1, y1));
				board[x1][y1] = new Ship(x, y, dir + length);
			}
		} else if(dir.equals("E")) {
			for(int i = 0; i < length; i++) {
				y1 = y + i;
				usedPositions.add(new Position(x1, y1));
				board[x1][y1] = new Ship(x, y, dir + length);
			}
		} else {
			for(int i = 0; i < length; i++) {
				x1 = x + i;
				usedPositions.add(new Position(x1, y1));
				board[x1][y1] = new Ship(x, y, dir + length);
			}
		}
		
		
		
	}
	
	public Set<Position> getUsedPositions() {
		return usedPositions;
	}
	
	public Ship[][] getBoard() {
		return board;
	}
	
	public Ship getShipAt(int x, int y) {
		return board[x][y];
	}
	
	public void removeShipAt(int x, int y) {
		board[x][y] = null;
	}
	
	public boolean contains(String shipID) {
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0 ; j < 10; j++) {
				if(board[i][j] != null) {
					if(board[i][j].getId().equals(shipID)) { return true; }
				}
			}
		}
		
		return false;
	}
}