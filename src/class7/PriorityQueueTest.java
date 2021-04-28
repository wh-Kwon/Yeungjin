package class7;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		MyComparator comparator = new MyComparator();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(comparator);
		pq.add(30);
		pq.add(80);
		pq.add(20);
		
		for(int o : pq) System.out.println(o);
		
		System.out.println("원소 삭제");
		System.out.println(pq.comparator());
		
		while(!pq.isEmpty())
			System.out.println(pq.remove());
		
		PriorityQueueTest test = new PriorityQueueTest();
		System.out.println(test.hashCode());
	}

}

class MyComparator implements Comparator<Integer> {
	@Override
	public int compare(Integer o1, Integer o2) {
		int result = (int)o2 - (int)o1;
		return result;
	}
}