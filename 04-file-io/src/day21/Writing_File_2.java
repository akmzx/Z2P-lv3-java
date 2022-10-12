package day21;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;

public class Writing_File_2 {

	public static void main(String[] args) {
		try(RandomAccessFile file = new RandomAccessFile(Path.of("src/test3.txt").toFile(), "rw")) {
			String data = "Many..............";
			FileChannel channel = file.getChannel();
			
			MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 1024 * 8);
			
			buffer.put(data.getBytes());
			
			System.out.println("saved");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
