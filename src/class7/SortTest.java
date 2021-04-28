package class7;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Employee implements Comparable<Employee> {
	int number;
	String name;
	
	public Employee(int number, String name) {
		this.number = number;
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
	public int compareTo(Employee s) {
		return number - s.number;
	}
}

public class SortTest {
	public static void main(String[] args) {
		Employee array[] = {
				new Employee(20090001, "¹ÚÃ¶¼ö"),
				new Employee(20090002, "±èÃ¶¼ö"),
				new Employee(20090003, "ÀÌÃ¶¼ö")
		};
		List<Employee> list = Arrays.asList(array);
		Collections.sort(list);
		
		//¿ª¼øÀ¸·Î Á¤·Ä
		Collections.sort(list, Collections.reverseOrder());
		
		System.out.println(list);
	}
}
