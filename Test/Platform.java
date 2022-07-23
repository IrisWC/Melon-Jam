package Test;

public class Platform extends MovingImage {
	// FIELDS
	
	public static final int LEFT = -1;
	
	// CONSTRUCTOR
	public Platform	(int x, int y) {
		super("bricks.png",x,y,400,50);
	}
	
	// METHODS
	public void moveHorizontally(int dir) {
		moveByAmount (1 * dir, 0);
	}
	
	public void moveVertically() {
		
	}
}
	
	
