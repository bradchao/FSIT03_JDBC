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
			
			Member loginMember;
			if ( (loginMember = checkMember(stmt, account, passwd)) != null){
				System.out.println("Welcome, " + loginMember.realname);
			}else{
				System.out.println("Error Login");
			}
			
			
			System.out.println("OK");
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	static Member checkMember(Statement stmt, String account, String passwd) throws Exception {
		String sql = "SELECT * from member where account = '" + 
				account + "' and passwd = '" + passwd + "'";
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next()){
			// right member
			Member member = new Member(rs.getString("id"),
					rs.getString("account"),
					rs.getString("realname"));
			return member;
		}else{
			return null;
		}
	}
}
class Member {
	String id, account, realname;
	Member(String id, String account, String realname){
		this.id=id;
		this.account=account;
		this.realname=realname;
	}
	
}
