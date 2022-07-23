package Assets;

import java.awt.*;
import java.awt.image.ImageObserver;

import javax.swing.*;

public class Player {

	private int x, y, width, height;
	private Image image;
	private double xvel, yvel;
	private boolean onSurface;
	
	private Rectangle hitbox;
	
	public Player(int xcord, int ycord, int w, int h) {
		image = new ImageIcon("img\\Player.png").getImage();
		x = xcord;
		y = ycord;
		width = w;
		height = h;
		hitbox = new Rectangle(x, y, w, h);
		
		xvel = 0;
		yvel = 0;
		onSurface = false;
	}
	
	public void fall() {
		xvel *= 0.95;
		
		if(yvel < 15)
			yvel += 0.5;
		
		onSurface = false;
		
		//TODO Add in something to check if player is on a platform
		
		moveBy((int)xvel, (int)yvel);
	}
	
	public void jump() {
		if(onSurface) {
			yvel = -10;
			moveBy(0, (int)yvel);
		}
	}
	
	public void move(int direction) {
		if(Math.abs(xvel) < 10)
			xvel += direction;
	}
	
	public void moveBy(int xval, int yval) {
		x += xval;
		y += yval;
		hitbox = new Rectangle(x, y, width, height);
	}
	
	public void draw(Graphics g, ImageObserver obs) {
		g.drawImage(image, x, y, width, height, obs);
	}
	
	public Rectangle getHitbox() {
		return hitbox;
	}
}
