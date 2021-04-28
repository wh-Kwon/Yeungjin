package class7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		try(BufferedReader reader = new BufferedReader(new FileReader(new File("wordbook.txt")))) {
			String word = null;
			while((word = reader.readLine()) != null) {
				if(set.add(word) == false) {
					System.out.printf("%s is already exist!\n", word);
				}
			}
			Iterator<String> iter = set.iterator();
			int cnt = 1;
			while(iter.hasNext()) {
				System.out.print(iter.next() + " ");
				if(cnt++ % 10 == 0) {
					System.out.println();
				}
			}
			System.out.printf("\nNumber of words is %d\n", set.size());
		} catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
