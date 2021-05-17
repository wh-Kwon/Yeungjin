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
	// �Է��ʵ�, ��ư 2��
	private JTextField inputField = new JTextField(30);
	private JButton searchBtn = new JButton("�˻�");
	private JButton addBtn = new JButton("�߰�");
	
	private static final String JDBC_CLASS_NAME = "org.mariadb.jdbc.Driver";
	private static final String DB_URL = "jdbc:mariadb://localhost:3306/oop";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "rhksflwk";
	
	// �ѿ����� : �ѱ۴ܾ�� �����Ǵ� ����ܾ��� ���� ����
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
		
		// JDBC ����̹��� �޸𸮿� �����ϱ�.
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
			// preparedStatement ��ü�� �����غ� �Ϸ�� SQL ��ü
			PreparedStatement pstmt = con.prepareStatement(sql);
			// Insert, Delete, Update ���� ������ executeUpdate() �޼��带 ȣ���ϰ�
			// select���� ������ executeQuery() �޼ҵ带 ȣ���Ѵ�.
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
		/* DB�� �����ؼ� Connection ��ü�� ��ȯ�޴´�.
		 * Connection ��ü���� PreparedStatement ��ü�� ��û�Ѵ�.
		 * PreparedStatement ��ü�� executeUpdate() �޼��带 ȣ���ؼ� DB�� �����Ѵ�.
		 */
		try(Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
			// ?�� place holder
			String sql = "insert into dict values(?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			// ? �ڸ��� Į�� ������ Ÿ�Կ� ���� ������ setXXX() �޼��带 ȣ���ؾ� �Ѵ�.
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
		if(e.getSource() == searchBtn) { //�˻� ��ư�� Ŭ���� ���
			String value = dict.get(key);
			if(value == null) {
				JOptionPane.showMessageDialog(this, "�ܾ ã�� �� �����ϴ�.", key, JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, value, key, JOptionPane.INFORMATION_MESSAGE);
			}
		} else if(e.getSource() == addBtn) { //�߰� ��ư�� Ŭ���� ���
			String value = JOptionPane.showInputDialog(this, key + "�� �����Ǵ� ����ܾ �Է��ϼ���", key);
			if(value == null || value.trim().length() == 0) return;
			dict.put(key, value);
			dict.put(value, key);
//			addWordToFile(key, value);
//			addWordToFile(value, key);
			addWordToDB(key,value);
			addWordToDB(value,key);
			JOptionPane.showMessageDialog(this, "����ܾ �߰��Ǿ����ϴ�.", "����", JOptionPane.INFORMATION_MESSAGE);
		}
		inputField.requestFocus();
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new SimpleDictionary());
		frame.setTitle("���� �ѿ�����");
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
