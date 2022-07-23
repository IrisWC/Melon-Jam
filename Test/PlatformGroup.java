package Test;

import java.awt.image.ImageObserver;
import java.awt.*	;

public class PlatformGroup {
	
	Platform p1, p2;
	
	PlatformGroup()
	{
		  p1 = new Platform(200, 500);
		  p2 = new Platform(100, 400);
	}
	
	public void shift()
	{
  		p1.moveHorizontally(Platform.LEFT);
  		p2.moveHorizontally(Platform.LEFT);
	}
	
	public boolean isBelow(MovingImage m)
	{
		boolean oneIsBelow = false;
		boolean twoIsBelow = false;
		
		oneIsBelow = m.isAtop(p1, 10);
		twoIsBelow = m.isAtop(p2, 10);
		
		return oneIsBelow || twoIsBelow;
	}
	
	// check if platform is still on screen
	// if not, instantiate new platform
	public void check()
	{
		if (p1.getX() + p1.getWidth() < 0) {
			  p1 = new Platform(800,500);
		}
		
		if (p2.getX() + p2.getWidth() < 0) {
			p2 = new Platform (100, 400);
		}
	}

	public void draw (Graphics g, ImageObserver io)
	{
		p1.draw(g, io);
		p2.draw(g, io);
		
	}
}
