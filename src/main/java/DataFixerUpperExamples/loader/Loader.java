package DataFixerUpperExamples.loader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Loader {
	
	public static List<String> loadFile(String filename) {

		List<String> lines = new ArrayList<String>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			while(br.ready()) {
				lines.add(br.readLine());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return lines;
	}

}
