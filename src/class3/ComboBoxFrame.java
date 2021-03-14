package class3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ComboBoxFrame extends JFrame implements ActionListener {
	private JLabel label;
	private JComboBox list;
	
	public ComboBoxFrame() {
		setTitle("콤보 박스");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		
		String[] animals = {"Dog", "Lion", "Pig"};
		list  = new JComboBox(animals);
		list.setEditable(true);
		list.setSelectedIndex(0);
		list.addActionListener(this);
		
		label = new JLabel();
		label.setHorizontalAlignment(JLabel.CENTER);
		changePicture(animals[list.getSelectedIndex()]);
		add(list, BorderLayout.PAGE_START);
		add(label, BorderLayout.PAGE_END);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		JComboBox cb = (JComboBox) e.getSource();
		String name = (String) cb.getSelectedItem();
		changePicture(name);
	}
	
	public void changePicture(String name) {
		ImageIcon icon = new ImageIcon("./images/" + name + ".gif");
		label.setIcon(icon);
		if(icon != null) label.setText(null);
		else label.setText("이미지가 발견되지 않았습니다.");
	}
	
	public static void main(String[] args) {
		new ComboBoxFrame();
	}

}
