package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JBDCConnection {
	String url="jdbc:mysql://localhost:3306/officed1";
	String username = "root";
	String password = "MAVERIK27";
	public JBDCConnection(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url,username,password);
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from users");

			while (rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+ rs.getString(4)+" "+ rs.getString(5)+" "+rs.getString(6));

			}
			connection.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
