package class6;

import java.util.HashSet;
import java.util.Set;

public class FindDupplication {

	public static void main(String[] args) {
		Set<String> s = new HashSet<String>();
		String[] sample = {"�ܾ�", "�ߺ�", "����", "�ߺ�"};
		for(String a : sample)
			if(!s.add(a))
				System.out.println("�ߺ��� �ܾ� " + a);
		System.out.println(s.size() + " �ߺ����� ���� �ܾ�: " + s);
	}

}
