package day19;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Testing_3 {
	
	public static void main(String[] args) throws IOException {
		
		Path sourcePath = Path.of("./src/test1.txt");
		
		Path destPath = Path.of("./src/day19/test2.txt"); 
		
//		Files.copy(sourcePath, destPath); // if not exist, auto create
		Files.copy(sourcePath, destPath, StandardCopyOption.REPLACE_EXISTING);
		System.out.println("copy...");
		
//		move(cut)
		sourcePath = Path.of("./src/hello.txt");
		destPath = Path.of("./src/day19/hello.txt");
		
		Files.move(sourcePath, destPath);
		System.out.println("Moving...");
	}
}
