package Assets;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class Platform {

	private int x, y, width, height;
	private Image image;
	private boolean visible;
	
	private Rectangle hitbox;
	
	public Platform(String imgName, int xcord, int ycord, int w, int h, boolean visibility) {
		image = new ImageIcon(imgName).getImage();
		x = xcord;
		y = ycord;
		width = w;
		height = h;
		visible = visibility;
		hitbox = new Rectangle(x, y, w, h);
	}
	
	public void draw(Graphics g, ImageObserver obs) {
		if (visible)
			g.drawImage(image, x, y, width, height, obs);
	}
	
	public Rectangle getHitbox() {
		return hitbox;
	}
}
