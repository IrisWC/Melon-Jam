package Assets;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class Mushroom {

	private int type;
	private Image image;
	private int x, y, width, height;
	private boolean visible;
	
	private Rectangle hitbox;
	
	public Mushroom(int t, int xcord, int ycord, int w, int h, boolean visibility) {
		type = t;
		x = xcord;
		y = ycord;
		width = w;
		height = h;
		visible = visibility;
		
		hitbox = new Rectangle(x, y, width, height);
		
		switch(type) {
		case 1:
			image = new ImageIcon("img\\Red Shroom.png").getImage();
			break;
		case 2:
			image = new ImageIcon("img\\Orange Shroom.png").getImage();
			break;
		case 3:
			image = new ImageIcon("img\\Green Shroom.png").getImage();
			break;
		case 4:
			image = new ImageIcon("img\\Blue Shroom.png").getImage();
			break;
		case 5:
			image = new ImageIcon("img\\Purple Shroom.png").getImage();
			break;
		case 6:
			image = new ImageIcon("img\\Pink Shroom.png").getImage();
			break;
		case 7:
			image = new ImageIcon("img\\Gray Shroom.png").getImage();
			break;
		case 8:
			image = new ImageIcon("img\\Brown Shroom.png").getImage();
			break;
		}
	}
	
	public int getType() {
		return type;
	}
	
	public void draw(Graphics g, ImageObserver obs) {
		if (visible)
			g.drawImage(image, x, y, width, height, obs);
	}
	
	public Rectangle getHitbox() {
		return hitbox;
	}
	
	public void toggleVisibility() {
		visible = !visible;
	}
}
