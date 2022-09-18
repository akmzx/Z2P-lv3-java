package day12.abstraction;

public class ProductService extends DatabaseUtil{

	@Override
	public void insert() {
		System.out.println("INSERT INTO product()VALUES()");
	}

	@Override
	public void update() {
		System.out.println("UPDATE product SET name = ?");
	}

	@Override
	public boolean delete(int id) {
		System.out.println("DELETE FROM product WHERE productId = " + id);
		return false;
	}

	@Override
	public Object findById(int id) {
		System.out.println("SELECT * FROM product WHERE productId = " + id);
		return null;
	}
	

}
