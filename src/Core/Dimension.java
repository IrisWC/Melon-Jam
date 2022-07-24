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
	private int spawnx, spawny;
	private Mushroom shroom;
	
	public Dimension(int type) {
		switch (type) {
		case 1: //Red
			background = new ImageIcon("Red.png").getImage();
			orb = new ImageIcon("Red Orb.png").getImage();
			orbx = 1300;
			orby = 200;
			platforms = new Platform[] {new Platform(1175, 300, 300, 50, true), new Platform(100, 800, 300, 50, true),
					new Platform(444, 675, 200, 50, true), new Platform(688, 550, 200, 50, true), new Platform(931, 425, 200, 50, true)};
			spawnx = 205;
			spawny = 650;
			shroom = new Mushroom(1, 763, 500, 50, 50, true);
			break;
		case 2: // Orange
			background = new ImageIcon("Orange.png").getImage();
			orb = new ImageIcon("Orange Orb.png").getImage();
			orbx = 225;
			orby = 100;
			platforms = new Platform[] {new Platform(100, 800, 300, 50, true), new Platform(100, 200, 300, 50, true), new Platform(1200, 400, 300, 50, true),
					new Platform(567, 667, 200, 50, true), new Platform(883, 533, 200, 50, true), new Platform(567, 350, 200, 50, true)};
			spawnx = 205;
			spawny = 650;
			shroom = new Mushroom(2, 1325, 350, 50, 50, true);
			break;
		case 3: //Green
			background = new ImageIcon("Green.png").getImage();
			orb = new ImageIcon("Green Orb.png").getImage();
			orbx = 1300;
			orby = 100;
			platforms = new Platform[] {new Platform(1175, 200, 300, 50, true), new Platform(100, 450, 200, 50, true),
					new Platform(400, 600, 200, 50, true), new Platform(700, 400, 200, 50, true), new Platform(900, 300, 200, 50, true),
					new Platform(650, 800, 200, 50, true), new Platform(1100, 800, 200, 50, true)};
			spawnx = 155;
			spawny = 300;
			shroom = new Mushroom(3, 1175, 750, 50, 50, true);
			break;
		case 4: //Blue
			background = new ImageIcon("Blue.png").getImage();
			orb = new ImageIcon("Blue Orb.png").getImage();
			orbx = 1375;
			orby = 150;
			platforms = new Platform[] {new Platform(1250, 250, 300, 50, true), new Platform(100, 300, 300, 50, true),
					new Platform(500, 400, 200, 50, true), new Platform(850, 400, 200, 50, true), new Platform(1300, 600, 200, 50, true),
					new Platform(100, 800, 200, 50, true), new Platform(550, 800, 200, 50, true), new Platform(850, 700, 200, 50, true)};
			spawnx = 205;
			spawny = 150;
			shroom = new Mushroom(4, 175, 750, 50, 50, true);
			break;
		case 5: //Purple
			background = new ImageIcon("Purple.png").getImage();
			orb = new ImageIcon("Purple Orb.png").getImage();
			orbx = 1325;
			orby = 700;
			platforms = new Platform[] {new Platform(1200, 800, 300, 50, true), new Platform(100, 800, 300, 50, true),
					new Platform(488, 800, 150, 50, true), new Platform(725, 800, 150, 50, true), new Platform(963, 800, 150, 50, true),
					new Platform(400, 600, 200, 50, true), new Platform(700, 450, 200, 50, true), new Platform(1000, 300, 200, 50, true)};
			spawnx = 200;
			spawny = 650;
			shroom = new Mushroom(5, 1075, 250, 50, 50, true);
			break;
		case 6: //Pink
			background = new ImageIcon("Pink.png").getImage();
			orb = new ImageIcon("Pink Orb.png").getImage();
			orbx = 225;
			orby = 150;
			platforms = new Platform[] {new Platform(1200, 800, 300, 50, true), new Platform(100, 250, 300, 50, true),
					new Platform(500, 425, 150, 50, true), new Platform(750, 550, 150, 50, true), new Platform(1000, 675, 150, 50, true),
					new Platform(200, 800, 150, 50, true)};
			spawnx = 1300;
			spawny = 650;
			shroom = new Mushroom(6, 250, 750, 50, 50, true);
			break;
		case 7: //Gray
			background = new ImageIcon("Gray.png").getImage();
			orb = new ImageIcon("Gray Orb.png").getImage();
			orbx = 1375;
			orby = 200;
			platforms = new Platform[] {new Platform(700, 800, 200, 50, true), new Platform(1300, 300, 200, 50, true),
					new Platform(100, 300, 200, 50, true), new Platform(333, 467, 150, 50, true), new Platform(517, 633, 150, 50, true), 
					new Platform(933, 633, 150, 50, true), new Platform(1117, 467, 150, 50, true)};
			spawnx = 750;
			spawny = 650;
			shroom = new Mushroom(7, 175, 250, 50, 50, true);
			break;
		case 8: //Brown
			background = new ImageIcon("Brown.png").getImage();
			orb = new ImageIcon("Brown Orb.png").getImage();
			orbx = 1275;
			orby = 700;
			platforms = new Platform[] {new Platform(100, 400, 300, 50, true), new Platform(1200, 800, 200, 50, true),
					new Platform(1200, 200, 200, 50, true), new Platform(500, 300, 150, 50, true), new Platform(883, 250, 150, 50, true),
					new Platform(467, 600, 150, 50, true), new Platform(883, 750, 150, 50, true)};
			spawnx = 200;
			spawny = 250;
			shroom = new Mushroom(8, 1275, 150, 50, 50, true);
			break;
		}
	}
	
	public void draw(Graphics g, ImageObserver obs) {
		g.drawImage(background, 0, 0, 1600, 900, obs);
		for(Platform p : platforms) {
			p.draw(g, obs);
		}
		shroom.draw(g, obs);
		g.drawImage(orb, orbx, orby, 50, 50, obs);
	}
	
	public Platform[] getPlatforms() {
		return platforms;
	}
	
	public Rectangle getOrbHitbox() {
		return new Rectangle(orbx, orby, 50, 50);
	}
	
	public Mushroom getShroom() {
		return shroom;
	}
	
	public int getSpawnX() {
		return spawnx;
	}
	
	public int getSpawnY() {
		return spawny;
	}
}
