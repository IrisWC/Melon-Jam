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
	
	private Player player;
	private Dimension[] dimensions;
	
	private boolean atStart, inDimensions, atEnd;
	
	public Game() {
		super();
		dimensions = new Dimension[] {new Dimension(1), new Dimension(2), new Dimension(3), new Dimension(4),
				new Dimension(5), new Dimension(6), new Dimension(7), new Dimension(8)};
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
	    
	    dimensions[0].draw(g, this);
	    
	    g2.setTransform(at);
	}

	public void keyPressed(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent e) {

	}
}
