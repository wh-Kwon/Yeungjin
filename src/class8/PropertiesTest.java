package class8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Set;

public class PropertiesTest {

	public static void main(String[] args) throws IOException {
		Properties props = new Properties();
		try(FileReader reader = new FileReader("dict.props")) {
			props.load(reader);
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();			
		}
		Set<Object> keys = props.keySet();
		for(Object key : keys) {
			System.out.println(key + " : " + props.get(key));
		}
		props.put("³ª¹«", "tree");
		try(PrintWriter out = new PrintWriter(new File("dict.props"))) {
			props.store(out, "My Dictionary");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
				
	}

}
