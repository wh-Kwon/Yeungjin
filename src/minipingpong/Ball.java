package minipingpong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Ball {
	private static final int RADIUS = 8;
	private MiniPingPongGame game;
	private int x = MiniPingPongGame.GAME_WIDTH/2 - RADIUS;
	private int y = MiniPingPongGame.GAME_HEIGHT/2 - 25;
	private int xSpeed = 2, ySpeed = 2;
	private Color color;
	
	public Ball(MiniPingPongGame game, Color color) {
		this.game = game;
		this.color = color;
	}
	
	public void restart(char winner) {
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		if (winner == 'L') {
			xSpeed = -2;
		} else if (winner == 'R') {
			xSpeed = 2;
		}
		if((int)Math.random() == 1) {
			ySpeed = 2;
		} else {
			ySpeed = -2;
		}
	}
	
	public void reset() {
		try {
			Thread.sleep(400);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		x = MiniPingPongGame.GAME_WIDTH/2 - RADIUS;
		y = MiniPingPongGame.GAME_HEIGHT/2 - 25;
		xSpeed = 0;
		ySpeed = 0;
	}
	
	public void move() {
		if(x + xSpeed < 0) {
			Score.rightScore++;
			reset();
			game.setIsReset(true);
			game.setWinner('R');
		}
		if(x + xSpeed > game.getWidth() - 2*RADIUS) {
			Score.leftScore++;
			reset();
			game.setIsReset(true);
			game.setWinner('L');
		}
		if(y + ySpeed < 0) 
			ySpeed = 2;
		if(y + ySpeed > game.getHeight() - 2*RADIUS)
			ySpeed = -2;
		if(collision()) 
			xSpeed = -xSpeed;
		x += xSpeed;
		y += ySpeed;
	}
	
	private boolean collision() {
		return getBounds().intersects(game.racquet1.getBounds())
				|| getBounds().intersects(game.racquet2.getBounds());
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, 2*RADIUS, 2*RADIUS);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 2*RADIUS, 2*RADIUS);
	}
		
}
