package class8;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MapExercise {
	
	public static void main(String[] args) {
		Map<String, String> aPhone = new TreeMap<String, String>();
		aPhone.put("권우현", "010-6886-2785");
		aPhone.put("홍길동", "010-1234-5678");
		aPhone.put("정명준", "010-9876-5432");
		
		Map<String, String> bPhone = new TreeMap<String, String>();
		bPhone.put("박동재", "010-9898-9898");
		bPhone.put("장현석", "010-2580-1479");
		bPhone.put("예승재", "010-8888-8888");
		
		Map<String, Map<String, String>> phoneBook = new TreeMap<>();
		phoneBook.put("A반", aPhone);
		phoneBook.put("B반", bPhone);
		
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.println("어느반?(A반 또는 B반, 종료는 Q)");
			String ban = input.nextLine();
			if(ban.equalsIgnoreCase("Q")) break;
			Map<String,String> banPB = phoneBook.get(ban);
			if(banPB == null) {
				System.out.println("그런 반은 없어요...");
				continue;
			}
			System.out.println("누구?");
			String who = input.nextLine();
			String phone = banPB.get(who);
			if(phone == null) {
				System.out.println("그런 학생은 없어요....");
			}
			System.out.println(ban + "의 " + who + ":" + phone);
		}
		input.close();
		System.out.println("프로그램을 종료합니다...");
	}

}