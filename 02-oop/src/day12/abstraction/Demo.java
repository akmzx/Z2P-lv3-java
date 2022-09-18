package day12.abstraction;

public class Demo {

	public static void main(String[] args) {
//		DatabaseUtil db = new DatabaseUtil();
		
		ProductService service = new ProductService();
		
		service.connectDatabase();
		service.delete(101);
		service.findById(222);
		service.insert();
		service.update();
		
		System.out.println(".... refer to its child class ...");
		DatabaseUtil db = new ProductService();
		db.update();
	}
}
