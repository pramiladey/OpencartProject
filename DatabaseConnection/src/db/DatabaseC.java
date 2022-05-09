package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class DatabaseC {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con = null;
		java.sql.Statement statement=null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_practice", "root", "Pramila@123");
			System.out.println("connected");
			System.out.println(con.getClass().getName());
			statement=con.createStatement();
			String query="insert into employee values(10,'reva')";
			int records=statement.executeUpdate(query);
			if(records>0) {
				System.out.println("record inserted");}
			
			else {
				System.out.println("not inserted");}
			
		}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
		catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
			con.close();
		}
			catch(SQLException e) {
				e.printStackTrace();
			}
	}}}

