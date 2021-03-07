package class1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import class1.Spaceship.MyPanel;

public class FillShapes extends JFrame {
	
	public FillShapes() {
		setSize(600,130);
		setTitle("FillShapes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		add(new MyPanel());
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		
		private ArrayList<Shape> shapeArray = new ArrayList<Shape>();
		
		public MyPanel() {
			shapeArray.add(new Rectangle2D.Float(10,10,70,70));
			shapeArray.add(new RoundRectangle2D.Float(110,10,70,70,20,20));
			shapeArray.add(new Ellipse2D.Float(210,10,70,70));
			shapeArray.add(new Arc2D.Float(310,10,70,70,50,220,Arc2D.CHORD));
			shapeArray.add(new Arc2D.Float(410,10,70,70,50,220,Arc2D.CHORD));
			shapeArray.add(new Arc2D.Float(510,10,70,70,45,225,Arc2D.PIE));
		}

		public void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setStroke(new BasicStroke(3));
			
			GradientPaint gp = new GradientPaint(0,0,Color.WHITE,0,100,Color.RED);
			
			for(int i=0; i<shapeArray.size(); i++) {
				if(i%2 == 0) g2.setPaint(Color.RED);
				else g2.setPaint(gp);
				g2.fill(shapeArray.get(i));
				g2.draw(shapeArray.get(i));
			}
		}
	}
	
	public static void main(String[] args) {
		new FillShapes();
	}

}
