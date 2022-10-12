package day21;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Writing_File_1 {

	public static void main(String[] args) {
		try(RandomAccessFile file = new RandomAccessFile("src/test2.txt", "rw")) {
			String data = "Myanmar IT Consulting - MMIT";
//			get channel
			FileChannel channel = file.getChannel();
			byte[] output = data.getBytes();
//			create buffer
			ByteBuffer buffer = ByteBuffer.allocate(output.length);
			
//			fill data to buffer
			buffer.put(output);
			
			buffer.flip();
			
			channel.write(buffer);
			System.out.println("---- saved ----");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
