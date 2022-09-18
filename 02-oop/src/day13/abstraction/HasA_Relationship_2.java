package day13.abstraction;

import java.time.LocalDate;

class Product {
	String name;
	int price;

	public Product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
}

class SaleRecord {
	int id;
	int saleQty;
	LocalDate saleDate;
	Product product;

	public SaleRecord(int id, Product product, int saleQty) {
		super();
		this.id = id;
		this.product = product;
		this.saleQty = saleQty;
		this.saleDate = LocalDate.now();
	}

	public void showInfo() {
		System.out.print(id + "\t");
		System.out.print(saleDate + "\t");
		System.out.print(product.name + "\t");
		System.out.print(product.price + "\t");
		System.out.print(saleQty + "\t");
		System.out.print((product.price * saleQty) + "\n");
	}
}

public class HasA_Relationship_2 {

	public static void main(String[] args) {

		var prod1 = new Product("Coffee", 4500);
		var prod2 = new Product("Juice", 3000);
		
		SaleRecord[] data = new SaleRecord[3];
		
		data[0] = new SaleRecord(1, prod1, 12);
		data[1] = new SaleRecord(2, prod1, 5);
		data[2] = new SaleRecord(3, prod2, 6);
		
		System.out.println("Id\t Sale Date\t Product\t Price\t Qty\t Subtotal");
		System.out.println("------------------------------------");
		
		for (SaleRecord sale : data) {
			sale.showInfo();
		}
	}

}
