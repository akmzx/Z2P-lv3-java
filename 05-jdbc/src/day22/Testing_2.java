package day22;

import java.sql.*;
import java.util.Scanner;

public class Testing_2 {
	
	public static void main(String[] args) {
		
		try(var con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/employee_db", "root", "");
				var sc = new Scanner(System.in)) {
			var query = "INSERT INTO employees(name, salary, city, birthday, bonus_rate)VALUES(?, ?, ?, ?, ?)";
			
			var pst = con.prepareStatement(query);
			for(var i = 0; i < 3; i++) {
				
				System.out.print("Enter name: ");
				pst.setString(1, sc.nextLine());
				
				System.out.print("Enter city: ");
				pst.setString(3, sc.nextLine());
				
				System.out.print("Enter salary: ");
				pst.setInt(2, Integer.parseInt(sc.nextLine()));
				
				System.out.print("Enter birthday(yyyy-MM-dd): ");
				pst.setDate(4, Date.valueOf(sc.nextLine()));
				pst.setFloat(5, 0.0f);
				System.out.println("--------------------");
				
				pst.addBatch();
			}
			
			pst.executeBatch();
			System.out.println("save....");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
