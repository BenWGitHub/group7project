package game;

public class GameBoard {
	public Ship board[][];
	
	public GameBoard() {
		board  = new Ship[10][10];
	}
	
	// TODO: Collision Logic
	public void addShip(int x, int y, int length, char dir) {
		if(dir == 'W') {
			for(int i = 0; i < length; i++) {
				board[x][y-i] = new Ship(x, y-i, "W" + length);
			}
		} else if(dir == 'N') {
			for(int i = 0; i < length; i++) {
				board[x-i][y] = new Ship(x-i, y, "N" + length);
			}
		} else if(dir == 'E') {
			for(int i = 0; i < length; i++) {
				board[x][y+i] = new Ship(x, y+i, "E" + length);
			}
		} else if(dir == 'S') {
			for(int i = 0; i < length; i++) {
				board[x+i][y] = new Ship(x+i, y, "S" + length);
			}
		}
		
	}
	
	public Ship[][] getBoard() {
		return board;
	}
	
	public Ship getShipAt(int x, int y) {
		return board[x][y];
	}
}
