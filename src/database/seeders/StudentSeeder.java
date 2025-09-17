/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database.seeders;

import database.connector.Connector;
import java.sql.*;
import com.github.javafaker.*;
/**
 *
 * @author Windyl
 */
public class StudentSeeder {
    
    public static void main(String args[]){
       Connector connector = new Connector();
       Faker faker = new Faker();   
      
       Connection connect = connector.getConnection();
       String address = faker.address().cityName();
       
       System.out.println(address);
       
//       String streetname = faker.address().streetName();
//       String number = faker.address().buildingNumber();
//       String city = faker.address().city();
//       
//       System.out.println("Streetname:"+streetname+" Number:"+number+" City:"+city);
       
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
