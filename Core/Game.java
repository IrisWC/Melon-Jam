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
	private boolean leftPressed, rightPressed, upPressed;
	
	public Game() {
		super();
		dimensions = new Dimension[] {new Dimension(1), new Dimension(2), new Dimension(3), new Dimension(4),
				new Dimension(5), new Dimension(6), new Dimension(7), new Dimension(8)};
		player = new Player(175, 650, 150, 150);
		inDimensions = true;
	}

	public void run() {
		while(inDimensions) {
			if (leftPressed) {
	  			player.move(-1);
	  	  	} else if (rightPressed) {
	  	  		player.move(1);
	  	  	} else if (upPressed) {
	  	  		player.jump();
	  	  	}
	  	  	
	  		player.act(dimensions[0].getPlatforms());
	  		
	  		repaint();
	  		
	  		try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
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
	    player.draw(g, this);
	    
	    g2.setTransform(at);
	}

	public void keyPressed(KeyEvent e) {
	  	if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			leftPressed = true;
	  	} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
	  		rightPressed = true;
	  	} else if (e.getKeyCode() == KeyEvent.VK_UP) {
	  		upPressed = true;
	  	}
	  }
	    
	  public void keyReleased(KeyEvent e) {
	    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			leftPressed = false;
	  	} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
	  		rightPressed = false;
	  	} else if (e.getKeyCode() == KeyEvent.VK_UP) {
	  		upPressed = false;
	  	}
	  }

	public void keyTyped(KeyEvent e) {

	}
}
