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
	private int currentDimension, currentText;
	
	private boolean atStart, inDimensions, atEnd;
	private boolean leftPressed, rightPressed, upPressed;
	
	public Game() {
		super();
		dimensions = new Dimension[] {new Dimension(1), new Dimension(2), new Dimension(3), new Dimension(4),
				new Dimension(5), new Dimension(6), new Dimension(7), new Dimension(8)};
		player = new Player(205, 650, 90, 150);
		
		inDimensions = true;
		atEnd = false;
		
		currentDimension = 0;
		currentText = 0;
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
	  	  	
	  		player.act(dimensions[currentDimension].getPlatforms());
	  		
	  		repaint();
	  		
	  		try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		while(atEnd) {
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
	    
	    if(inDimensions)  {
	    	dimensions[currentDimension].draw(g, this);
	    	player.draw(g, this);
	    }
	    
	    if(player.checkRespawn()) {
	    	player.moveTo(dimensions[currentDimension].getSpawnX(),  dimensions[currentDimension].getSpawnY());
  			player.stop();
	    }
	    
	    if(atEnd) {
	    	g.drawImage(new ImageIcon("Home.png").getImage(), 0, 0, 1600, 900, this);
	    	g.drawImage(new ImageIcon("End " + currentText + ".png").getImage(), 75, 625, 1450, 200, this);
	    }
	    
	    g2.setTransform(at);
	}

	public void keyPressed(KeyEvent e) {
	  	if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			leftPressed = true;
			player.faceLeft();
	  	} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
	  		rightPressed = true;
	  		player.faceRight();
	  	} else if (e.getKeyCode() == KeyEvent.VK_UP) {
	  		upPressed = true;
	  	} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (inDimensions) {
				boolean gotOrb = player.checkForOrb(dimensions[currentDimension].getOrbHitbox());
				player.checkShroom(dimensions[currentDimension].getShroom());
				
				if (gotOrb && currentDimension != 7) {
					currentDimension++;
					player.moveTo(dimensions[currentDimension].getSpawnX(), dimensions[currentDimension].getSpawnY());
					player.stop();
				} else if (gotOrb) {
					inDimensions = false;
					atEnd = true;
					currentText = 1;
				} 
			}
			else if (atEnd) {
				switch(currentText) {
				case 1:
					if(player.countShrooms() == 0)
						currentText = 2;
					else 
						currentText = 4;
					break;
				case 2:
					currentText = 3;
					break;
				case 3:
					break;
				case 4:
					if(player.countShrooms() == 7)
						currentText = 5;
					else if(player.countShrooms() == 8)
						currentText = 6;
					else
						currentText = 7;
					break;
				case 5:
				case 6:
					currentText = 7;
					break;
				case 7:
					break;
				}
			}
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
