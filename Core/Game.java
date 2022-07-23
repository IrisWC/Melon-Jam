package Core;

import Assets.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

import javax.swing.*;

public class Game extends JPanel implements KeyListener{

	public static final int WIDTH = 1600;
	public static final int HEIGHT = 900;
	
	public Game() {
		super();
	}

	public void run() {

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int width = getWidth();
		int height = getHeight();
		
		double ratioX = (double)width/WIDTH;
	    double ratioY = (double)height/HEIGHT;
	    
	    Graphics2D g2 = (Graphics2D)g;
	    AffineTransform at = g2.getTransform();
	    g2.scale(ratioX,ratioY);
	    
	    g.drawImage(new ImageIcon("img\\Red Orb.png").getImage(), 0, 0, 250, 250, this);
	}

	public void keyPressed(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent e) {

	}
}
