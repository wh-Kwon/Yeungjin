package class4;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

// 연산자 우선순위 적용하는 방법은 아직...
public class Calculator extends JFrame implements ActionListener{
	private JPanel panel;
	private JPanel centerPanel;
	private JPanel bottomPanel;
	private JTextField textField;
	private JButton[][] centerButtons = new JButton[4][4];
	private String[][] centerLabels = {
			{"1","2","3","+"}, {"4","5","6","-"},
			{"7","8","9","*"}, {".","0","=","/"}
	};
	private JButton[] bottomButtons = new JButton[3];
	private String[] bottomLabels = {"(-)", "Delete", "Clear"};
	private ArrayList<String> fullText = new ArrayList<>();
	private boolean startOfNumber = true;
	private String text = "";
	private String num = "";
	
	public Calculator() {
		setSize(282,390);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		textField = new JTextField(10);
		textField.setEditable(false);
		textField.setText(text);
		textField.setFont(new Font("Serif",Font.BOLD,20));
		textField.setBackground(new Color(200,200,200));
		textField.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		textField.setHorizontalAlignment(JTextField.RIGHT);
		//centerPanel
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(0,4,10,10));
		for(int i=0; i<centerButtons.length; i++) {
			for(int j=0; j<centerButtons[i].length; j++) {
				centerButtons[i][j] = new JButton(centerLabels[i][j]);
				centerButtons[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				centerButtons[i][j].setBackground(Color.WHITE);
				centerButtons[i][j].setFocusPainted(false);
				centerButtons[i][j].addActionListener(this);
				centerPanel.add(centerButtons[i][j]);
			}
		}
		
		//bottomPanel
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(0,3,10,10));
		for(int i=0; i<bottomLabels.length; i++) {
			bottomButtons[i] = new JButton(bottomLabels[i]);
			bottomButtons[i].setBackground(Color.WHITE);
			bottomButtons[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			bottomButtons[i].setFocusPainted(false);
			bottomButtons[i].addActionListener(this);
			bottomPanel.add(bottomButtons[i]);
		}
		
		textField.setBounds(10,10,246,45);
		centerPanel.setBounds(10,65,246,220);
		bottomPanel.setBounds(10,295,247,45);
		
		panel.add(textField);
		panel.add(centerPanel);
		panel.add(bottomPanel);
		add(panel);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals("Clear")) {
			textField.setText("");
		} else if(command.equals("Delete")) {
			String input = textField.getText();
			if(input.length() >= 1) {
				textField.setText(input.substring(0,input.length()-1));
			}
		} else if(command.equals("=")) {
			textField.setText(calculate(textField.getText())+"");
			num = "";
		} else {
			textField.setText(textField.getText() + command);
		}
	}
	
	public void toList(String s) {
		fullText.clear();
		for(int i=0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == '+' || c == '-' || c == '*' || c == '/') {
				fullText.add(num);
				num = "";
				fullText.add(c + "");
			} else {
				num += c;
			}
		}
		fullText.add(num);
	}
	
	public double calculate(String s) {
		toList(s);
		double result = 0;
		double n = 0;
		String operator = ""; 
		for(String a : fullText) {
			if(a.equals("+")) {
				operator = "+";
			} else if(a.equals("-")) {
				operator = "-";
			} else if(a.equals("*")) {
				operator = "*";
			} else if(a.equals("/")) {
				operator = "/";
			} else {
				n = Double.parseDouble(a);
				if(operator.equals("+")) {
					result += n;
				} else if(operator.equals("-")) {
					result -= n;
				} else if(operator.equals("*")) {
					result *= n;
				} else if(operator.equals("/")) {
					result /= n;
				} else {
					result = n;
				}
			}
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		new Calculator();
	}

}
