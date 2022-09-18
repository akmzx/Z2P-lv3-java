package Assignment_4;

public class Rectangle extends Shape {
	private int length;
	private int width;

	public Rectangle(int length, int width, String color) {
		super();
		this.length = length;
		this.width = width;
		this.setColor(color);
	}

	@Override
	public double Area() {
		return length * width;
	}

	public void displayArea() {
		System.out.println("Area of " + super.getColor() + " rectangle: " + Area());
	}

}
