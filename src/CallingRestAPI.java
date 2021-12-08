import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class CallingRestAPI {
	
	public static void main(String[] args) throws Exception {
				
		String urlString="http://localhost:8082/student/2";
		URL url = new URL(urlString);
		
		HttpURLConnection huc=(HttpURLConnection) url.openConnection();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(huc.getInputStream()));
		
		String s =br.readLine();// storing jsonstring given by webservice into s
		
		//{"rno":2,"marks":70}
		
		String[] str=s.split(",");//str==> {   [{"rno":2]    ["marks":70}]  }
		
		ArrayList<String>  al = new ArrayList<String>();
				
		for(String s1 : str)
		{
			//System.out.println(s1);
			
			String value=s1.split(":")[1].replace('}',' ');
			
			al.add(value);
			
		}
		
		
		System.out.println(al);
		
		
		String query="insert into student(rno,marks) values(?,?)";
		
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());

		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/newsql","root","root");
		
		PreparedStatement ps = con.prepareStatement(query);
		
		ps.setString(1, al.get(0));
		
		ps.setString(2, al.get(1));
		
		ps.execute();
		
		System.out.println("Record added");
		
//		for(String s1 : str)
//		{
//			System.out.println(s1);
//			//System.out.println(s1.indexOf("\""));
//			//System.out.println(s1.lastIndexOf("\""));
//			
//			int start=s1.indexOf("\"");
//			int end=s1.lastIndexOf("\"");
//			
//			System.out.println(s1.substring(start+1,end));
//		}
		
		
		
	}

}
