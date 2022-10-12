package day20;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Reading3 {

	public static void main(String[] args) {

		try (BufferedReader br = Files.newBufferedReader(Path.of("src/emp_name.txt"))) {

			List<String> list = br.lines()
									.filter(line -> line.contains("aung"))
									.collect(Collectors.toList());
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		older style
		try(var br = Files.newBufferedReader(Path.of("src/emp_name.txt"))) {
			var line = "";
			var list = new ArrayList<String>();
			while( (line = br.readLine()) != null) {
				if(line.contains("aung")) {
					list.add(line);
				}
			}
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
