package class6;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {
		
		// HashSet
		HashSet<String> hash = new HashSet<String>();
		hash.add("Milk");
		hash.add("Bread");
		hash.add("Butter");
		hash.add("Cheese");
		hash.add("Ham");
		System.out.println(hash);
		
		// LinkedHashSet
		LinkedHashSet<String> link = new LinkedHashSet<String>();
		link.add("Milk");
		link.add("Bread");
		link.add("Butter");
		link.add("Cheese");
		link.add("Ham");
		System.out.println(link);
		
		// TreeSet
		TreeSet<String> tree = new TreeSet<String>();
		tree.add("Milk");
		tree.add("Bread");
		tree.add("Butter");
		tree.add("Cheese");
		tree.add("Ham");
		System.out.println(tree);

	}

}
