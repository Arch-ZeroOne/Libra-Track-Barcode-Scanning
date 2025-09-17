/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database.seeders;

import database.connector.Connector;
import java.sql.*;
import java.time.LocalDate;
import com.github.javafaker.*;
import java.util.*;
/**
 *
 * @author Windyl
 */


public class StudentSeeder {
    
    public static void main(String args[]){
       Connector connector = new Connector();
       Faker faker = new Faker();   
      
       Connection connect = connector.getConnection();
       
//       String streetname = faker.address().streetName();
//       String number = faker.address().buildingNumber();
//       String city = faker.address().city();
//       
//       System.out.println("Streetname:"+streetname+" Number:"+number+" City:"+city);
       
    try{ 
        LocalDate date = LocalDate.now();
        String[] splitdate = String.valueOf(date).split("-");
        System.out.println(Arrays.toString(splitdate));
        
       if(connect != null){
           for(int a = 0; a + 1 != 5; a++){
            String[] years  = {"1st","2nd", "3rd" , "4th"};
            String[] sections  = {"D","C","B","A"};
            int rand = (int)Math.ceil( Math.random() * years.length - 1) ;
            String firstname = faker.name().firstName();
            String middlename = faker.name().lastName();
            String lastname = faker.name().lastName();
            String year = years[rand];  
            String section = sections[rand];
            String idnumber = faker.number().digits(4);
            
            System.out.println(splitdate[0]+"-"+idnumber);

             
            
           
            
          //Currently working on inserting the data in the database
            
     String query = "INSERT INTO student(firstname,lastname,middlename,lastname,year,section,id_number)"
             +      "VALUES("+firstname+","+middlename+","+lastname+","+year+","+section+","+idnumber;       
     Statement statement = connect.createStatement();
     ResultSet result = statement.executeQuery(query);
               
           }
         
           
           
         
           
       }
       
      }catch(Exception e){
           System.out.println("Error executing query");
           e.printStackTrace();
       }
           
    }
    
}
