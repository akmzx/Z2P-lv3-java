package assignments;

public class Assignment_6 {

	public static void main(String[] args) {
		String paragraph= "NLP techniques are becoming widely popular scientific research areas as well as Information Technology industry. Language technology together with Information Technology can enhance the lives of people with different capabilities. This system implements voice command mobile phone dialer application. The strength of the system is that it can make phone call to the contact name written in either English scripts or Myanmar scripts.";
		String[] sentences = paragraph.split("\\. ");
		String words = paragraph.replaceAll("\\.","").replaceAll(" ", "");
		int totalwords = words.split("").length;

		System.out.println("Number of sentences: " + sentences.length);
		System.out.println("Number of total words: " + totalwords);
	}
}
