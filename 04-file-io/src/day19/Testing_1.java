package day19;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Testing_1 {
	
	public static void main(String[] args) throws IOException {
		
//		define location(Path)
//		absolute path
		Path path1 = Path.of("D:\\Aung Kaung Myat\\AKM training web\\Java\\04-file-io\\src\\readme.txt");
		
		System.out.println("Path1: " + path1);
		
//		relative path
		Path path2 = Path.of("./src/readme2.txt");
		System.out.println("Path2: " + path2);
		System.out.println("Abs path of path2: " + path2.toAbsolutePath());
		
//		operations
//		System.out.println("Exist path1? " + Files.exists(path1));
//		System.out.println("Exist path2? " + Files.exists(path2));
		
//		try {
//			Files.createFile(path2);
//		} catch (IOException e) {
//			System.err.println("Already exist");
//		}
		
		Path path3 = Path.of("./test");
		if(Files.notExists(path3)) {
			Files.createDirectories(path3);
			System.out.println("Created directory");
		}
		
//		delete dir
		Files.deleteIfExists(path3);
		System.out.println("Path2 exist? " + Files.exists(path2));
//		Files.delete(path2);
//		Files.deleteIfExists(path3);
//		System.out.println("deleted");
		
//		if (!Files.exists(path2)) {
//			Files.createFile(path2);
//			System.out.println("Created a new file");
//		} else {
//			System.out.println("Already exist");
//		}
	}
}
