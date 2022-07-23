package Core;

import javax.swing.JFrame;

public class Main {
	public static void main(String args[]) {
		JFrame window = new JFrame();
		window.setSize(1600, 900);
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setExtendedState(JFrame.MAXIMIZED_BOTH); 
	    window.setVisible(true);
	}
}
