package class3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FileChooserTest extends JFrame implements ActionListener	 {
	private JButton openButton, saveButton;
	private JFileChooser fc;
	
	public FileChooserTest() {
		setTitle("���� ���ñ� �׽�Ʈ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		fc = new JFileChooser();
		JPanel panel = new JPanel();
		JLabel label = new JLabel("���� ���ñ� ������Ʈ �׽�Ʈ�Դϴ�.");
		panel.add(label);

		openButton = new JButton("���� ����");
		openButton.addActionListener(this);
		panel.add(openButton);
		
		saveButton = new JButton("���� ����");
		saveButton.addActionListener(this);
		panel.add(saveButton);
		
		add(panel);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		//���� ���¿� ���� �̺�Ʈ ó��
		if(e.getSource() == openButton) {
			int returnVal = fc.showOpenDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
			} else {
				//����� ���
			}
		//���� ���忡 ���� �̺�Ʈ ó��
		} else if(e.getSource() == saveButton) {
			int returnVal = fc.showSaveDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
			} else {
				//����� ���
			}
		}
	}
	
	public static void main(String[] args) {
		new FileChooserTest();
	}

}
