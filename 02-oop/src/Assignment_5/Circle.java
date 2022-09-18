package Assignment_5;

public class Circle implements Shape{
	int radius;

	@Override
	public double area(int num) {
		this.radius = num;
		return Math.PI * radius * radius;
	}

	@Override
	public double volume(int num) {
		this.radius = num;
		return 0;
	}
	
	
}
