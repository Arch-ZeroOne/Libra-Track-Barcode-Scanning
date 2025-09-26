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
       //Initializes the connection and faker
       Connector connector = new Connector();
       Faker faker = new Faker();   
       Connection connect = connector.getConnection();
       //For the id year and unique id format
       LocalDate date = LocalDate.now();
       String[] splitdate = String.valueOf(date).split("-");
       System.out.println(Arrays.toString(splitdate));
    
    try{ 
       if(connect != null){
          for(int a = 0; a + 1 != 50; a++){
            String[] years  = {"1st","2nd", "3rd" , "4th"};
            String[] sections  = {"D","C","B","A"};
            int rand = (int)Math.ceil( Math.random() * years.length - 1) ;
            String firstname = faker.name().firstName();
            String middlename = faker.name().lastName();
            String lastname = faker.name().lastName();
            String year = years[rand];  
            String section = sections[rand];
            String idnumber = faker.number().digits(4);
            String barcode = faker.number().digits(4);
            String cellphone_number = faker.number().digits(11);
            
            
            //Preparing query
            String query ="INSERT INTO student (firstname, middlename, lastname, year, section, id_number, barcode, cellphone_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connect.prepareStatement(query);

            //Set values from the placeholders (?)
            statement.setString(1, firstname);
            statement.setString(2, middlename);
            statement.setString(3,lastname);
            statement.setString(4,year);
            statement.setString(5,section);
            statement.setString(6, splitdate[0]+"-"+idnumber);
            statement.setString(7, barcode);
            statement.setString(8, cellphone_number);

            System.out.println("Statement:"+statement);

            //check if any rows are inserted
            int rowsInserted = statement.executeUpdate();

            if(rowsInserted > 0){
                System.out.println("Rows are inserted");

            }
        
           }    
        
      }
       
      }catch(Exception e){
           System.out.println("Error executing query");
           e.printStackTrace();
       }
           
    }
    
}
