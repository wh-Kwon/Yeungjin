package baseball;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Baseball extends JFrame {
	private JFrame frame;
	private InitPanel initPanel = new InitPanel();
	private PlayPanel playPanel = new PlayPanel();
	private PauseModal pauseModal = new PauseModal(frame);
	private SuccessModal successModal = new SuccessModal(frame);
	public Baseball() {
		frame = new JFrame();
		frame.setTitle("Baseball Game");
		frame.setSize(500,500);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(playPanel);
		frame.getContentPane().add(initPanel);
		playPanel.setVisible(false);
		
		frame.setVisible(true);
		
	}
	class InitPanel extends JPanel {
		public InitPanel() {
			setSize(500,500);
			setBackground(Color.LIGHT_GRAY);
			setLayout(null);

			JLabel l1 = new JLabel("BASE");
			l1.setForeground(new Color(220,0,0));
			JLabel l2 = new JLabel("BALL");
			l2.setForeground(Color.WHITE);
			JButton startButton = new JButton("PLAY");
			JButton exitButton = new JButton("EXIT");

			l1.setFont(new Font("Ink Free", Font.BOLD, 80));
			l2.setFont(new Font("Ink Free", Font.BOLD, 80));
			startButton.setFont(new Font("Ink Free", Font.BOLD, 40));
			exitButton.setFont(new Font("Ink Free", Font.BOLD, 40));
			startButton.setBackground(Color.LIGHT_GRAY);
			exitButton.setBackground(Color.LIGHT_GRAY);
			startButton.setBorder(null);
			exitButton.setBorder(null);
			startButton.setFocusPainted(false);
			exitButton.setFocusPainted(false);

			l1.setBounds(35, 100, 260, 80);
			l2.setBounds(245, 100, 260, 80);
			startButton.setBounds(122, 240, 240, 50);
			exitButton.setBounds(122, 330, 240, 50);

			startButton.addActionListener(e -> {
				playPanel.setVisible(true);
				initPanel.setVisible(false);
			});
			exitButton.addActionListener(e -> {
				System.exit(0);
			});

			add(l1);
			add(l2);
			add(startButton);
			add(exitButton);
		}
	}
	class PlayPanel extends JPanel {
		private String[] answer =  new String[3];
		private String[] inputValue = new String[3];
		private JTextField inputTextField = new JTextField();
		private JLabel countLabel = new JLabel();
		private int limitNumberButton;
		private boolean limitEnterButton;
		private int strike;
		private int ball;
		private int out;
		private int count;
		public PlayPanel() {
			newGameStart();
			setSize(500,500);
			setBackground(Color.LIGHT_GRAY);
			setLayout(null);

			JButton pause = new JButton("I I");
			pause.setFont(new Font("", Font.BOLD, 17));
			pause.setForeground(Color.WHITE);
			pause.setBackground(new Color(150,150,150));
			pause.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			pause.setBounds(10,10,36,36);
			pause.setFocusPainted(false);
			pause.addActionListener(e -> {
				pauseModal.setVisible(true);
			});
			
			countLabel.setText(count + " times");
			countLabel.setFont(new Font("Ink Free", Font.BOLD, 35));
			countLabel.setForeground(Color.DARK_GRAY);
			countLabel.setBounds(310,0,200,95);

			inputTextField.setBounds(208,91,266,180);
			inputTextField.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
			inputTextField.setHorizontalAlignment(JTextField.CENTER);
			inputTextField.setFont(new Font("DialogInput", Font.BOLD, 120));
			inputTextField.setEditable(false);
			inputTextField.setBackground(new Color(245,245,245));

			JPanel buttonPanel = new JPanel();
			buttonPanel.setBackground(Color.LIGHT_GRAY);
			buttonPanel.setLayout(new GridLayout(0, 6, 10, 10));
			buttonPanel.setBounds(10,281,464,170);
			String[] buttonTexts = {"0", "1", "2", "3", "4", "C", "5", "6", "7", "8", "9", "E"};
			JButton[] buttons = new JButton[buttonTexts.length];
			for(int i = 0; i<buttonTexts.length; i++) {
				buttons[i] = new JButton(buttonTexts[i]);
				buttons[i].setFont(new Font("DialogInput", Font.BOLD, 30));
				buttons[i].setFocusPainted(false);
				buttons[i].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
				if(i==5) {
					buttons[i].setForeground(Color.WHITE);
					buttons[i].setBackground(new Color(255,128,128));
					buttons[i].addActionListener(e -> {
						limitNumberButton = 0;
						limitEnterButton = true;
						inputTextField.setText("");
						strike = 0;
						ball = 0;
						out = 0;
						repaint();
					});
				} else if(i==11) {
					buttons[i].setForeground(Color.WHITE);
					buttons[i].setBackground(new Color(150,150,150));
					buttons[i].addActionListener(e -> {
						if(limitEnterButton && inputTextField.getText().length() == 3) {
							for(int j=0; j<answer.length; j++) {
								boolean catchOut = true;
								for (int k=0; k<inputValue.length; k++) {
									if(inputValue[j].equals(answer[k])) {
										if(inputValue[j].equals(answer[j])) strike++;
										else ball++;
										catchOut = false;
										break;
									}
								}
								if(catchOut) {
									out++;
								}
							}
							repaint();
							count++;
							if(count == 1) {
								countLabel.setText(count + " time");
								countLabel.setBounds(330,0,200,95);
							} else {
								countLabel.setText(count + " times");
								countLabel.setBounds(310,0,200,95);
							}
							limitEnterButton = false;
							if(strike == 3) {
								successModal.setVisible(true);
							}
						}
					});
				} else {
					buttons[i].setBackground(new Color(245,245,245));
					buttons[i].addActionListener(e -> {
						String click = e.getActionCommand();
						if(limitNumberButton<=2) {
							inputValue[limitNumberButton] = click;
							int j = 0;
							for(; j<limitNumberButton; j++) {
								if(inputValue[j].equals(click)) {
									break;
								}
							}
							if(j == limitNumberButton) {
								inputTextField.setText(inputTextField.getText() + click);
								limitNumberButton++;
							}
						}
					});
				}
				buttonPanel.add(buttons[i]);
			}
			add(pause);
			add(countLabel);
			add(inputTextField);
			add(buttonPanel);
		}
		public void newGameStart() {
			for(int i=0; i<answer.length; i++) {
				answer[i] = "" + (int)(Math.random()*10);
				for(int j=0; j<i; j++) {
					if(answer[i].equals(answer[j])) {
						i--;
					}
				}
			}
			limitNumberButton = 0;
			limitEnterButton = true;
			strike = 0;
			ball = 0;
			out = 0;
			count = 0;
			inputTextField.setText("");
			countLabel.setText(count + " times");
			repaint();			
		}
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(new Color(150,150,150));
			g.fillRect(10,91,188,180);
			g.setColor(Color.BLACK);
			g.drawRect(10,91,188,180);
			g.setColor(Color.WHITE);
			g.setFont(new Font("SansSerif", Font.BOLD, 35));
			g.drawString("S", 25, 141);
			g.drawString("B", 25, 196);
			g.drawString("O", 25, 251);
			for(int i=0; i<=2; i++) {
				for(int j=0; j<=2; j++) {
					g.setColor(Color.DARK_GRAY);
					if(i<strike && j==0) {
						g.setColor(Color.YELLOW);
					}
					if(i<ball && j==1) {
						g.setColor(Color.GREEN);
					}
					if(i<out && j==2) {
						g.setColor(Color.RED);
					}
					g.fillOval(67+40*i, 113+55*j, 30, 30);
					g.setColor(Color.BLACK);
					g.drawOval(67+40*i, 113+55*j, 30, 30);
				}
			}
		}
	}
	class PauseModal extends JDialog {
		public PauseModal(JFrame f) {
			super(f, "", true);
			setSize(216,219);
			setLocationRelativeTo(null);
			
			JPanel pausePanel = new JPanel();
			pausePanel.setBackground(Color.LIGHT_GRAY);
			pausePanel.setLayout(null);
			
			JButton play = new JButton("PLAY");
			JButton newGame = new JButton("NEW GAME");
			JButton end = new JButton("END");
			
			play.setFont(new Font("Serif", Font.PLAIN, 20));
			newGame.setFont(new Font("Serif", Font.PLAIN, 20));
			end.setFont(new Font("Serif", Font.PLAIN, 20));
			
			play.setBackground(new Color(150,150,150));
			newGame.setBackground(new Color(150,150,150));
			end.setBackground(new Color(150,150,150));
			
			play.setForeground(Color.WHITE);
			end.setForeground(Color.WHITE);
			newGame.setForeground(Color.WHITE);
			
			play.setFocusPainted(false);
			newGame.setFocusPainted(false);
			end.setFocusPainted(false);
			
			play.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			newGame.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			end.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			
			play.setBounds(15,15,170,40);
			newGame.setBounds(15,70,170,40);
			end.setBounds(15,125,170,40);
			
			play.addActionListener(e -> {
				dispose();
			});
			newGame.addActionListener(e -> {
				playPanel.newGameStart();
				dispose();
			});
			end.addActionListener(e -> {
				playPanel.newGameStart();
				playPanel.setVisible(false);
				initPanel.setVisible(true);
				dispose();
			});
			
			pausePanel.add(play);
			pausePanel.add(newGame);
			pausePanel.add(end);
			
			add(pausePanel);
		}
	}
	class SuccessModal extends JDialog {
		public SuccessModal(JFrame f) {
			super(f, "", true);
			setSize(216,219);
			setLocationRelativeTo(null);
			JPanel successPanel = new JPanel();
			successPanel.setBackground(Color.LIGHT_GRAY);
			successPanel.setLayout(null);
			
			JLabel sign = new JLabel("Success");
			sign.setFont(new Font("Ink Free", Font.BOLD, 35));
			sign.setBounds(40,15,150,40);
			
			JButton again = new JButton("TRY AGAIN");
			again.setFont(new Font("Ink Free", Font.BOLD, 15));
			again.setBackground(new Color(150,150,150));
			again.setFocusPainted(false);
			again.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			again.setBounds(15,70,170,40);
			again.addActionListener(e -> {
				playPanel.newGameStart();
				dispose();
			});
			JButton exitButton2 = new JButton("EXIT");
			exitButton2.setFont(new Font("Ink Free", Font.BOLD, 15));
			exitButton2.setBackground(new Color(150,150,150));
			exitButton2.setFocusPainted(false);
			exitButton2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			exitButton2.setBounds(15,125,170,40);
			exitButton2.addActionListener(e -> {
				System.exit(0);
			});
			successPanel.add(sign);
			successPanel.add(again);
			successPanel.add(exitButton2);
			add(successPanel);
		}
	}
	public static void main(String[] args) {
		new Baseball();
	}
}
