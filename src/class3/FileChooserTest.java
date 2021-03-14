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
		setTitle("파일 선택기 테스트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		fc = new JFileChooser();
		JPanel panel = new JPanel();
		JLabel label = new JLabel("파일 선택기 컴포넌트 테스트입니다.");
		panel.add(label);

		openButton = new JButton("파일 오픈");
		openButton.addActionListener(this);
		panel.add(openButton);
		
		saveButton = new JButton("파일 저장");
		saveButton.addActionListener(this);
		panel.add(saveButton);
		
		add(panel);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		//파일 오픈에 대한 이벤트 처리
		if(e.getSource() == openButton) {
			int returnVal = fc.showOpenDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
			} else {
				//사용자 취소
			}
		//파일 저장에 대한 이벤트 처리
		} else if(e.getSource() == saveButton) {
			int returnVal = fc.showSaveDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
			} else {
				//사용자 취소
			}
		}
	}
	
	public static void main(String[] args) {
		new FileChooserTest();
	}

}
