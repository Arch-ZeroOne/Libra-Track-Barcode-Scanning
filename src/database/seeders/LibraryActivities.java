/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database.seeders;

import com.github.javafaker.Faker;
import database.connector.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author Windyl
 */
public class LibraryActivities {
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
               
               for(int a =0; a != 500; a++){
                   
                   int student_id = (int) faker.number().randomNumber();
                   String activity_types[] = {"Login","Borrow Book", "Return Book", "Description"};
                   String description = faker.lorem().sentence();
                   Date activity_starttime = faker.date().birthday();
                   Date activitity_endtime = faker.date().birthday();
                   String get_type = activity_types[(int) Math.ceil(Math.random() * activity_types.length -1) ];
                   
                    //Preparing query
                    String query ="INSERT INTO library_activities ( activity_type, activity_description,activity_starttime,activity_endtime,student_id) VALUES (?, ?, ?, ?,?)";
                    PreparedStatement statement = connect.prepareStatement(query);
                   

                   
                    statement.setString(1, get_type);
                    statement.setString(2, description);
                    statement.setString(3,String.valueOf(activity_starttime));
                    statement.setString(4, String.valueOf(activitity_endtime));
                    statement.setInt(5, student_id);

                    System.out.println("Statement:"+statement);

                    int rowsInserted = statement.executeUpdate();

                    if(rowsInserted > 0){
                        System.out.println("Rows are inserted");

                    }
                   
               }
               
               
           }
           
       }catch(Exception e){
           e.printStackTrace();
       }
        
    }
    
}
