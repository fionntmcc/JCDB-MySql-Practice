package lab1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Scanner;

import com.mysql.cj.jdbc.MysqlDataSource;

public class Question1P3 {
	
	// no need for user input
	private static Scanner kb = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		MysqlDataSource mysqlds = new MysqlDataSource();
		mysqlds.setURL("jdbc:mysql://localhost:3306/employee_kin?serverTimezone=UTC");
		mysqlds.setUser("root");
		mysqlds.setPassword("root");
		
		try {
			Connection conn = mysqlds.getConnection();
			
			// query - needs 2 joins
			String query = "SELECT e.eid \"eid\", e.ename \"ename\", n.NOK_Name \"nokName\", s.salary \"salary\"\r\n"
					+ "FROM employee_table e\r\n"
					+ "INNER JOIN next_of_kin_table n\r\n"
					+ "ON e.NextOfKin = n.NOK_ID\r\n"
					+ "INNER JOIN salary s\r\n"
					+ "ON e.eid = s.eid";
			
			/*
			System.out.println("Enter name of city you wish to delete: ");
			String choice = kb.nextLine();
			 */
			
			// statement does not take any params
			PreparedStatement myStmt = conn.prepareStatement(query);
			ResultSet rs = myStmt.executeQuery(query); // contains employee info
			var employees = new ArrayDeque<Employee>();
			
			while (rs.next()) {
				int eid = rs.getInt("eid");
				String ename = rs.getString("ename");
				String nokName = rs.getString("nokName");
				Double salary = rs.getDouble("salary");
				
				Employee emp = new Employee(eid, ename, nokName, salary);
				employees.add(emp);
			}
			
			System.out.println(employees);
			
			conn.close();
			myStmt.close();
			System.out.println("\nConnection closed successfully");
			
		} catch (SQLException e) {
			System.out.println(e.getErrorCode());
			System.out.println(e.getMessage());
		}
	}
}
