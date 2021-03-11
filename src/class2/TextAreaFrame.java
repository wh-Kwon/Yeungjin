package class2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextAreaFrame extends JFrame implements ActionListener {
	private JTextField textField;
	private JTextArea textArea;
	
	public TextAreaFrame() {
		setTitle("Text Area Test");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		textField = new JTextField(30);
		textField.addActionListener(this);
		textArea = new JTextArea(10,30);
		textArea.setEditable(false);
		
		add(textField, BorderLayout.NORTH);
		add(textArea, BorderLayout.CENTER);
		
		pack();
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		String value = textField.getText();
		textArea.append(value + "\n");
		textField.selectAll();
	}
	
	public static void main(String[] args) {
		new TextAreaFrame();
	}

}
