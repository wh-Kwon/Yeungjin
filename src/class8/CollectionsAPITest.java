package class8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsAPITest {

	public static void main(String[] args) {
		sortTest();
		shuffleTest();
		binarySearch();
	}
	
	public static int binarySearch2(List<Integer> list, Integer key) {
		int left = 0;
		int right = list.size()-1;
		
		// left�� right������ ���� ������ �ݺ�
		
		return -1;
	}
	
	public static void binarySearch() {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			list.add(i);
		}
		int idx = Collections.binarySearch(list, 5);
		if(idx >= 0) {
			System.out.println((idx+1) + "��ġ�� �ֽ��ϴ�.");
		} else {
			System.out.println("7�� ����Ʈ�� �����ϴ�.");
		}
	}
	
	public static void shuffleTest() {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<=10; i++)
			list.add(i);
		System.out.println(list);
		
		System.out.println("After shuffling");
		Collections.shuffle(list);
		
		System.out.println(list);
	}
	
	public static void sortTest() {
		String[] sample = {"i", "walk", "the", "Line"};
		// "i", "line", "the", "walk"
		
		// ��ҹ��� �������� ���ĺ� ������ ���ĵǵ��� �Ͻÿ�.
		List<String> list = Arrays.asList(sample);
		Collections.sort(list, 
				(o1, o2) -> o1.compareToIgnoreCase(o2));
		System.out.println(list);
	}

}
