package class2;

import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextFieldFrame extends JFrame implements ActionListener {
	private JTextField input, output;
	private JButton ok;
	
	public TextFieldFrame() {
		setSize(300,130);
		setTitle("제곱 계산하기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.add(new JLabel("숫자 입력 : "));
		input = new JTextField(15);
		input.addActionListener(this);
		panel.add(input);
		
		panel.add(new JLabel("제곱한 값 : "));
		output = new JTextField(15);
		output.setEditable(false);
		panel.add(output);
		
		ok = new JButton("OK");
		ok.addActionListener(this);
		panel.add(ok);
		
		add(panel);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ok || e.getSource() == input) {
			String inputValue = input.getText();
			int value = Integer.parseInt(inputValue);
			output.setText("" + value*value);
			input.requestFocus();
		}
	}
	
	public static void main(String[] args) {
		new TextFieldFrame();
	}

}