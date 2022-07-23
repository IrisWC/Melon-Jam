package Core;

import java.awt.*;
import java.awt.image.ImageObserver;
import javax.swing.*;
import Assets.*;

public class Dimension {
	
	private Image background;
	private Platform[] platforms;
	private Image orb;
	private int orbx, orby;
	
	public Dimension(int type) {
		switch (type) {
		case 1: //Red
			background = new ImageIcon("img\\Red.png").getImage();
			orb = new ImageIcon("img\\Red Orb.png").getImage();
			orbx = 1300;
			orby = 200;
			platforms = new Platform[] {new Platform(1175, 300, 300, 50, true), new Platform(100, 800, 300, 50, true)};
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		}
	}
	
	public void draw(Graphics g, ImageObserver obs) {
		g.drawImage(background, 0, 0, 1600, 900, obs);
		for(Platform p : platforms) {
			p.draw(g, obs);
		}
		g.drawImage(orb, orbx, orby, 50, 50, obs);
	}
	
	public Platform[] getPlatforms() {
		return platforms;
	}
}
