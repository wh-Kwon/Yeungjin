package class1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.GeneralPath;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BezierCurve extends JFrame implements MouseListener, MouseMotionListener {
	private int[] xs = {50,150,400,450};
	private int[] ys = {200,50,300,200};
	private int dragIndex = -1;
	
	public BezierCurve() {
		setSize(600,400);
		setTitle("BezierCurve");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		JPanel p1 = new MyPanel();
		p1.addMouseListener(this);
		p1.addMouseMotionListener(this);
		add(p1);
		setVisible(true);
	}
	
	public void mousePressed(MouseEvent e) {
		dragIndex = -1;
		for(int i=0; i<4; i++) {
			Rectangle r = new Rectangle(xs[i] - 4, ys[i] -4, 20, 20);
			if(r.contains(e.getX(), e.getY())) {
				dragIndex = i;
			}
		}
		repaint();
	}

	public void mouseReleased(MouseEvent e) {
		dragIndex = -1;
		repaint();
	}
	
	public void mouseDragged(MouseEvent e) {
		if(dragIndex != -1) {
			xs[dragIndex] = e.getX();
			ys[dragIndex] = e.getY();
		}
		repaint();
	}
	
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}
	
	class MyPanel extends JPanel{
		
		public void paintComponent(Graphics g) {
			g.setColor(Color.blue);
			g.fillRect(xs[0], ys[0], 16, 16);
			g.fillRect(xs[2], ys[2], 16, 16);
			g.setColor(Color.red);
			g.fillRect(xs[1], ys[1], 16, 16);
			g.fillRect(xs[3], ys[3], 16, 16);
			
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(Color.BLACK);
			GeneralPath path = new GeneralPath();
			path.moveTo(xs[0], ys[0]);
			path.curveTo(xs[1], ys[1], xs[2], ys[2], xs[3], ys[3]);
			g2.draw(path);
		}
		
	}
	
	public static void main(String[] args) {
		new BezierCurve();
	}

	
}
