package Assignment_5;

public class Cube implements Shape{
	
	int x;

	@Override
	public double area(int num) {
		this.x = num;
		return 6 * x * x;
	}

	@Override
	public double volume(int num) {
		this.x = num;
		return x * x * x;
	}

}
