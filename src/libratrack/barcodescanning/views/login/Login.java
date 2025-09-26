/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libratrack.barcodescanning.views.login;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author Windyl
 */

public class Login extends Application {
    
    public static void main(String[] args){
        launch(args);   
    }
    
    @Override
    public void start(Stage primarystage) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(parent);
        primarystage.setScene(scene);
        primarystage.show();
        
          
    }
}
