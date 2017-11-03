package game;

public class Ship {

	private String id;
	private int x;
	private int y;
	
	public Ship(int x, int y, String id) {
		this.id = id;
		this.setX(x);
		this.setY(y);
	}

	public String getId() {
		return id;
	}


	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return getId();
	}
}
