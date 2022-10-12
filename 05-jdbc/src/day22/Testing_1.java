package day22;

import java.sql.*;
import java.time.LocalDate;

public class Testing_1 {

	public static void main(String[] args) throws SQLException {
		
		//insert("Hla Hla", "Mandalay", 300000, 1.5f, LocalDate.of(1997, 10, 12) );
		//update(500000, 1.5f, "Mandalay");
		//delete(1);
		selectAll();
		
	}

	private static void selectAll() {
		
		String url = "jdbc:mariadb://localhost:3306/employee_db";
		String username = "root";
		String password = "";
		
		try(Connection conn = DriverManager.getConnection(url, username, password);) {
			
			var query = "SELECT emp_no 'id', name, salary FROM employees ORDER BY salary DESC";
			
			var pst = conn.prepareStatement(query);
			
			ResultSet rs= pst.executeQuery();
			int i = 1;
			while(rs.next()) { // 123 ->
				//int id = rs.getInt("emp_no");
				String id = rs.getString("id");
				String emp_name = rs.getString("name");
				int salary = rs.getInt("salary");
				System.out.println("EmpNo: " + id);
				System.out.println("Name: " + emp_name);
				System.out.println("Salary: " + salary);
				System.out.println((i++ )+ "---------");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void delete(int id) {
		String url = "jdbc:mariadb://localhost:3306/employee_db";
		String username = "root";
		String password = "";
		
		try(Connection conn = DriverManager.getConnection(url, username, password);) {
			
			var query = "DELETE FROM employees WHERE emp_no = ?";
			
			var pst = conn.prepareStatement(query);
			pst.setInt(1, id);
			
			
			var result = pst.executeUpdate();
			
			System.out.println("No of affected row: " + result);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	private static void update(int salary, float bonus, String city) throws SQLException {
		String url = "jdbc:mariadb://localhost:3306/employee_db";
		String username = "root";
		String password = "";
		
		try(Connection conn = DriverManager.getConnection(url, username, password);) {
			
			var query = "UPDATE employees SET salary = ?, bonus_rate = ? WHERE city = ?";
			
			var pst = conn.prepareStatement(query);
			pst.setInt(1, salary);
			pst.setFloat(2, bonus);
			pst.setString(3, city);
			
			var result = pst.executeUpdate();
			
			System.out.println("No of affected row: " + result);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	private static void insert(String name, String city, int sal, float bonus, LocalDate dob) throws SQLException {
		String url = "jdbc:mariadb://localhost:3306/employee_db";
		String username = "root";
		String password = "";
		
		// create connection
		Connection conn = DriverManager.getConnection(url, username, password);
		System.out.println("got connection");
		
		// define query
		//String query = "INSERT INTO employees(name,salary,bonus_rate,city,birthday)VALUES('" + name +"', " + sal +", " + bonus +", '" + city + "', '" + dob +"')";
		String query = "INSERT INTO employees(name,salary,bonus_rate,city,birthday)VALUES(?,?,?,?,?)";
		System.out.println("query = " + query);
		// create statement
		//Statement st = conn.createStatement();
		PreparedStatement pst = conn.prepareStatement(query);
		pst.setString(1, name);
		pst.setInt(2, sal);
		pst.setFloat(3, bonus);
		pst.setString(4, city);
		pst.setDate(5, Date.valueOf(dob));
		
		// execute query
		//int result = st.executeUpdate(query);
		int result = pst.executeUpdate();
		System.out.println("No of affected row: " + result);
		// close connection
		conn.close();
		
		
	}

	
	
	
}
