package minipingpong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Score {
	private static int GAME_WIDTH;
	private static int GAME_HEIGHT;
	protected static int leftScore = 0;
	protected static int rightScore = 0;
	
	public Score(int gameWidth, int gameHeight) {
		GAME_WIDTH = gameWidth;
		GAME_HEIGHT = gameHeight;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("DialogInput", Font.PLAIN, 50));
		g.drawLine(GAME_WIDTH/2, 0, GAME_WIDTH/2, GAME_HEIGHT);
		g.drawString(String.format("%02d", leftScore) + " " + (String.format("%02d", rightScore)), GAME_WIDTH/2 - 77, 40);
	}
}
