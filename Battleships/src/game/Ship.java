package game;

import java.util.Random;
import javafx.scene.Parent;

public class Ship extends Parent {
	public int type;
	public boolean vertical = true;
	private int health;

	public Ship(int type, boolean vertical) {
		this.type = type;
		this.vertical = vertical;
		health = type;
	}

	public void hit() {
		health--;
	}

	public boolean isAlive() {
		return health > 0;
	}

	public String shipHitResponse() {
		Random rnd = new Random();
		String[] hitResponses = new String[10];

		hitResponses[0] = "Take that!";
		hitResponses[1] = "You're finished!";
		hitResponses[2] = ""; // Don't leave this!!!!!!
		hitResponses[3] = "I'll end you!";
		hitResponses[4] = "*Teleports onto ship* Nothing personal kid!";
		hitResponses[5] = "I attack your life points directly!";
		hitResponses[6] = "Null pointer error, remains of your ego not found.";
		hitResponses[7] = "";
		hitResponses[8] = "";
		hitResponses[9] = "";

		return hitResponses[rnd.nextInt(hitResponses.length - 1)] ;
	}

	public String shipMissResponse() {
		Random rnd = new Random();
		String[] missResponses = new String[10];

		missResponses[0] = "Rats";
		missResponses[1] = "So close";
		missResponses[2] = "Your move";
		missResponses[3] = "";
		missResponses[4] = "";
		missResponses[5] = "";
		missResponses[6] = "";
		missResponses[7] = "";
		missResponses[8] = "";
		missResponses[9] = "";

		return missResponses[rnd.nextInt(missResponses.length - 1)];
	}
	
	public String shipDestroyed()
	{
		return "Ship destroyed!";
	}
	
	
}