package jdbcupdate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SqlUpdate {
public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		//DriverManager.registerDriver(new Driver());
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/test","root","");
	
		PreparedStatement ps=con.prepareStatement("alter table student add column(salary int)");
		
		ps.executeUpdate();
			
		System.out.println("column created");
	}
}

