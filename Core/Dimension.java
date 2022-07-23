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
	
	public Dimension(int type) {
		switch (type) {
		case 1: //Red
			background = new ImageIcon("img\\Red.png").getImage();
			orb = new ImageIcon("img\\Red Orb.png").getImage();
			orbx = 1300;
			orby = 200;
			platforms = new Platform[] {new Platform(1175, 300, 300, 50, true), new Platform(100, 800, 300, 50, true),
					new Platform(444, 675, 200, 50, true), new Platform(688, 550, 200, 50, true), new Platform(931, 425, 200, 50, true)};
			spawnx = 175;
			spawny = 650;
			break;
		case 2: // Orange
			background = new ImageIcon("img\\Orange.png").getImage();
			orb = new ImageIcon("img\\Orange Orb.png").getImage();
			orbx = 1300;
			orby = 200;
			platforms = new Platform[] {new Platform(1175, 300, 300, 50, true), new Platform(100, 800, 300, 50, true),
					new Platform(444, 675, 200, 50, true), new Platform(688, 550, 200, 50, true), new Platform(931, 425, 200, 50, true)};
			spawnx = 175;
			spawny = 650;
			break;
		case 3: //Green
			background = new ImageIcon("img\\Green.png").getImage();
			orb = new ImageIcon("img\\Green Orb.png").getImage();
			orbx = 1300;
			orby = 200;
			platforms = new Platform[] {new Platform(1175, 300, 300, 50, true), new Platform(100, 800, 300, 50, true),
					new Platform(444, 675, 200, 50, true), new Platform(688, 550, 200, 50, true), new Platform(931, 425, 200, 50, true)};
			spawnx = 175;
			spawny = 650;
			break;
		case 4: //Blue
			background = new ImageIcon("img\\Blue.png").getImage();
			orb = new ImageIcon("img\\Blue Orb.png").getImage();
			orbx = 1300;
			orby = 200;
			platforms = new Platform[] {new Platform(1175, 300, 300, 50, true), new Platform(100, 800, 300, 50, true),
					new Platform(444, 675, 200, 50, true), new Platform(688, 550, 200, 50, true), new Platform(931, 425, 200, 50, true)};
			spawnx = 175;
			spawny = 650;
			break;
		case 5: //Purple
			background = new ImageIcon("img\\Purple.png").getImage();
			orb = new ImageIcon("img\\Purple Orb.png").getImage();
			orbx = 1300;
			orby = 200;
			platforms = new Platform[] {new Platform(1175, 300, 300, 50, true), new Platform(100, 800, 300, 50, true),
					new Platform(444, 675, 200, 50, true), new Platform(688, 550, 200, 50, true), new Platform(931, 425, 200, 50, true)};
			spawnx = 175;
			spawny = 650;
			break;
		case 6: //Pink
			background = new ImageIcon("img\\Pink.png").getImage();
			orb = new ImageIcon("img\\Pink Orb.png").getImage();
			orbx = 1300;
			orby = 200;
			platforms = new Platform[] {new Platform(1175, 300, 300, 50, true), new Platform(100, 800, 300, 50, true),
					new Platform(444, 675, 200, 50, true), new Platform(688, 550, 200, 50, true), new Platform(931, 425, 200, 50, true)};
			spawnx = 175;
			spawny = 650;
			break;
		case 7: //Gray
			background = new ImageIcon("img\\Gray.png").getImage();
			orb = new ImageIcon("img\\Gray Orb.png").getImage();
			orbx = 1300;
			orby = 200;
			platforms = new Platform[] {new Platform(1175, 300, 300, 50, true), new Platform(100, 800, 300, 50, true),
					new Platform(444, 675, 200, 50, true), new Platform(688, 550, 200, 50, true), new Platform(931, 425, 200, 50, true)};
			spawnx = 175;
			spawny = 650;
			break;
		case 8: //Brown
			background = new ImageIcon("img\\Brown.png").getImage();
			orb = new ImageIcon("img\\Brown Orb.png").getImage();
			orbx = 1300;
			orby = 200;
			platforms = new Platform[] {new Platform(1175, 300, 300, 50, true), new Platform(100, 800, 300, 50, true),
					new Platform(444, 675, 200, 50, true), new Platform(688, 550, 200, 50, true), new Platform(931, 425, 200, 50, true)};
			spawnx = 175;
			spawny = 650;
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
	
	public Rectangle getOrbHitbox() {
		return new Rectangle(orbx, orby, 50, 50);
	}
	
	public int getSpawnX() {
		return spawnx;
	}
	
	public int getSpawnY() {
		return spawny;
	}
}
