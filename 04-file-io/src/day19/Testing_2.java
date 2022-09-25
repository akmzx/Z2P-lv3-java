package day19;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Testing_2 {

	public static void main(String[] args) throws IOException {
		
//		non-empty folder
		Path path = Path.of("./test");
		
//		delete sub-item
		Files.walk(path)
			.map(p -> p.toFile())
			.forEach(f -> {
				System.out.println("file" + f.getAbsolutePath());
				f.delete();
			});
//		delete main folder
		Files.delete(path);
		System.out.println("Deleted....");
	}
}
