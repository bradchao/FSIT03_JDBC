import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBC09 {

	public static void main(String[] args) {
		// -------------------
		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "root");
		
		try (Connection conn = 
			DriverManager.getConnection("jdbc:mysql://127.0.0.1:8889/brad", 
				prop)){
			Statement stmt = conn.createStatement();
			
			String account = "eric", passwd = "12345";
			
			String[] result;
			if ( (result = checkMember(stmt, account, passwd)) != null){
				System.out.println("Welcome, " + result[3]);
			}else{
				System.out.println("Error Login");
			}
			
			
			System.out.println("OK");
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	static String[] checkMember(Statement stmt, String account, String passwd) throws Exception {
		String[] ret = new String[4];
		
		String sql = "SELECT * from member where account = '" + 
				account + "' and passwd = '" + passwd + "'";
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next()){
			// right member
			ret[0] = rs.getString(1);
			ret[1] = rs.getString(2);
			ret[2] = rs.getString(3);
			ret[3] = rs.getString(4);
		}else{
			// error account
			ret = null;
		}
		
		return ret;
	}
	

}
