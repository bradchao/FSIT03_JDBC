

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class JDBC04 {
	public static void main(String[] args) {
	
		// -------------------
		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "root");
		
		try(Connection conn = 
			DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1/brad",prop)){
			// 3. SQL statement
			String sql = "INSERT INTO cust (cname,tel,birthday) VALUES (?,?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "Peter1");
			pstmt.setString(2, "321");
			pstmt.setString(3, "1998-05-09");
			pstmt.execute();
			
			pstmt.setString(1, "Peter2");
			pstmt.setString(2, "321");
			pstmt.setString(3, "1998-05-09");
			pstmt.execute();

			pstmt.setString(1, "Peter3");
			pstmt.setString(2, "321");
			pstmt.setString(3, "1998-05-09");
			pstmt.execute();
			
			// 4. query
			

		}catch(Exception e){
			System.out.println(e);
		}
		
		
		
	}
}
