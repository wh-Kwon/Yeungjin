package class1;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Spaceship extends JFrame {
	
	public Spaceship() {
		setSize(500,300);
		setTitle("Spaceship");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		add(new MyPanel());
		setVisible(true);
	}
	
	class MyPanel extends JPanel implements ActionListener {
		// 실제크기 483 261 , 사진 크기 53 51
		private final int SCREENWIDTH = 500;
		private final int SCREENHEIGHT = 300;
		private final int START_X = 10;
		private final int START_Y = 200;
		private int x = 0, y = 0;
		private int xSpeed = 1, ySpeed = -1;
		private BufferedImage image;
		private Timer timer;
		
		public MyPanel() {
			File file = new File("./images/spaceship.png");			
			try {
				image = ImageIO.read(file);
			} catch(IOException e) {
				e.printStackTrace();
			}
			x = START_X;
			y = START_Y;
			timer = new Timer(20, this);
			timer.start();
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, x, y, this);
		}
		
		public void actionPerformed(ActionEvent e) {
			if(x + xSpeed > SCREENWIDTH - image.getWidth() - 17) {
				xSpeed = -1;
			} else if(x + xSpeed < 0) {
				xSpeed = 1;
			}
			if(y + ySpeed > SCREENHEIGHT - image.getHeight() - 39) {
				ySpeed = -1;
			} else if(y + ySpeed < 0) {
				ySpeed = 1;
			}
			x += xSpeed;
			y += ySpeed;
			repaint();
		}
		
	}
	
	public static void main(String[] args) {
		new Spaceship();
	}

}
