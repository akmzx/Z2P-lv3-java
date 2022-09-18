package day10;

public class SingletonClass {

	public static void main(String[] args) {
		var obj1 = DatabaseConfig.getInstance();

		System.out.println("obj1's db name: " + obj1.db_name);

		var obj2 = DatabaseConfig.getInstance();
		System.out.println("obj2's db name: " + obj2.db_name);

		obj2.db_name = "student_db";
		System.out.println("obj2's db name: " + obj2.db_name);
		System.out.println("obj1's db name: " + obj1.db_name);
	}
}

class DatabaseConfig {
	String db_name = "employee_db";

//	static field
	private static DatabaseConfig config = null;

//	private constructor
	private DatabaseConfig() {

	}

//	static method to return obj
	public static DatabaseConfig getInstance() {
		if (config == null)
			config = new DatabaseConfig();
		return config;
	}
}