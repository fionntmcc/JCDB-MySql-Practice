package lab1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.jdbc.MysqlDataSource;

public class Question1P2 {
	
	private static Scanner kb = new Scanner(System.in);
	
public static void main(String[] args) {
		
		MysqlDataSource mysqlds = new MysqlDataSource();
		mysqlds.setURL("jdbc:mysql://localhost:3306/salespersondb?serverTimezone=UTC");
		mysqlds.setUser("root");
		mysqlds.setPassword("root");
		
		try {
			Connection conn = mysqlds.getConnection();
			
			String query = "DELETE FROM salesperson_table"
					+ "	WHERE city = ?";
			PreparedStatement myStmt = conn.prepareStatement(query);
			
			System.out.println("Enter name of city you wish to delete: ");
			String choice = kb.nextLine();
			
			if (choice != null) {
				myStmt.setString(1, choice);
				int rows;
				if ((rows = myStmt.executeUpdate()) != 0) {
					System.out.println(rows + " rows deleted.");
				} else {
					System.out.println("No rows found with city name \"" + choice + "\".");
				}
			}
			
			conn.close();
			myStmt.close();
			System.out.println("\nConnection closed successfully");
			
		} catch (SQLException e) {
			System.out.println(e.getErrorCode());
			System.out.println(e.getMessage());
		}
	}
}
