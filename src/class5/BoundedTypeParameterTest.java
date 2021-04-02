package class5;

public class BoundedTypeParameterTest {
	
	public static <T extends Comparable> T getMax(T[] a) {
		if(a == null || a.length == 0)
			return null;
		T largest = a[0];
		for(int i=1; i<a.length; i++)
			if(largest.compareTo(a[i]) < 0)
				largest = a[i];
		return largest;
	}
	
	public static <T extends Comparable> T getMin(T[] a) {
		if(a == null || a.length == 0)
			return null;
		T smallest = a[0];
		for(int i=1; i<a.length; i++)
			if(smallest.compareTo(a[i]) > 0)
				smallest = a[i];
		return smallest;
	}
	
	public static void main(String[] args) {
		String[] list = {"xyz", "abc", "def"};
		String max = BoundedTypeParameterTest.getMax(list);
		System.out.println(max);
		String min = BoundedTypeParameterTest.getMin(list);
		System.out.println(min);
	}

}
