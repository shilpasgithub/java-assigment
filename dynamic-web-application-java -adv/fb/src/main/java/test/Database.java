package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Database {
	public static Connection start() 
		    throws SQLException, ClassNotFoundException 
		{ 
			Class.forName("com.mysql.jdbc.Driver"); 
		    // Initialize all the information regarding 
		    // Database Connection  
		    String url = "jdbc:mysql://localhost:3306/facebook"; 
		    // Database name to access 
		     
		    String user = "root01"; 
		    String pass = "6209"; 

		    Connection con = DriverManager.getConnection(url , 
		                                                 user,  
		                                                 pass); 
		    return con; 
		}
	
	public static String passwordCheck(String username) throws ClassNotFoundException, SQLException {
		try(Connection connection = Database.start();
	            Statement stmt = connection.createStatement();
	        ) {
			
			String query = "SELECT password FROM info WHERE username =?";
	                
				
	                PreparedStatement pstmt = connection.prepareStatement(query);
	                pstmt.setString(1, username);
	                ResultSet resultSet = pstmt.executeQuery();

	                if (resultSet.next()) {
	                    String password = resultSet.getString("password");
	                    return(password);
	                    
	                } 
	                return null;}
	}

	public static void setInfo(String username, String password, String bio) throws ClassNotFoundException, SQLException {
		try(Connection conn = Database.start();
	            Statement stmt = conn.createStatement();
	        ) {
			
			String query = "INSERT INTO info VALUES(?,?,?)";
	                
				
	                PreparedStatement statement = conn.prepareStatement(query);
	                statement.setString(1, username);
	                statement.setString(2, password);
	                statement.setString(3, bio);
	                
	                statement.executeUpdate();
	                } 
	                
		}
	public static void newbio(String username, String bioval) throws ClassNotFoundException, SQLException {
		try(Connection conn = Database.start();
	            Statement stmt = conn.createStatement();
	        ) {
			
			String query = "UPDATE info set bio=? where username=?";
	                
				
	                PreparedStatement statement = conn.prepareStatement(query);
	                statement.setString(1, bioval);
	                statement.setString(2, username);
	                
	                statement.executeUpdate();
	                } 
	}
	public static void deleteAccount(String username) throws ClassNotFoundException, SQLException {
		try(Connection conn = Database.start();
	            Statement stmt = conn.createStatement();
	        ) {
			
			String query = "DELETE FROM info where username=?";
			PreparedStatement statement = conn.prepareStatement(query);
	        statement.setString(1, username);
	        statement.executeUpdate();
	        
	                } 
	}
	public static String[] getinfo(String username) throws ClassNotFoundException, SQLException {
		try(Connection conn = Database.start();
	            Statement stmt = conn.createStatement();
	        ) {
			
			String query = "select * from info where username= ?";
	                
				
	                PreparedStatement statement = conn.prepareStatement(query);
	                statement.setString(1, username);
	                ResultSet rs= statement.executeQuery();
	                String[] array = new String[2];
	                while(rs.next())
	                {
	                	array[0] = rs.getString("username");
	                	array[1] = rs.getString("bio");
	                }
	               return array;
	           } 
	}
}
