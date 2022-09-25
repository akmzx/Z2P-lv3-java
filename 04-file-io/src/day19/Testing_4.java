package day19;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Testing_4 {

	public static void main(String[] args) throws IOException {
		
		Path path = Path.of(".");
		
		System.out.println("---- Browse with listpath---");
		
		Files.list(path)
				.forEach(p -> {
					System.out.println(p);
				});
		
		System.out.println(".... Browse with walk() ....");
		System.out.println("---- All Files ----");
		Files.walk(path)
				.forEach(p -> {
					System.out.println(p);
				});
		
		System.out.println("---- Only Directory ----");
		Files.walk(path)
				.filter(p -> Files.isDirectory(p))
				.forEach(p -> {
					System.out.println(p);
				});
		System.out.println("---- Only File ----");
		Files.walk(path)
				.filter(Files::isRegularFile)
				.forEach(p -> {
					System.out.println(p);
				});
		System.out.println("---- only java file ----");
		Files.walk(path)
				.filter(p -> p.toString().contains(".java"))
				.forEach(System.out::println);
	}
}
