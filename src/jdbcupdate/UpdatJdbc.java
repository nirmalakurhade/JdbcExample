package jdbcupdate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UpdatJdbc {
	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver");// static block of Driver class will be executed
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/test", "root", "root");
		Statement p = con.createStatement();
		p.executeUpdate("insert into data(admin,phone,role) values('nirmala',9065432,'Teacher')");

		p.executeUpdate("insert into data(admin,phone,role) values('vijay',9935432,'Faculty')");

		p.executeUpdate("insert into data(admin,phone,role) values('advik',8823432,'student')");

		p.executeUpdate("insert into data(admin,phone,role) values('pritam',8973632,'Teacher')");

		p.executeUpdate("insert into data(admin,phone,role) values('supriya',9073432,'Faculty')");
		System.out.println("Record Inserted");

		PreparedStatement ps1 = con.prepareStatement("insert into student values(?,?,?)");

		PreparedStatement ps2 = con.prepareStatement("insert into Teacher values(?,?,?)");

		PreparedStatement ps3 = con.prepareStatement("insert into Faculty values(?,?,?)");

		PreparedStatement ps4 = con.prepareStatement("select * from data");
		ResultSet r = ps4.executeQuery();

		while (r.next()) {

			String admin = r.getString("admin");
			int phone = r.getInt("phone");
			String role = r.getString("role");

			if (role.equals("student")) {
				ps1.setString(1, admin);
				ps1.setInt(2, phone);
				ps1.setString(3, role);
				ps1.executeUpdate();
			} else if (role.equals("Teacher")) {
				ps2.setString(1, admin);
				ps2.setInt(2, phone);
				ps2.setString(3, role);
				ps2.executeUpdate();
			} else {
				ps3.setString(1, admin);
				ps3.setInt(2, phone);
				ps3.setString(3, role);
				ps3.executeUpdate();
			}
		}
	}
}