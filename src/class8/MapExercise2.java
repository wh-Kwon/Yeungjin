package class8;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapExercise2 {
	
	public static void main(String[] args) {
		Map<String, String> aPhone = new TreeMap<String, String>();
		aPhone.put("ȫ�浿", "010-8520-7123");
		aPhone.put("������", "010-1234-5678");
		aPhone.put("�̼���", "010-9876-5432");
		
		Map<String, String> bPhone = new TreeMap<String, String>();
		bPhone.put("������", "010-9898-9898");
		bPhone.put("�迬��", "010-2580-1479");
		bPhone.put("���缮", "010-8888-8888");
		
		Map<String, Map<String, String>> phoneBook = new TreeMap<>();
		phoneBook.put("A��", aPhone);
		phoneBook.put("B��", bPhone);
		
		
		// EntrySet�� �̿��� ���
		Set<Map.Entry<String, Map<String, String>>> entrySet = phoneBook.entrySet();
		Iterator<Map.Entry<String, Map<String, String>>> iterE1 = entrySet.iterator();
		
		while(iterE1.hasNext()) {
			Map.Entry<String, Map<String, String>> entry = iterE1. next();
			System.out.println(entry.getKey());
			Map<String, String> pb = entry.getValue();
			
			Set<Map.Entry<String,String>> phones = pb.entrySet();
			Iterator<Map.Entry<String, String>> iterE2 = phones.iterator();
			while(iterE2.hasNext()) {
				Map.Entry<String, String> phone = iterE2.next();
				System.out.println(phone.getKey() + " : " + phone.getValue());
			}
			System.out.println();
		}
		
		
		//KeySet�� �̿��� ���
		Set<String> pbKeySet = phoneBook.keySet();
		Iterator<String> iterK1 = pbKeySet.iterator();
		
		while(iterK1.hasNext()) {
			String pbKey = iterK1.next();
			System.out.println(pbKey);
			Map<String, String> pbValue = phoneBook.get(pbKey);
			
			Set<String> phoneClass = pbValue.keySet();
			Iterator<String> iterK2 = phoneClass.iterator();
			while(iterK2.hasNext()) {
				String name = iterK2.next();
				String phoneNum = pbValue.get(name);
				System.out.println(name + " : " + phoneNum);
			}
			System.out.println();
		}
	}
	
}