package class4;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TicTaeToe extends JFrame implements ActionListener {
	JButton[][] buttons = new JButton[3][3];
	private char turn = 'X';
	
	public TicTaeToe() {
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,3,5,5));
		for(int i=0; i<buttons.length; i++) {
			for(int j=0; j<buttons[i].length; j++) {
				buttons[i][j] = new JButton(" ");
				buttons[i][j].setFont(new Font("Serif", Font.ITALIC, 50));
				buttons[i][j].addActionListener(this);
				buttons[i][j].setFocusPainted(false);
				panel.add(buttons[i][j]);
			}
		}
		add(panel);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		for(int i=0; i<buttons.length; i++) {
			for(int j=0; j<buttons[i].length; j++) {
				if(e.getSource() == buttons[i][j] && buttons[i][j].getText().equals(" ")) {
					if(turn == 'X') {
						buttons[i][j].setText(turn + "");
						turn = 'O';
						if(checkWin("X",i,j)) {
							System.out.println("X°¡ ÀÌ°åÀ½");
						} else if(isDraw()) {
							System.out.println("ºñ°åÀ½");					
						} 
					} else {
						buttons[i][j].setText(turn + "");
						turn = 'X';
						if(checkWin("O", i, j)) {
							System.out.println("O°¡ ÀÌ°åÀ½");						
						} else if(isDraw()) {							
							System.out.println("ºñ°åÀ½");						
						}					
					}
				}
			}
		}
	}
	
	public boolean isDraw() {
		for(int i=0; i<buttons.length; i++) {
			for(int j=0; j<buttons.length; j++) {
				if(buttons[i][j].getText().equals(" ")) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean checkWin(String icon, int row, int col) {
		if(buttons[row][0].getText().equals(icon) && buttons[row][1].getText().equals(icon) && buttons[row][2].getText().equals(icon)
			||buttons[0][col].getText().equals(icon) && buttons[1][col].getText().equals(icon) && buttons[2][col].getText().equals(icon)
			||buttons[0][0].getText().equals(icon) && buttons[1][1].getText().equals(icon) && buttons[2][2].getText().equals(icon)
			||buttons[0][2].getText().equals(icon) && buttons[1][1].getText().equals(icon) && buttons[2][0].getText().equals(icon)) {
			return true;
		}
		return false;
	}
	
	public boolean checkDraw() {
		boolean result = false;
		return result;
	}
	
	public static void main(String[] args) {
		new TicTaeToe();
	}

}
