package database.connector;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Windyl
 */
import java.sql.*;


public class Connector {
    
   public Connection getConnection(){
        String username = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/library_db";
        String driver_class = "com.mysql.cj.jdbc.Driver";
        try{
            Connection conn = DriverManager.getConnection(url,username,password);
            Class.forName(driver_class);
            System.out.println("Database Connected");
            
            return conn;
         
            
        }catch(Exception e){
            System.out.println("Error whule connecting to DB");
            e.printStackTrace();
        }
        return null;
        
   
    }
    
    
}
