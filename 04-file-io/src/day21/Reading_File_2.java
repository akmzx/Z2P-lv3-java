package day21;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Reading_File_2 {

	public static void main(String[] args) {
		
		try(FileChannel channel = FileChannel.open(Path.of("src/employee.txt"), StandardOpenOption.READ)) {
			
			int bufferSize = 10;
			if(bufferSize > channel.size())
				bufferSize = (int)channel.size();
			
			ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
			
			while(channel.read(buffer) > 1) {
				String data = new String(buffer.array(), 0, buffer.limit());
				System.out.println("content: " + data);
				buffer.clear();
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
