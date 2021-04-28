package class7;

import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class StackExercise {
	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("������ �Է��Ͻÿ�.");
		String exp = input.nextLine();
		
		StringTokenizer st = new StringTokenizer(exp, " ");
//		while(st.hasMoreTokens()) {
//			System.out.println("[" + st.nextToken() + "]");
//		}
		
		Stack<String> stack = new Stack<>();
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			if(token.equals("(")) {
				stack.push(token);
			} else if(token.equals(")")) {
				if(stack.isEmpty() == false) {
					stack.pop();
				} else {
					System.out.println("��ȿ���� ���� ���Դϴ�.");
					return;
				}
			}
		}
		if(stack.isEmpty()) System.out.println("��ȿ�� ���Դϴ�.");
		else System.out.println("��ȿ���� ���� ���Դϴ�.");
	}
	
	public static void stringTokenizerTest() {
		StringTokenizer st = new StringTokenizer("APPLE, GRAPE, BANANA, MELON, STRAWBERRY", ", ");
		while(st.hasMoreTokens()) {
			System.out.println("[" + st.nextToken() + "]");
		}
	}
}
