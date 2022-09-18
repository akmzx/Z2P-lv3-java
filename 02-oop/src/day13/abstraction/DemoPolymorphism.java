package day13.abstraction;

import java.util.Iterator;

public class DemoPolymorphism {

	public static void main(String[] args) {
		Flying[] data = new Flying[3];
		
		var obj1 = new Human();
		data[0] = obj1;
		
		data[1] = new Bird();
		data[2] = new Airplane();
		
		for (var i = 0; i < data.length; i++) {
			data[i].fly();
		}
	}

}
