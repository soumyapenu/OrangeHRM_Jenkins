package com.OrangeHRM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class ConnectDB_Direct_Example {

	@Test
	public void  ConnectSQLDB() throws  ClassNotFoundException, SQLException {													
		//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
        String dbUrl = "jdbc:mysql://localhost:3306/demo_orangehrm";					
		//Database Username		
		String username = "root";	
		//Database Password		
		String password = "abcd1234";				
		//Query to Execute		
		String query = "select * from hrm_login;";	
 	    //Load mysql jdbc driver		
   	    Class.forName("com.mysql.jdbc.Driver");			
   		//Create Connection to DB		
    	Connection con = DriverManager.getConnection(dbUrl,username,password);
  		//Create Statement Object		
	   Statement stmt = con.createStatement();					
			// Execute the SQL Query. Store results in ResultSet		
 		ResultSet rs= stmt.executeQuery(query);							
 
 		// While Loop to iterate through all data and print results		
		while (rs.next()){
	        		String Username = rs.getString("uname");								        
                    String Password = rs.getString(3);					                               
                    System. out.println(Username+"  "+Password);
                    
            }		
			 // closing DB Connection		
			con.close();			
}
}
