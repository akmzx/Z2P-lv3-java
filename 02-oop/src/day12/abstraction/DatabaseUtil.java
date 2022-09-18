package day12.abstraction;

public abstract class DatabaseUtil {

	private String db_name = "shopdb";
	
	public void connectDatabase() {
		System.out.println("Connection to " + db_name + "...");
	}
	
	public abstract void insert();
	public abstract void update();
	public abstract boolean delete(int id);
	public abstract Object findById(int id);
	
//	public abstract boolean deleteAll();
}
