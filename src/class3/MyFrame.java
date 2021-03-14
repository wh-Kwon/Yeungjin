package class3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener{
	private WelcomePanel welcomePanel = new WelcomePanel();
	private TypePanel typePanel = new TypePanel();
	private ToppingPanel toppingPanel = new ToppingPanel();
	private SizePanel sizePanel = new SizePanel();
	private JButton orderButton, cancelButton;
	private JTextField text;
	private int temp1 = 13000, temp2 = 1000, temp3 = 3000, sum = 0;
	
	public MyFrame() {
		setTitle("���� �ֹ�");
		setSize(500,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JPanel downPanel = new JPanel();
		orderButton = new JButton("�ֹ�");
		orderButton.addActionListener(this);
		cancelButton = new JButton("���");
		cancelButton.addActionListener(this);
		
		text = new JTextField();
		text.setEditable(false);
		text.setColumns(6);
		
		downPanel.add(orderButton);
		downPanel.add(cancelButton);
		downPanel.add(text);
		
		setLayout(new BorderLayout());
		add(welcomePanel, BorderLayout.NORTH);
		add(typePanel, BorderLayout.WEST);
		add(toppingPanel, BorderLayout.CENTER);
		add(sizePanel, BorderLayout.EAST);
		add(downPanel, BorderLayout.SOUTH);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.orderButton) {
			sum = temp1 + temp2 + temp3;
			text.setText(" " + sum);
		}
		if(e.getSource() == this.cancelButton) {
			temp1 = 0;
			temp2 = 0;
			temp3 = 0;
			sum = 0;
			text.setText(" " + sum);
		}
	}
	
	class WelcomePanel extends JPanel {
		public WelcomePanel() {
			JLabel label = new JLabel("�ڹ� ���ڿ� ���� ���� ȯ���մϴ�.");
			add(label);
		}
	}
	
	class TypePanel extends JPanel {
		private JRadioButton combo, potato, bulgogi;
		
		public TypePanel() {
			setLayout(new GridLayout(3,1));
			combo = new JRadioButton("�޺�(13,000��)",true);
			combo.addActionListener(e -> {
				temp1 = 13000;
			});
			potato = new JRadioButton("��������(13,000��)");
			potato.addActionListener(e -> {
				temp1 = 13000;
			});
			bulgogi = new JRadioButton("�Ұ��(14,000��)");
			bulgogi.addActionListener(e -> {
				temp1 = 14000;
			});
			ButtonGroup bg = new ButtonGroup();
			setBorder(BorderFactory.createTitledBorder("����"));
			bg.add(combo);
			bg.add(potato);
			bg.add(bulgogi);
			add(combo);
			add(potato);
			add(bulgogi);
		}
	}
	
	class ToppingPanel extends JPanel {
		private JRadioButton pepper, cheese, peperoni, bacon;
		public ToppingPanel() {
			setLayout(new GridLayout(4,1));
			pepper = new JRadioButton("�Ǹ�(500��)");
			pepper.addActionListener(e-> {
				temp2 = 500;
			});
			cheese = new JRadioButton("ġ��(1,000��)",true);
			cheese.addActionListener(e-> {
				temp2 = 1000;
			});
			peperoni = new JRadioButton("����δ�(500��)");
			peperoni.addActionListener(e-> {
				temp2 = 500;
			});
			bacon = new JRadioButton("������(1,000��)");
			bacon.addActionListener(e-> {
				temp2 = 1000;
			});
			ButtonGroup bg = new ButtonGroup();
			setBorder(BorderFactory.createTitledBorder("�߰�����"));
			bg.add(pepper);
			bg.add(cheese);
			bg.add(peperoni);
			bg.add(bacon);
			add(pepper);
			add(cheese);
			add(peperoni);
			add(bacon);
		}
	}
	
	class SizePanel extends JPanel {
		private JRadioButton small, medium, large;
		public SizePanel() {
			setLayout(new GridLayout(3,1));
			small = new JRadioButton("Small(-2000��)");
			small.addActionListener(e -> {
				temp3 = -2000;
			});	
			medium = new JRadioButton("Medium");
			medium.addActionListener(e -> {
				temp3 = 0;
			});
			large = new JRadioButton("Large(3000��)",true);
			large.addActionListener(e -> {
				temp3 = 3000;
			});
			ButtonGroup bg = new ButtonGroup();
			setBorder(BorderFactory.createTitledBorder("ũ��"));
			bg.add(small);
			bg.add(medium);
			bg.add(large);
			add(small);
			add(medium);
			add(large);
		}
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}

}
