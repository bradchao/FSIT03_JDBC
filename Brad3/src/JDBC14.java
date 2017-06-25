import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBC14 {

	public static void main(String[] args) {
		// -------------------
		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "root");
		
		try (Connection conn = 
			DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:8889/brad", prop)){
			
			Student s1 = new Student("0002",70,20,60);
			System.out.println(s1.getId() + ":" + s1.total() + ":" + s1.avg());
			
			//Bike b1 = new Bike();
			
			
			PreparedStatement pstmt2 = 
					conn.prepareStatement("UPDATE member set obj = ? where id = 2");
			pstmt2.setObject(1, s1);
			pstmt2.executeUpdate();
			
			
			
			
			
			System.out.println("OK");
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
}
