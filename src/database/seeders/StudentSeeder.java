/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database.seeders;
import com.github.javafaker.Faker;
import database.connector.Connector;
import java.sql.*;
/**
 *
 * @author Windyl
 */
public class StudentSeeder {
    
    public static void main(String args[]){
       Connector connector = new Connector();
       Connection connect = connector.getConnection();
       
       try{
       if(connect != null){
           String select = "SELECT * FROM student";
           Statement statement = connect.createStatement();
           ResultSet query = statement.executeQuery(select);
           
           
           while(query.next()){
               int id = query.getInt("student_id");
                       
               System.out.println(id);
           }
           
          
           
       }
       
       }catch(Exception e){
           System.out.println("Error executing query");
           e.printStackTrace();
       }
       
           
        
        
        
    }
    
   
    
    
}
