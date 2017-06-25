import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.OpenOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBC15 {

	public static void main(String[] args) {
		// -------------------
		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "root");
		
		try (Connection conn = 
			DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:8889/brad", prop)){
			
			PreparedStatement pstmt = 
					conn.prepareStatement("SELECT * FROM member WHERE id = 2");
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			
			ObjectInputStream in = new ObjectInputStream(rs.getBinaryStream("obj"));
			Student s3 = (Student)(in.readObject());
			System.out.println("read obj => " + s3.getId()+":" + s3.total() + ":"  + s3.avg());
			in.close();
			
			System.out.println("OK");
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
}
