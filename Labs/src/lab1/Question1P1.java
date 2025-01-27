
package lab1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.ResultSet; 
import java.sql.SQLException; 


public class Question1P1 {
	
	public static void main(String[] args) {
		
		MysqlDataSource mysqlds = new MysqlDataSource();
		mysqlds.setURL("jdbc:mysql://localhost:3306/salespersondb?serverTimezone=UTC");
		mysqlds.setUser("root");
		mysqlds.setPassword("root");
		
		try {
			Connection conn = mysqlds.getConnection();
			System.out.println("Finished");
			
			Statement myStmt = conn.createStatement();
			String query = "SELECT * FROM salesperson_table";
			
			ResultSet rs = myStmt.executeQuery(query);
			
			while (rs.next()) {
				String sid = rs.getString("sid");
				String fname = rs.getString("fname");
				String sname = rs.getString("surname");
				Date dob = rs.getDate("dob");
				String city = rs.getString("city");
				Double commission = rs.getDouble("commission");
				
				System.out.println(sid + "\t" + 
						fname + "\t" + 
						sname + "\t" + 
						dob + "\t" + 
						city + "\t" + 
						commission + "\t"
						);
			}
			
			conn.close();
			myStmt.close();
			rs.close();
			System.out.println("\nConnection closed successfully");
			
		} catch (SQLException e) {
			System.out.println(e.getErrorCode());
			System.out.println(e.getMessage());
		}
		
		
		
	}

}
