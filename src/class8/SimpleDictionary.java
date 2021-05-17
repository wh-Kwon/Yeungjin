package class8;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

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
	
	private static final String JDBC_CLASS_NAME = "org.mariadb.jdbc.Driver";
	private static final String DB_URL = "jdbc:mariadb://localhost:3306/oop";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "rhksflwk";
	
	// 한영사전 : 한글단어와 대응되는 영어단어의 쌍을 저장
	private Map<String, String> dict = new HashMap<>();
	private static final String DIC_FILE_NAME="dict.props";
	
	public SimpleDictionary() {
		this.add(inputField);
		this.add(searchBtn);
		this.add(addBtn);
		searchBtn.addActionListener(this);
		addBtn.addActionListener(this);
		
		this.setPreferredSize(new Dimension(600,50));
		
//		buildDictionaryFromFile();
		
		// JDBC 드라이버를 메모리에 적재하기.
		try {
			Class.forName(JDBC_CLASS_NAME);
			buildDictionaryFromDB();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void buildDictionaryFromDB() {
		try(Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);) {
			String sql = "select * from dict";
			// preparedStatement 객체는 실행준비가 완료된 SQL 객체
			PreparedStatement pstmt = con.prepareStatement(sql);
			// Insert, Delete, Update 문의 실행은 executeUpdate() 메서드를 호출하고
			// select문의 실행은 executeQuery() 메소드를 호출한다.
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String key = rs.getString("kor");
				String value = rs.getString("eng");
				dict.put(key, value);
				dict.put(value, key);
				System.out.println(key + " : " + value);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void buildDictionaryFromFile() {
		Properties props = new Properties();
		try(FileReader fReader = new FileReader(DIC_FILE_NAME)) {
			props.load(fReader);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		Set<Object> set = props.keySet();
		for(Object key : set) {
			System.out.println("key:" + key);
			Object value = props.get(key);
			dict.put((String)key, (String)value);
			dict.put((String)value, (String)key);
		}
	}
	
	private void addWordToDB(String key, String value) {
		/* DB에 연결해서 Connection 객체를 반환받는다.
		 * Connection 객체에게 PreparedStatement 객체를 요청한다.
		 * PreparedStatement 객체의 executeUpdate() 메서드를 호출해서 DB에 저장한다.
		 */
		try(Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
			// ?는 place holder
			String sql = "insert into dict values(?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			// ? 자리의 칼럼 데이터 타입에 따라 적절한 setXXX() 메서드를 호출해야 한다.
			pstmt.setString(1, key);
			pstmt.setString(2, value);
			pstmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void addWordToFile(String key, String value) {
		try(FileWriter fWriter = new FileWriter(DIC_FILE_NAME, true)) {
			String str = key + "=" + value + "\n";
			fWriter.write(str);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
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
			dict.put(value, key);
//			addWordToFile(key, value);
//			addWordToFile(value, key);
			addWordToDB(key,value);
			addWordToDB(value,key);
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
