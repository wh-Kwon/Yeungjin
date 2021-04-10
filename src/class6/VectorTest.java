package class6;

import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		Vector vc = new Vector();
		
		vc.add("Hello World!");
		vc.add(new Integer(10));
		vc.add(20);
		
		System.out.println("Vector size :" + vc.size());
		
		for (int i = 0; i < vc.size(); i++) {
			System.out.println("vector element " + i + " :" + vc.get(i));
		}
		
		// get()은 Object 타입으로 반환하므로 형변환하여서 사용함
		// String s = (String)vc.get(0);
	}

}
