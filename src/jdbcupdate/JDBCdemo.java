package jdbcupdate;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCdemo {
		
			public static void main(String[] args) throws Exception {
			Scanner sc = new Scanner(System.in);		
			Class.forName("com.mysql.jdbc.Driver");// static block of Driver class will be executed
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/test","root","root");
		    //PreparedStatement ps=con.prepareStatement("create table Emp(admin varchar(15),phone int,role varchar(15))");
			//ps.executeUpdate();
			//PreparedStatement ps1 = con.prepareStatement("create table faculty(admin varchar(15),phone int,role varchar(15))");
			//ps1.executeUpdate();
			//PreparedStatement ps2 = con.prepareStatement("create table student(admin varchar(15),phone int,role varchar(15))");
			//ps2.executeUpdate();
			//PreparedStatement ps3 = con.prepareStatement("create table Teacher(admin varchar(15),phone int,role varchar(15))");
			//ps3.executeUpdate();
			PreparedStatement ps = con.prepareStatement("create table HR_Sec(eid int,ename varchar(15),ephone int)");
			ps.executeUpdate();
			System.out.println("Table created");
			
		}
	}



	
	