package Core;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {
	public static void main(String args[]) {
		JFrame window = new JFrame("Space Alchemy");
		
		ImageIcon img = new ImageIcon("Blue Orb.png");
		window.setIconImage(img.getImage());
		
		window.setSize(1600, 900);
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setExtendedState(JFrame.MAXIMIZED_BOTH); 
	    
	    Game panel = new Game();
	    
	    window.addKeyListener(panel);
	    window.add(panel);
	    
	    window.setVisible(true);
	    
	    panel.run();
	}
}
