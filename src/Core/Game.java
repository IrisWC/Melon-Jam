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
	
	private boolean atMenu, atStart, inDimensions, atEnd, atCredit;
	private boolean leftPressed, rightPressed, upPressed;
	
	public Game() {
		super();
		dimensions = new Dimension[] {new Dimension(1), new Dimension(2), new Dimension(3), new Dimension(4),
				new Dimension(5), new Dimension(6), new Dimension(7), new Dimension(8)};
		player = new Player(205, 650, 90, 150);
		
		atMenu = true;
		atStart = false;
		inDimensions = false;
		atEnd = false;
		atCredit = false;
		
		currentDimension = 0;
		currentText = 1;
	}

	public void run() {
		while(atStart || atMenu) {
			repaint();
	  		
	  		try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
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
		
		while(atEnd || atCredit) {
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
	    
	    if(atMenu) {
	    	g.drawImage(new ImageIcon("Menu.png").getImage(), 0, 0, 1600, 900, this);
	    }
	    
	    if(atStart)  {
	    	g.drawImage(new ImageIcon("Home.png").getImage(), 0, 0, 1600, 900, this);
	    	g.drawImage(new ImageIcon("Witch Right.png").getImage(), 324, 372, 90, 150, this);
	    	g.drawImage(new ImageIcon("Start " + currentText + ".png").getImage(), 75, 625, 1450, 200, this);
	    }
	    
	    
	    if(inDimensions)  {
	    	dimensions[currentDimension].draw(g, this);
			player.draw(g, this);

			if (player.checkRespawn()) {
				player.moveTo(dimensions[currentDimension].getSpawnX(), dimensions[currentDimension].getSpawnY());
				player.stop();
			}
	    }
	    
	    if(atEnd) {
	    	g.drawImage(new ImageIcon("Home.png").getImage(), 0, 0, 1600, 900, this);
	    	g.drawImage(new ImageIcon("Witch Right.png").getImage(), 324, 372, 90, 150, this);
	    	g.drawImage(new ImageIcon("End " + currentText + ".png").getImage(), 75, 625, 1450, 200, this);
	    }
	    
	    if(atCredit) {
	    	g.drawImage(new ImageIcon("Credits.png").getImage(), 0, 0, 1600, 900, this);
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
			if(atMenu) {
				atMenu = false;
				atStart = true;
			}
			else if(atStart) {
	  			if(currentText != 12)
	  				currentText++;
	  			else {
	  				inDimensions = true;
	  				atStart = false;
	  			}
	  		}
	  		else if (inDimensions) {
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
					toggleEnd();
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
					toggleEnd();
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
	
	private void toggleEnd() {
		int shroomCount = player.countShrooms();
		
		JFrame result = new JFrame();
		result.setSize(800, 800);
		result.setLocation(0, 0);
		result.setLocationRelativeTo(null);
		result.setResizable(false);
		
		ImageIcon potion;
		
		if(shroomCount == 0)
			potion = new ImageIcon("Pink Potion.png");
		else if (shroomCount >= 1 && shroomCount <= 3)
			potion = new ImageIcon("Restoration Potion.png");
		else if (shroomCount == 4)
			potion = new ImageIcon("Language Potion.png");
		else if (shroomCount == 7)
			potion = new ImageIcon("Death Potion.png");
		else if (shroomCount == 8)
			potion = new ImageIcon("Clairvoyance Potion.png");
		else
			potion = new ImageIcon("Love Potion.png");
		
		JLabel picLabel = new JLabel(potion);
		picLabel.setSize(800, 800);
		picLabel.setLocation(0, 0);
		result.add(picLabel);
		
		result.setVisible(true);
		
		atEnd = false;
		atCredit = true;
	}
}
