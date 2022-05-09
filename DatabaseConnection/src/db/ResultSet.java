package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ResultSet {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con = null;
		java.sql.Statement statement=null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "Pramila@123");
			System.out.println("connected");
			System.out.println(con.getClass().getName());
			statement=con.createStatement();
			String query="select *from customers";
			java.sql.ResultSet resultset= statement.executeQuery(query);
			while(resultset.next()) {
				System.out.println(resultset.getInt(1));
				System.out.println(resultset.getString(2));
				System.out.println(resultset.getString(3));
				}
				
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




