package class6;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorTest {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("�ϳ�");
		list.add("��");
		list.add("��");
		list.add("��");
		
		String s;
		Iterator e = list.iterator();
		while(e.hasNext()) {
			s = (String) e.next();
			System.out.println(s);
		}
	}

}
