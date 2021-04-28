package class6;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.add("MILK");
		list.add("BREAD");
		list.add("BUTTER");
		list.add(1, "APPLE");
		list.set(2, "GRAPE");
		list.remove(3);
		
		for(String s:list) {
			System.out.println(s);			
		}
		
		//ListIterator
		ListIterator<String> iter = list.listIterator();
		while(iter.hasNext()) {
			String s = (String)iter.next();
			System.out.println(s);
		}
	}

}
