package class7;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		
		for(int i=0; i<10; i++) {
			stack.push(String.valueOf((char)('A' + i)));
		}
		System.out.println(stack);
		
		System.out.println("������ ����� ���Ҵ� " + stack.peek());
		System.out.println(stack);
		
		System.out.println("�������");		
		int size = stack.size();
		for(int i=0; i<size; i++) {
			System.out.print(stack.pop() + " ");
		}
		System.out.println("\n���ⳡ");
		System.out.println(stack);
	}

}
