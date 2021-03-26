package minipingpong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Racquet {
	private MiniPingPongGame game;
	private static final int WIDTH = 15;
	private static final int HEIGHT = 65;
	private int x=0, y=0;
	private int ySpeed = 0;
	private Color color;
	
	public Racquet(MiniPingPongGame game, int x, int y, Color color) {
		this.game = game;
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	public void move() {
		if(y+ySpeed > 0 && y+ySpeed < game.getHeight() - HEIGHT) {
			y += ySpeed;
		}
	}
	
	public void reset() {
		y = (game.getHeight()-HEIGHT)/2;
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}
	
	public void keyPressed(KeyEvent e, char loc) {
		if(loc == 'L') {
			if(e.getKeyCode() == KeyEvent.VK_W) {
				ySpeed = -3;
			} else if (e.getKeyCode() == KeyEvent.VK_S) {
				ySpeed = 3;
			}			
		} else if(loc == 'R') {
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				ySpeed = -3;
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				ySpeed = 3;
			}
		}
	}
		
	public void keyReleased(KeyEvent e, char loc) {
		if(loc == 'L') ySpeed = 0;
		else if(loc =='R') ySpeed = 0;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
}
