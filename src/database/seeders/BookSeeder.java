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
public class BookSeeder {
    public static void main(String args[]){

        //Initializes the connection and faker
       Connector connector = new Connector();
       Faker faker = new Faker();   
       Connection connect = connector.getConnection();
       //For the id year and unique id format
       LocalDate date = LocalDate.now();
       String[] splitdate = String.valueOf(date).split("-");
     

       
       
       for(int a = 0;a != 500 ; a++){
           String title = faker.book().title();
           String author = faker.name().fullName();
           String isbn = faker.number().digits(6);
           String category = faker.book().genre();
           String barcode = faker.number().digits(4);
           String[] status = {"Available","Borrowed"};
           int edition = faker.number().randomDigitNotZero();
           String year_published = splitdate[0]+"-"+splitdate[1]+"-"+splitdate[2];
           int random = (int) Math.ceil(Math.random() * status.length - 1);
          try{ 
          String query ="INSERT INTO book (title, author, book_isbn, category, barcode, status,edition,year_published) VALUES (?, ?, ?, ?, ?, ?,?,?)";
          PreparedStatement statement = connect.prepareStatement(query);
          
          statement.setString(1, title);
          statement.setString(2, author);
          statement.setString(3, isbn);
          statement.setString(4, category);
          statement.setString(5, barcode);
          statement.setString(6, status[random]);
          statement.setInt(7, edition);
          statement.setString(8, year_published);
          
          
          System.out.println("Statement"+statement);
          
          int rowsInserted = statement.executeUpdate();
          
          if(rowsInserted  > 0){
              System.out.println("Row inserted");
              
          }
          
          
          
          }catch(Exception e){ 
              e.printStackTrace();
          
          }
       }
       
    }
    
}
