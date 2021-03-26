package minipingpong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


public class MiniPingPongGame extends JPanel implements KeyListener {
	public static final int GAME_WIDTH = 600;
	public static final int GAME_HEIGHT = 400;
	private Ball ball;
	protected Racquet racquet1;
	protected Racquet racquet2;
	private Score score;
	private Image image;
	private Graphics graphics;
	private Boolean isReset = true;
	private char winner = ' ';

	public MiniPingPongGame() {
		ball = new Ball(this, Color.WHITE);
		racquet1 = new Racquet(this, 0, 150, Color.blue);
		racquet2 = new Racquet(this, 569, 150, Color.red);
		score = new Score(GAME_WIDTH, GAME_HEIGHT);
		this.setBackground(Color.BLACK);
		this.setFocusable(true);
		this.addKeyListener(this);
	}
	
	public void keyTyped(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {
		racquet1.keyPressed(e, 'L');
		racquet2.keyPressed(e, 'R');
	}
	public void keyReleased(KeyEvent e) {
		racquet1.keyReleased(e, 'L');
		racquet2.keyReleased(e, 'R');
	}
	
	public void move() {
		ball.move();
		racquet1.move();
		racquet2.move();
	}
	
	@Override
	public void paint(Graphics g) {
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image,0,0,this);
	}
	
	public void draw(Graphics g) {
		super.paint(g);
		ball.draw(g);
		racquet1.draw(g);
		racquet2.draw(g);
		score.draw(g);
	}
	
	public void run() {
		while(true) {
			move();
			if(isReset) {
				racquet1.reset();
				racquet2.reset();
				repaint();
				ball.restart(winner);
				isReset = false;
			} else {
				repaint();				
			}
			try {
				Thread.sleep(10);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void setIsReset(Boolean isReset) {
		this.isReset = isReset;
	}

	public void setWinner(char winner) {
		this.winner = winner;
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("PingPong Game");
		frame.setSize(GAME_WIDTH, GAME_HEIGHT);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		MiniPingPongGame game = new MiniPingPongGame();
		frame.add(game);
		frame.setVisible(true);
		game.run();
	}

}
