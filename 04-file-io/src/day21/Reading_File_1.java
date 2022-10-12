package day21;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Reading_File_1 {

	public static void main(String[] args) {
		
		try(RandomAccessFile file = new RandomAccessFile("src/employee.txt", "r")) {
//			create filechannel
			FileChannel channel = file.getChannel();
			
//			create buffer
			ByteBuffer buffer = ByteBuffer.allocate((int)channel.size());
			
//			read data from channel to buffer
			channel.read(buffer);
			
//			prepare to read data from buffer
			buffer.flip();
			
			String data = new String(buffer.array(), 0, buffer.limit());
			System.out.println(data);
			
//			close
//			channel.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
