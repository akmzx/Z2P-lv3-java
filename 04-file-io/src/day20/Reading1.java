package day20;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class Reading1 {

	public static void main(String[] args) throws IOException {
		
		Path path = Path.of("src/employee.txt");
		
		try(Stream<String> data = Files.lines(path, StandardCharsets.UTF_8)) {
			data.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		using parallel stream
		
		Stream<String> data = Files.lines(path).parallel();
		List<String> list = data.toList();
		System.out.println("List: " + list);
		
//		using Buffer Reader
		
		try(BufferedReader reader = Files.newBufferedReader(path)) {
			String currentLine = null;
			while((currentLine = reader.readLine()) != null) {
				System.out.println(currentLine);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
