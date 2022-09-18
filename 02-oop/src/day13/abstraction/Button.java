package day13.abstraction;

public class Button implements OnClickListener {

	private String name;

	public Button(String name) {
		this.name = name;
	}

	public void display() {
		System.out.println("font size: " + FONT_SIZE);
		System.out.println("font family: " + FONT_FAMILY);
	}

	public void onClick() {
		System.out.println(name + " click event...");
	}

	public void onDoubleClick() {
		System.out.println(name + " double click event...");
	}
}
