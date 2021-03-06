package class7;

import java.util.HashMap;
import java.util.Map;

public class WordFreq {

	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<String, Integer>();
		String[] sample = {"to", "be", "or", "not", "to", "be", "is", "a", "problem"};
		
		//문자열에 포함된 단어의 빈도를 계산한다.
		for(String a : sample) {
			Integer freq = m.get(a);
			m.put(a, (freq == null) ? 1 : freq + 1);
		}
		System.out.println(m.size() + "개의 단어가 있습니다.");
		System.out.println("to exist?: " + m.containsKey("to"));
		System.out.println("is empty?: " + m.isEmpty());
		System.out.println(m);
	}

}
