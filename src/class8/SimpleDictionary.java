package class8;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleDictionary extends JPanel implements ActionListener {
	// 입력필드, 버튼 2개
	private JTextField inputField = new JTextField(30);
	private JButton searchBtn = new JButton("검색");
	private JButton addBtn = new JButton("추가");
	
	// 한영사전 : 한글단어와 대응되는 영어단어의 쌍을 저장
	private Map<String, String> dict = new HashMap<>();
	
	public SimpleDictionary() {
		this.add(inputField);
		this.add(searchBtn);
		this.add(addBtn);
		searchBtn.addActionListener(this);
		addBtn.addActionListener(this);
		
		this.setPreferredSize(new Dimension(600,50));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String key = inputField.getText().trim();
		System.out.println("[" + key + "]");
		// search button or add button detection.
		if(e.getSource() == searchBtn) { //검색 버튼이 클릭된 경우
			String value = dict.get(key);
			if(value == null) {
				JOptionPane.showMessageDialog(this, "단어를 찾을 수 없습니다.", key, JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, value, key, JOptionPane.INFORMATION_MESSAGE);
			}
		} else if(e.getSource() == addBtn) { //추가 버튼이 클릭된 경우
			String value = JOptionPane.showInputDialog(this, key + "에 대응되는 영어단어를 입력하세요", key);
			if(value == null || value.trim().length() == 0) return;
			dict.put(key, value);
			JOptionPane.showMessageDialog(this, "영어단어가 추가되었습니다.", "성공", JOptionPane.INFORMATION_MESSAGE);
		}
		inputField.requestFocus();
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new SimpleDictionary());
		frame.setTitle("나의 한영사전");
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
