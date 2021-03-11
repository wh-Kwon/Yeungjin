package class2;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CheckBoxPanel extends JPanel implements ItemListener{
	private JCheckBox[] checkBoxes = new JCheckBox[3];
	private String[] fruits = {"apple","grape","orange"};
	private JLabel[] labels = new JLabel[3];
	private ImageIcon[] icons = new ImageIcon[3];
	
	public CheckBoxPanel() {
		setLayout(new GridLayout(0,4));
		
		for(int i=0; i<checkBoxes.length; i++) {
			checkBoxes[i] = new JCheckBox(fruits[i]);
			checkBoxes[i].addItemListener(this);
			labels[i] = new JLabel(fruits[i] + ".gif");
			icons[i] = new ImageIcon("./images/" + fruits[i] + ".gif");
		}
		JPanel checkBoxPanel = new JPanel(new GridLayout(0,1));
		for(int i=0; i<checkBoxes.length; i++) {
			checkBoxPanel.add(checkBoxes[i]);
		}
		add(checkBoxPanel);
		for(int i=0; i<labels.length; i++) {
			add(labels[i]);
		}
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		ImageIcon image = null;
		Object source = e.getItemSelectable();
		for(int i=0; i<checkBoxes.length; i++) {
			if(source == checkBoxes[i]) {
				if(e.getStateChange() == ItemEvent.DESELECTED) {
					labels[i].setIcon(null);
				} else {
					labels[i].setIcon(icons[i]);
				}				
			}
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("CheckBoxDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CheckBoxPanel panel  = new CheckBoxPanel();
		panel.setOpaque(true);
		frame.add(panel);
		frame.setSize(500,200);
		frame.setVisible(true);
	}

}
