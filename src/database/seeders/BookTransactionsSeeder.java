/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database.seeders;
import com.github.javafaker.Faker;
import database.connector.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Windyl
 */
public class BookTransactionsSeeder {
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
               
               for(int a = 0; a != 500; a++){
                   
                   // Generate random student_id and book_id
                   int student_id = faker.number().numberBetween(1000, 9999);
                   int book_id = faker.number().numberBetween(1, 1000);
                   
                   // Generate borrow date (past 30 days)
                   Date borrow_date = new Date(faker.date().past(30, TimeUnit.DAYS).getTime());
                   
                   // Generate return date (either null for active loans or future date)
                   Date return_date = null;
                   int status = faker.number().numberBetween(0, 2); // 0 = returned, 1 = active/borrowed
                   
                   if(status == 0) {
                       // If returned, generate return date after borrow date
                       return_date = new Date(faker.date().future(20, TimeUnit.DAYS, borrow_date).getTime());
                   }
                   
                   //Preparing query
                   String query = "INSERT INTO book_transactions (student_id, book_id, borrow_date_time, return_date_time, status) VALUES (?, ?, ?, ?, ?)";
                   PreparedStatement statement = connect.prepareStatement(query);
                   
                   statement.setInt(1, student_id);
                   statement.setInt(2, book_id);
                   statement.setDate(3, borrow_date);
                   if(return_date != null) {
                       statement.setDate(4, return_date);
                   } else {
                       statement.setNull(4, java.sql.Types.DATE);
                   }
                   statement.setInt(5, status);
                   
                   System.out.println("Statement: " + statement);
                   int rowsInserted = statement.executeUpdate();
                   if(rowsInserted > 0){
                       System.out.println("Transaction record inserted - Student ID: " + student_id + 
                                        ", Book ID: " + book_id + ", Status: " + (status == 1 ? "Active" : "Returned"));
                   }
               }
           }
           
       } catch(Exception e) {
           e.printStackTrace();
       }
    }
}