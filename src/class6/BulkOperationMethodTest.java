package class6;

import java.util.HashSet;
import java.util.Set;

public class BulkOperationMethodTest {

	public static void main(String[] args) {
		Set<String> s1 = new HashSet<String>();
		Set<String> s2 = new HashSet<String>();
		
		s1.add("A");
		s1.add("B");
		s1.add("C");
		
		s2.add("A");
		s2.add("D");
		
		Set<String> union = new HashSet<String>(s1);
		union.addAll(s2);
		
		Set<String> intersection = new HashSet<String>(s1);
		intersection.retainAll(s2);
		
		Set<String> differenceOfSet = new HashSet<String>(s1);
		differenceOfSet.remove(s2);
		
		System.out.println("������ " + union);
		System.out.println("������ " + intersection);
		System.out.println("������ " + differenceOfSet);

	}

}
