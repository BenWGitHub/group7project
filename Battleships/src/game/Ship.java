package game;

public class Ship {

	private String id;
	private int x;
	private int y;

	public Ship(int x, int y, String id) {
		this.id = id;
		this.x = x;
		this.y = y;
	}

	public String getId() {
		return id;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return getId();
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Ship) 
		{
			Ship s = (Ship) o;
			if (this.getX() == s.getX() && this.getY() == s.getY()) {
					return true;
				} 
		}
		return false;
	}
}
