package class8;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MapExercise {
	
	public static void main(String[] args) {
		Map<String, String> aPhone = new TreeMap<String, String>();
		aPhone.put("�ǿ���", "010-6886-2785");
		aPhone.put("ȫ�浿", "010-1234-5678");
		aPhone.put("������", "010-9876-5432");
		
		Map<String, String> bPhone = new TreeMap<String, String>();
		bPhone.put("�ڵ���", "010-9898-9898");
		bPhone.put("������", "010-2580-1479");
		bPhone.put("������", "010-8888-8888");
		
		Map<String, Map<String, String>> phoneBook = new TreeMap<>();
		phoneBook.put("A��", aPhone);
		phoneBook.put("B��", bPhone);
		
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.println("�����?(A�� �Ǵ� B��, ����� Q)");
			String ban = input.nextLine();
			if(ban.equalsIgnoreCase("Q")) break;
			Map<String,String> banPB = phoneBook.get(ban);
			if(banPB == null) {
				System.out.println("�׷� ���� �����...");
				continue;
			}
			System.out.println("����?");
			String who = input.nextLine();
			String phone = banPB.get(who);
			if(phone == null) {
				System.out.println("�׷� �л��� �����....");
			}
			System.out.println(ban + "�� " + who + ":" + phone);
		}
		input.close();
		System.out.println("���α׷��� �����մϴ�...");
	}

}