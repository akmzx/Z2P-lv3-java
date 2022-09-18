package day14;

import java.util.ArrayList;

public class List_Testing_3 {

	public static void main(String[] args) {
		ArrayList<Phone> list = new ArrayList<>();
		
		var ph1 = new Phone("iPhone", 3100000);
		
		list.add(ph1);
		list.add(new Phone("Samsung", 2900000));
		list.add(new Phone("Viva", 150000));
		
		System.out.println("---- all data ----");
		list.forEach(ph -> {
			System.out.println("Brand: " + ph.getBrand());
			System.out.println("Price: " + ph.getPrice());
			System.out.println();
		});
		
		System.out.println("---- > 200000 ----");
		list.forEach(obj -> {
			if(obj.getPrice() > 200000) 
				System.out.println(obj.getBrand() + ", " + obj.getPrice());
		});
		
		Phone obj = list.get(0);
		System.out.println(obj);
	}
}

class Phone {
	private String brand;
	private int price;
	public Phone(String brand, int price) {
		super();
		this.brand = brand;
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Phone [brand=" + brand + ", price=" + price + "]";
	}
	
	
	
	
	
	
}