package Test;

import java.net.URL;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

/*
 * Represents a moving, appearing/disappearing image.
 *
 * by: Shelby
 *     Added boundingRectangle
 * on: 5/3/13
 */
 
public class MovingImage {
	
	// FIELDS
	
	private int x, y;
	private int width, height;
	private Image image;
	private boolean isVisible;
	
	private Point upperLeft;
	private Dimension wh;
	private Rectangle boundingBox;
	
	// CONSTRUCTORS
	
	public MovingImage(String filename, int x, int y, int w, int h) {
		this((new ImageIcon(filename)).getImage(),x,y,w,h);
	}
	
	public MovingImage(URL url, int x, int y, int w, int h) {
		this((new ImageIcon(url)).getImage(),x,y,w,h);
	}
	
	public MovingImage(Image img, int x, int y, int w, int h) {
		image = img;
		this.x = x;
		this.y = y;
		width = w;
		height = h;
		isVisible = true;
		
		upperLeft = new Point (x, y);
		wh = new Dimension (width, height);
		boundingBox = new Rectangle (upperLeft, wh);
	}
	
	
	// METHODS
	
	private void setBoundingBox()
	{
		upperLeft = new Point (x, y);
		wh = new Dimension (width, height);
		boundingBox = new Rectangle (upperLeft, wh);
		
	}
	
	public void toggleVisibility() {
		isVisible = !isVisible;
	}
	
	public void moveToLocation(int x, int y) {
		this.x = x;
		this.y = y;
		setBoundingBox();
	}
	
	public void moveByAmount(int x, int y) {
		this.x += x;
		this.y += y;
		setBoundingBox();
	}
	
	public void applyWindowLimits(int windowWidth, int windowHeight) {
		x = Math.min(x,windowWidth-this.width);
		y = Math.min(y,windowHeight-this.height);
		x = Math.max(0,x);
		y = Math.max(0,y);
		setBoundingBox();
	}
	
	public boolean isPointInImage(int mouseX, int mouseY) {
		if (mouseX >= x && mouseY >= y && mouseX <= x + width && mouseY <= y + height)
			return true;
		return false;
	}
	
	public void resize(int w, int h) {
		width = w;
		height = h;
		setBoundingBox();
	}
	
	public boolean collidesWith (MovingImage m) 	{
		return boundingBox.intersects(m.getBoundingBox());
	}
	
	public boolean isAtop (MovingImage m) {
		boolean returnValue = true;
		
		if ((this.y + height) != m.getY()) {
			returnValue = false;
		}
		else if ((x + width < m.getX()) ||(m.getX() + m.getWidth() < x))
		{
			returnValue = false;
		}
		return returnValue;
	}
	
	public boolean isAtop (MovingImage m, int fudge) {
		boolean returnValue = true;
		
		if ((this.y + height) < (m.getY() - fudge) || (m.getY() < (this.y + height))) {
		//if ((m.getY() - fudge) < (this.y + height) && (this.y + height) < m.getY()) {
							returnValue = false;
		}
		else if ((x + width < m.getX()) ||(m.getX() + m.getWidth() < x))
		{
			returnValue = false;
		}
		return returnValue;
	}
	public void draw(Graphics g, ImageObserver io) {
		if (isVisible)
			g.drawImage(image,x,y,width,height,io);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public Rectangle getBoundingBox() {
		return this.boundingBox;
	}
	
	public boolean isVisible() {
		return isVisible;
	}
	
	
	
}










